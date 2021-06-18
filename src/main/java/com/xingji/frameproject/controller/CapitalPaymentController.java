package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.*;
import com.xingji.frameproject.vo.AjaxResponse;
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
    private BaseCapitalAccountService bcas;
    @Resource
    private CapitalPaymentService cps;
    @Resource
    private CapitalPaymentBillService cpbs;
    @Resource
    private CapitalPaymentAccountService cpas;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public CapitalPayment selectOne(String id) {
        return this.cps.queryById(id);
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
            if (bills.get(i).getPurchaseType().equals("采购订单")){
                PurchaseOrder order=new PurchaseOrder();
                order.setId(bills.get(i).getPurchaseId());
                order.setPaymentOrder(payment.getPaymentId());
                pos.update(order);
            }
            if (bills.get(i).getPurchaseType().equals("采购出库单")||bills.get(i).getPurchaseType().equals("采购退货单")){
                PurchaseReceipt receipt=new PurchaseReceipt();
                receipt.setId(bills.get(i).getPurchaseId());
                receipt.setPaymentOrder(receipt.getPaymentOrder());
                prs.update(receipt);
            }
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
        CapitalPayment capitalPayment=JSON.parseObject(condition, CapitalPayment.class);
        int currentPage = Integer.parseInt(jsonObject.getString("currentPage"));
        int pageSize = Integer.parseInt(jsonObject.getString("pageSize"));
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<CapitalPayment> list=cps.queryAll(capitalPayment);
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
}
