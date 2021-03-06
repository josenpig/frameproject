package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.BaseCapitalAccountService;
import com.xingji.frameproject.service.CapitalReceivableService;
import com.xingji.frameproject.service.SaleDeliveryService;
import com.xingji.frameproject.service.SaleOrderService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.BaseCapitalAccountVo;
import com.xingji.frameproject.vo.SaleReceiptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (CapitalReceivable)表控制层
 *
 * @author makejava
 * @since 2021-06-01 11:45:41
 */
@RestController
@RequestMapping("/capitalReceivable")
public class CapitalReceivableController {
    /**
     * 服务对象
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private CapitalReceivableService crs;
    @Resource
    private SaleOrderService sos;
    @Resource
    private SaleDeliveryService sds;
    @Resource
    private BaseCapitalAccountService bcas;

    /**
     * 资金应收分页条件查询
     * @param conditionpage 条件查询信息
     * @return map数据
     */
    @PostMapping("/conditionpage")
    public AjaxResponse conditionpage(@RequestBody String conditionpage) {
        JSONObject jsonObject = JSONObject.parseObject(conditionpage);
        String condition = jsonObject.getString("condition");//查询条件
        int currentPage = Integer.parseInt(jsonObject.getString("currentPage"));
        int pageSize = Integer.parseInt(jsonObject.getString("pageSize"));
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<CapitalReceivable> list=crs.queryAllByPage();
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    /**
     * 销售订单收款分页条件查询
     * @param conditionpage 条件查询信息
     * @return map数据
     */
    @PostMapping("/findsalepage")
    public AjaxResponse findsalepage(@RequestBody String conditionpage){
        JSONObject jsonObject = JSONObject.parseObject(conditionpage);
        String condition = jsonObject.getString("condition");//查询条件--实体类
        SaleReceiptVo vo=JSON.parseObject(condition, SaleReceiptVo.class);
        int currentPage = Integer.parseInt(jsonObject.getString("currentPage"));
        int pageSize = Integer.parseInt(jsonObject.getString("pageSize"));
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<SaleReceiptVo> list=sos.queryReceipt(vo);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    /**
     * 销售出库单分页条件查询
     * @param conditionpage 条件查询信息
     * @return map数据
     */
    @PostMapping("/finddeliverypage")
    public AjaxResponse finddeliverypage(@RequestBody String conditionpage){
        JSONObject jsonObject = JSONObject.parseObject(conditionpage);
        String condition = jsonObject.getString("condition");//查询条件--实体类
        SaleReceiptVo vo=JSON.parseObject(condition, SaleReceiptVo.class);
        int currentPage = Integer.parseInt(jsonObject.getString("currentPage"));
        int pageSize = Integer.parseInt(jsonObject.getString("pageSize"));
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<SaleReceiptVo> list=crs.queryReceipt(vo);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    /**
     * 本次销售订单收款
     * @return 数据
     */
    @GetMapping("/salethisReceipt")
    public AjaxResponse salethisReceipt(String saleId){
        SaleReceiptVo vo=sos.querythisReceipt(saleId);
        return AjaxResponse.success(vo);
    }
    /**
     * 本次销售出库单收款
     * @return 数据
     */
    @GetMapping("/deliverythisReceipt")
    public AjaxResponse deliverythisReceipt(String saleId){
        SaleReceiptVo vo=crs.querythisReceipt(saleId);
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
