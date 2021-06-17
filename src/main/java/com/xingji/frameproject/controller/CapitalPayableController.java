package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.*;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.BaseCapitalAccountVo;
import com.xingji.frameproject.vo.PurchaseCapitalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CapitalPayable selectOne(String id) {
        return this.cps.queryById(id);
    }
    /**
     * 本次销售订单收款
     * @return 数据
     */
    @GetMapping("/purchasethisReceipt")
    public AjaxResponse purchasethisReceipt(String purchaseId){
        PurchaseCapitalVo vo=pos.querythisReceipt(purchaseId);
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
