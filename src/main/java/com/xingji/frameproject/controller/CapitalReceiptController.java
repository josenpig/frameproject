package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.*;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.ReceiptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private CapitalReceivableService crsok;
    @Resource
    private CapitalReceiptBillService crbs;
    @Resource
    private CapitalReceiptAccountService cras;
    @Resource
    private BaseCapitalAccountService bras;
    @Resource
    private SaleOrderService sos;
    @Resource
    private SaleDeliveryService sds;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/find/{id}")
    public AjaxResponse selectOne(@PathVariable("id") String id) {
        CapitalReceipt receipt=crs.queryById(id);
        List<CapitalReceiptBill> bills=crbs.queryById(id);
        List<CapitalReceiptAccount> accounts=cras.queryById(id);
        ReceiptVo vo=new ReceiptVo();
        vo.setReceipt(receipt);
        vo.setBills(bills);
        vo.setAccounts(accounts);
        return AjaxResponse.success(vo);
    }
    @PostMapping("/addreceipt/{type}")
    public AjaxResponse addreceipt(@PathVariable("type") int type,@RequestBody String add) {
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("receipt");
        CapitalReceipt receipt = JSON.parseObject(one, CapitalReceipt.class);
        String two = jsonObject.getString("bill");
        List<CapitalReceiptBill> bills= JSONArray.parseArray(two, CapitalReceiptBill.class);
        String three = jsonObject.getString("account");
        List<CapitalReceiptAccount> accounts= JSONArray.parseArray(three, CapitalReceiptAccount.class);
        //绑定收款单
        for (int i=0;i<bills.size();i++){
            if (bills.get(i).getSaleType().equals("销售订单")){
                SaleOrder saleOrder=new SaleOrder();
                saleOrder.setOrderId(bills.get(i).getSaleId());
                saleOrder.setReceiptId(receipt.getReceiptId());
                sos.update(saleOrder);
            }
            if (bills.get(i).getSaleType().equals("销售出库单")){
                SaleDelivery saleDelivery=new SaleDelivery();
                saleDelivery.setDeliveryId(bills.get(i).getSaleId());
                saleDelivery.setReceiptId(receipt.getReceiptId());
                sds.update(saleDelivery);
            }
            bills.get(i).setReceiptId(receipt.getReceiptId());
        }
        for (int j=0;j<accounts.size();j++){
            accounts.get(j).setReceiptId(receipt.getReceiptId());
        }
        receipt.setApprovalState(type);
        receipt.setFoundTime(new Date());
        receipt.setUpdateTime(new Date());
        crs.insert(receipt);
        crbs.insertBatch(bills);
        cras.insertBatch(accounts);
        return AjaxResponse.success(receipt.getReceiptId());
    }
    @PostMapping("/conditionpage")
    public AjaxResponse conditionpage(@RequestBody String conditionpage) {
        JSONObject jsonObject = JSONObject.parseObject(conditionpage);
        String condition = jsonObject.getString("condition");//查询条件--实体类
        CapitalReceipt capitalReceipt=JSON.parseObject(condition, CapitalReceipt.class);
        int currentPage = Integer.parseInt(jsonObject.getString("currentPage"));
        int pageSize = Integer.parseInt(jsonObject.getString("pageSize"));
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<CapitalReceipt> list=crs.queryAll(capitalReceipt);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    /**
     * 修改订单审批状态
     * @param orderid 主键
     * @return 数据
     */
    @GetMapping("/approval")
    public AjaxResponse approvalorder(String orderid,int type,String user,String approvalremarks){
        //修改收款单信息
        CapitalReceipt receipt=new CapitalReceipt();
        receipt.setReceiptId(orderid);
        receipt.setApprovalState(type);
        receipt.setApprover(user);
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
                CapitalReceiptBill bill=new CapitalReceiptBill();
                bill.setReceivedMoney(bills.get(i).getReceivedMoney()+bills.get(i).getThisMoney());
                bill.setUncollectedMoney(bills.get(i).getReceiptMoney()-bills.get(i).getReceivedMoney()-bills.get(i).getThisMoney());
                bill.setSaleId(bills.get(i).getSaleId());
                crbs.update(bill);
                if (bills.get(i).getSaleType().equals("销售出库单")) {
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
                bras.currentAmountadd(baseaccount);
            }
        }
        return AjaxResponse.success(true);
    }
}