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
import com.xingji.frameproject.vo.BaseCapitalAccountVo;
import com.xingji.frameproject.vo.CapitalConditionPageVo;
import com.xingji.frameproject.vo.PurchaseCapitalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (CapitalPayable)表控制层
 *
 * @author makejava
 * @since 2021-06-15 17:16:35
 */
@RestController
@RequestMapping("capitalPayable")
public class CapitalPayableController {
    /**
     * 服务对象
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private SysUserService sus;
    @Resource
    private CapitalPayableService cps;
    @Resource
    private PurchaseOrderService pos;
    @Resource
    private PurchaseReceiptService prs;
    @Resource
    private BaseCapitalAccountService bcas;
    @Resource
    private CapitalPaymentService cpsok;
    @Resource
    private CapitalPaymentBillService cpbs;
    @Resource
    private CapitalPaymentAccountService cpas;

    /**
     * 资金应付分页条件查询
     * @param conditionpage 条件查询信息
     * @return map数据
     */
    @PostMapping("/conditionpage")
    public AjaxResponse conditionpage(@RequestBody String conditionpage) {
        JSONObject jsonObject = JSONObject.parseObject(conditionpage);
        String condition = jsonObject.getString("condition");//查询条件
        CapitalConditionPageVo vo=JSON.parseObject(condition,CapitalConditionPageVo.class);
        int currentPage = Integer.parseInt(jsonObject.getString("currentPage"));
        int pageSize = Integer.parseInt(jsonObject.getString("pageSize"));
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<CapitalPayable> list=cps.queryAllByPage(vo);
        System.out.println(vo.toString());
        for(int i=0;i<list.size();i++){
            list.get(i).setFounder(sus.queryById(Integer.valueOf(list.get(i).getFounder())).getUserName());
            list.get(i).setBuyer(sus.queryById(Integer.valueOf(list.get(i).getBuyer())).getUserName());
        }
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    /**
     * 本次采购订单付款--预付
     * @return 数据
     */
    @GetMapping("/purchasethisPayment")
    public AjaxResponse purchasethisReceipt(String purchaseId){
        PurchaseCapitalVo vo=pos.querythisPayment(purchaseId);
        return AjaxResponse.success(vo);
    }
    /**
     * 本次采购入库单付款--应付
     * @return 数据
     */
    @GetMapping("/receiptthisPayment")
    public AjaxResponse deliverythisReceipt(String purchaseId){
        PurchaseCapitalVo vo=cps.querythisPayment(purchaseId);
        return AjaxResponse.success(vo);
    }
    /**
     * 查询资金账户
     * @return 数据
     */
    @GetMapping("/findaccount")
    public AjaxResponse findaccount(){
        BaseCapitalAccountVo baseCapitalAccountVo=new BaseCapitalAccountVo();
        List<BaseCapitalAccountVo> list=bcas.queryAllVo(baseCapitalAccountVo);
        return AjaxResponse.success(list);
    }
}
