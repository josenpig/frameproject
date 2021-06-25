package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.*;
import com.xingji.frameproject.vo.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (CapitalPayment)表控制层
 *
 * @author makejava
 * @since 2021-06-16 19:14:13
 */
@RestController
@RequestMapping("/capitalPayment")
public class CapitalPaymentController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sus;
    @Resource
    private CapitalPayableService cpsok;
    @Resource
    private PurchaseOrderService pos;
    @Resource
    private PurchaseReceiptService prs;
    @Resource
    private PurchaseReturnsService preturnss;
    @Resource
    private BaseCapitalAccountService bcas;
    @Resource
    private CapitalPaymentService cps;
    @Resource
    private CapitalPaymentBillService cpbs;
    @Resource
    private CapitalPaymentAccountService cpas;

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/find/{id}")
    public AjaxResponse selectOne(@PathVariable("id") String id) {
        CapitalPayment payment=cps.queryById(id);
        List<CapitalPaymentBill> bills=cpbs.queryById(id);
        List<CapitalPaymentAccount> accounts=cpas.queryById(id);
        PaymentVo vo = new PaymentVo();
        payment.setFounder(sus.queryById(Integer.valueOf(payment.getFounder())).getUserName());
        if(payment.getApprover()!=null) {
            payment.setApprover(sus.queryById(Integer.valueOf(payment.getApprover())).getUserName());
        }
        payment.setDrawee(sus.queryById(Integer.valueOf(payment.getDrawee())).getUserName());
        for (int i=0;i<accounts.size();i++) {
            BaseCapitalAccountVo basevo = new BaseCapitalAccountVo();
            basevo.setCapitalId(accounts.get(i).getFundAccount());
            BaseCapitalAccountVo list = bcas.queryAllVo(basevo).get(0);
            BaseCapitalAccount account = bcas.queryById(accounts.get(i).getFundAccount());
            accounts.get(i).setFundAccount(account.getFundAccount());
            accounts.get(i).setSettlementType(list.getSettlementType());
            vo.setPayment(payment);
            vo.setBills(bills);
            vo.setAccounts(accounts);
        }
        return AjaxResponse.success(vo);
    }
    @PostMapping("/addpayment/{type}")
    public AjaxResponse addreceipt(@PathVariable("type") int type, @RequestBody String add) {
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("payment");
        CapitalPayment payment = JSON.parseObject(one, CapitalPayment.class);
        String two = jsonObject.getString("bill");
        List<CapitalPaymentBill> bills= JSONArray.parseArray(two, CapitalPaymentBill.class);
        String three = jsonObject.getString("account");
        List<CapitalPaymentAccount> accounts= JSONArray.parseArray(three, CapitalPaymentAccount.class);
        //绑定付款单
        for (int i=0;i<bills.size();i++){
            bills.get(i).setPaymentId(payment.getPaymentId());
        }
        for (int j=0;j<accounts.size();j++){
            accounts.get(j).setPaymentId(payment.getPaymentId());
        }
        payment.setFounder(String.valueOf(sus.queryUserIdByUserName(payment.getFounder())));
        payment.setApprovalState(type);
        payment.setFoundTime(new Date());
        payment.setUpdateTime(new Date());
        cps.insert(payment);
        cpbs.insertBatch(bills);
        cpas.insertBatch(accounts);
        return AjaxResponse.success(payment.getPaymentId());
    }
    @PostMapping("/conditionpage")
    public AjaxResponse conditionpage(@RequestBody String conditionpage) {
        JSONObject jsonObject = JSONObject.parseObject(conditionpage);
        String condition = jsonObject.getString("condition");//查询条件--实体类
        CapitalConditionPageVo vo=JSON.parseObject(condition, CapitalConditionPageVo.class);
        int currentPage = Integer.parseInt(jsonObject.getString("currentPage"));
        int pageSize = Integer.parseInt(jsonObject.getString("pageSize"));
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<CapitalPayment> list=cps.queryAll(vo);
        for(int i=0;i<list.size();i++){
            list.get(i).setFounder(sus.queryById(Integer.valueOf(list.get(i).getFounder())).getUserName());
            if(list.get(i).getApprover()!=null){
                list.get(i).setApprover(sus.queryById(Integer.valueOf(list.get(i).getApprover())).getUserName());
            }
            list.get(i).setDrawee(sus.queryById(Integer.valueOf(list.get(i).getDrawee())).getUserName());
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
    @GetMapping("/approval")
    public AjaxResponse approvalorder(String orderid,int type,String user,String approvalremarks){
        //判断订单付款金额是否能够通过审批
        if(type == 1){
            CapitalPayment payment=cps.queryById(orderid);
            List<CapitalPaymentBill> bills=cpbs.queryById(payment.getPaymentId());
            for (int i=0;i<bills.size();i++) {
                if (bills.get(i).getPurchaseType().equals("采购入库单")||bills.get(i).getPurchaseType().equals("采购退货单")) {
                    CapitalPayable ok=cpsok.queryById(bills.get(i).getPurchaseId());
                    if(ok.getCaseState()==1){
                        return AjaxResponse.success("订单："+ok.getDeliveryId()+"已结案");
                    }
                }else if (bills.get(i).getPurchaseType().equals("采购订单")){
                    PurchaseOrder ok=pos.queryById(bills.get(i).getPurchaseId());
                    if (ok.getOstate()+bills.get(i).getThisMoney()>ok.getOffersPrice()){
                        return AjaxResponse.success("订单："+ok.getId()+"预付款金额不足");
                    }
                }
            }
        }
        //修改付款单信息
        CapitalPayment payment=new CapitalPayment();
        payment.setPaymentId(orderid);
        payment.setApprovalState(type);
        payment.setApprover(String.valueOf(sus.queryUserIdByUserName(user)));
        payment.setApprovalRemarks(approvalremarks);
        payment.setLastApprovalTime(new Date());
        payment.setUpdateTime(new Date());
        cps.update(payment);
        if(type == 1){
            //订单通过修改单据已付款
            CapitalPayable payable=new CapitalPayable();
            List<CapitalPaymentBill> bills=cpbs.queryById(payment.getPaymentId());
            for (int i=0;i<bills.size();i++) {
                //修改单据付款金额
                PurchaseOrder order=new PurchaseOrder();
                if (bills.get(i).getPurchaseType().equals("采购入库单")||bills.get(i).getPurchaseType().equals("采购退货单")) {
                    //修改应付款信息
                    payable.setDeliveryId(bills.get(i).getPurchaseId());
                    payable.setLastCollectionTime(new Date());
                    payable.setPaymentRemark(approvalremarks);
                    payable.setPaid(bills.get(i).getThisMoney());
                    CapitalPayable tf=cpsok.receivedadd(payable);
                    if(tf.getUnpaid()==0){
                        tf.setCaseState(1);
                        cpsok.update(tf);
                    }
                }
                if (bills.get(i).getPurchaseType().equals("采购订单")) {
                    //修改订单已付款信息
                    order.setId(bills.get(i).getPurchaseId());
                    order.setUpdateDate(new Date());
                    order.setOstate(bills.get(i).getThisMoney());
                    pos.ostateadd(order);
                }
            }
            //订单通过减少账户资金
            BaseCapitalAccount baseaccount=new BaseCapitalAccount();
            List<CapitalPaymentAccount> accounts=cpas.queryById(payment.getPaymentId());
            for (int j=0;j<accounts.size();j++) {
                baseaccount.setFundAccount(accounts.get(j).getFundAccount());
                baseaccount.setCurrentAmount(accounts.get(j).getThisMoney());
                bcas.currentAmountreduce(baseaccount);
            }
        }
        return AjaxResponse.success(true);
    }
}
