package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.annotation.Log;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.*;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.util.MessageUtil;
import com.xingji.frameproject.vo.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * (CapitalReceipt)表控制层
 *
 * @author makejava
 * @since 2021-06-02 20:20:54
 */
@RestController
@RequestMapping("/capitalReceipt")
public class CapitalReceiptController {
    /**
     * 服务对象
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private CapitalReceiptService crs;
    @Resource
    private SysUserService sus;
    @Resource
    private CapitalReceivableService crsok;
    @Resource
    private CapitalReceiptBillService crbs;
    @Resource
    private CapitalReceiptAccountService cras;
    @Resource
    private BaseCapitalAccountService bcas;
    @Resource
    private SaleOrderService sos;
    @Resource
    private SaleDeliveryService sds;
    @Resource
    private SaleReturnService srs;
    @Resource
    private MessageUtil messageUtil;

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @Log("查询单个收款单")
    @GetMapping("/find/{id}")
    public AjaxResponse selectOne(@PathVariable("id") String id) {
        CapitalReceipt receipt=crs.queryById(id);
        List<CapitalReceiptBill> bills=crbs.queryById(id);
        List<CapitalReceiptAccount> accounts=cras.queryById(id);
        ReceiptVo vo = new ReceiptVo();
        receipt.setFounder(sus.queryById(Integer.valueOf(receipt.getFounder())).getUserName());
        if(receipt.getApprover()!=null) {
            receipt.setApprover(sus.queryById(Integer.valueOf(receipt.getApprover())).getUserName());
        }
        receipt.setPayee(sus.queryById(Integer.valueOf(receipt.getPayee())).getUserName());
        for (int i=0;i<accounts.size();i++) {
            BaseCapitalAccountVo basevo = new BaseCapitalAccountVo();
            basevo.setCapitalId(accounts.get(i).getFundAccount());
            BaseCapitalAccountVo list = bcas.queryAllVo(basevo).get(0);
            BaseCapitalAccount account = bcas.queryById(accounts.get(i).getFundAccount());
            accounts.get(i).setFundAccount(account.getFundAccount());
            accounts.get(i).setSettlementType(list.getSettlementType());
            vo.setReceipt(receipt);
            vo.setBills(bills);
            vo.setAccounts(accounts);
        }
        return AjaxResponse.success(vo);
    }

    @Log("新增收款单")
    @PostMapping("/addreceipt/{type}")
    public AjaxResponse addreceipt(@PathVariable("type") int type,@RequestBody String add) {
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("receipt");
        CapitalReceipt receipt = JSON.parseObject(one, CapitalReceipt.class);
        String two = jsonObject.getString("bill");
        List<CapitalReceiptBill> bills= JSONArray.parseArray(two, CapitalReceiptBill.class);
        String three = jsonObject.getString("account");
        List<CapitalReceiptAccount> accounts= JSONArray.parseArray(three, CapitalReceiptAccount.class);
        //判断该订单是否为编辑单-----若为编辑单则修改数据
        if(receipt.getApprovalState()!=null) {
            cras.deleteById(receipt.getReceiptId());//将原有的订单详情删除
            crbs.deleteById(receipt.getReceiptId());
            //判断该单据是否为二次提交单据及驳回单或作废单
            if(receipt.getApprovalState()==-1){
                receipt.setApprover("清空");
                receipt.setApprovalRemarks("清空");
            }
            receipt.setApprovalState(type);//订单状态
            receipt.setUpdateTime(new Date());
            crs.update(receipt);
        }else {
            receipt.setFounder(String.valueOf(sus.queryUserIdByUserName(receipt.getFounder())));
            receipt.setApprovalState(type);
            receipt.setFoundTime(new Date());
            crs.insert(receipt);
            if(type==0){
                messageUtil.addMessage(Integer.parseInt(receipt.getFounder()),receipt.getReceiptId());
            }
        }
        //绑定收款单
        for (int i = 0; i < bills.size(); i++) {
            bills.get(i).setReceiptId(receipt.getReceiptId());
        }
        for (int j = 0; j < accounts.size(); j++) {
            accounts.get(j).setReceiptId(receipt.getReceiptId());
        }
        crbs.insertBatch(bills);
        cras.insertBatch(accounts);
        return AjaxResponse.success(receipt.getReceiptId());
    }

    @Log("分页多条件查询收款单")
    @PostMapping("/conditionpage")
    public AjaxResponse conditionpage(@RequestBody String conditionpage) {
        JSONObject jsonObject = JSONObject.parseObject(conditionpage);
        String condition = jsonObject.getString("condition");//查询条件--实体类
        CapitalConditionPageVo vo=JSON.parseObject(condition, CapitalConditionPageVo.class);
        int currentPage = Integer.parseInt(jsonObject.getString("currentPage"));
        int pageSize = Integer.parseInt(jsonObject.getString("pageSize"));
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<CapitalReceipt> list=crs.queryAll(vo);
        for(int i=0;i<list.size();i++){
            list.get(i).setFounder(sus.queryById(Integer.valueOf(list.get(i).getFounder())).getUserName());
            if(list.get(i).getApprover()!=null){
                list.get(i).setApprover(sus.queryById(Integer.valueOf(list.get(i).getApprover())).getUserName());
            }
            list.get(i).setPayee(sus.queryById(Integer.valueOf(list.get(i).getPayee())).getUserName());
        }
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    /**
     * 修改订单审批状态
     * @param orderid 主键
     * @return 数据
     */
    @Log("修改订单审批状态")
    @GetMapping("/approval")
    public AjaxResponse approvalorder(String orderid,int type,String user,String approvalremarks){
        //判断订单收款金额是否能够通过审批
        if(type == 1){
            CapitalReceipt receipt=crs.queryById(orderid);
            List<CapitalReceiptBill> bills=crbs.queryById(receipt.getReceiptId());
            for (int i=0;i<bills.size();i++) {
                if (bills.get(i).getSaleType().equals("销售出库单")||bills.get(i).getSaleType().equals("销售退货单")) {
                    CapitalReceivable ok=crsok.queryById(bills.get(i).getSaleId());
                    if(ok.getCaseState()==1){
                        return AjaxResponse.success("订单："+ok.getDeliveryId()+"已结案");
                    }
                }else if (bills.get(i).getSaleType().equals("销售订单")){
                    SaleOrder ok=sos.queryById(bills.get(i).getSaleId());
                    if (ok.getAdvance()+bills.get(i).getThisMoney()>ok.getReceivables()){
                        return AjaxResponse.success("订单："+ok.getOrderId()+"预收款金额不足");
                    }
                }
            }
        }
        //修改收款单信息
        CapitalReceipt receipt=new CapitalReceipt();
        receipt.setReceiptId(orderid);
        receipt.setApprovalState(type);
        receipt.setApprover(String.valueOf(sus.queryUserIdByUserName(user)));
        receipt.setApprovalRemarks(approvalremarks);
        receipt.setLastApprovalTime(new Date());
        receipt.setUpdateTime(new Date());
        crs.update(receipt);
        if(type == 1){
            //订单通过修改单据已收款
            CapitalReceivable receivable=new CapitalReceivable();
            List<CapitalReceiptBill> bills=crbs.queryById(receipt.getReceiptId());
            for (int i=0;i<bills.size();i++) {
                //修改单据收款金额
                SaleOrder order=new SaleOrder();
                if (bills.get(i).getSaleType().equals("销售出库单")||bills.get(i).getSaleType().equals("销售退货单")) {
                    //修改应收款信息
                    receivable.setDeliveryId(bills.get(i).getSaleId());
                    receivable.setLastCollectionTime(new Date());
                    receivable.setReceiptRemark(approvalremarks);
                    receivable.setReceived(bills.get(i).getThisMoney());
                    CapitalReceivable tf=crsok.receivedadd(receivable);
                    if(tf.getUncollected()==0){
                        tf.setCaseState(1);
                        crsok.update(tf);
                    }
                }
                if (bills.get(i).getSaleType().equals("销售订单")) {
                    //修改订单已收款信息
                    order.setOrderId(bills.get(i).getSaleId());
                    order.setUpdateTime(new Date());
                    order.setAdvance(bills.get(i).getThisMoney());
                    sos.advanceadd(order);
                }
            }
            //订单通过增加账户资金
            BaseCapitalAccount baseaccount=new BaseCapitalAccount();
            List<CapitalReceiptAccount> accounts=cras.queryById(receipt.getReceiptId());
            for (int j=0;j<accounts.size();j++) {
                baseaccount.setFundAccount(accounts.get(j).getFundAccount());
                baseaccount.setCurrentAmount(accounts.get(j).getThisMoney());
                bcas.currentAmountadd(baseaccount);
            }
        }
        messageUtil.addMessages(Integer.parseInt(receipt.getApprover()),Integer.parseInt(crs.queryById(orderid).getFounder()),orderid,type);
        return AjaxResponse.success(true);
    }
}