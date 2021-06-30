package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.BaseVendorProductService;
import com.xingji.frameproject.service.PurchaseOrderDetailsService;
import com.xingji.frameproject.service.PurchaseOrderService;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.BaseVendorProductVo;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (BaseVendorProduct)表控制层
 *
 * @author makejava
 * @since 2021-06-25 15:26:11
 */
@RestController
@RequestMapping("baseVendorProduct")
public class BaseVendorProductController {
    /**
     * 服务对象
     */
    @Resource
    private BaseVendorProductService baseVendorProductService;
    @Resource
    private PurchaseOrderDetailsService purchaseOrderDetailsService;//采购详情单

    /**
     * 通过主键查询单条数据
     *
     * @param
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BaseVendorProduct selectOne(String vendorId,String productId) {
        return this.baseVendorProductService.queryById(vendorId,productId);
    }

    /**
     * 根据供应商id查询供应商下的产品 返回list
     * @return 产品集合
     */
    @GetMapping("/findAllbaseVendorProduct")
    public AjaxResponse findAllVendorToList(Integer currentPage,Integer pageSize, String vid, String pid, String pname){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        System.out.println("vid"+vid);
        BaseVendorProductVo baseVendorProductVo=new BaseVendorProductVo();
        baseVendorProductVo.setVendorId(vid);
        baseVendorProductVo.setProductId(pid);
        baseVendorProductVo.setProductName(pname);
        List<BaseVendorProductVo> list=baseVendorProductService.queryAllBaseVendorProductVo(baseVendorProductVo);
        System.out.println(list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    };

    /**
     * 根据供应商id查询供应商下的产品 返回list
     * @return 产品集合
     */
    @GetMapping("/findAllbaseVendorProduct/list")
    public AjaxResponse findAllVendorToList(String vid,String pid,String pname){
        System.out.println("vid"+vid);
        BaseVendorProductVo baseVendorProductVo=new BaseVendorProductVo();
        baseVendorProductVo.setVendorId(vid);
        baseVendorProductVo.setProductId(pid);
        baseVendorProductVo.setProductName(pname);
        List<BaseVendorProductVo> list=baseVendorProductService.queryAllBaseVendorProductVo(baseVendorProductVo);
        System.out.println(list);
        return AjaxResponse.success(list);
    };

    /**
     * 新增供应商下产品
     * @param add
     * @return
     */
    @RequestMapping("/addBaseVendorProduct")
    public AjaxResponse addBaseVendorProduct(@RequestBody String add){
        System.out.println(add);
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("BaseVendorProduct");
        BaseVendorProduct baseVendorProduct = JSON.parseObject(one, BaseVendorProduct.class);
        BaseVendorProduct newc=baseVendorProductService.insert(baseVendorProduct);
        return AjaxResponse.success(newc);
    };

    /**
     * 修改产品
     * @param add
     * @return
     */
    @RequestMapping("/updateVendorProduct")
    public AjaxResponse updateVendorProduct(@RequestBody String add){
        System.out.println(add);
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("ProductVendor");
        BaseVendorProduct baseVendorProduct = JSON.parseObject(one, BaseVendorProduct.class);

        List<PurchaseOrderDetails> list=purchaseOrderDetailsService.findPODofVidAndPid(baseVendorProduct);
        System.out.println("list:"+list);
        String update=null;
        if (list.size()==0){
            BaseVendorProduct baseVendorProduct1=baseVendorProductService.update(baseVendorProduct);
            update=baseVendorProduct1.toString();
        }
        return AjaxResponse.success(update);
    };

    /**
     * 删除单位
     * @return
     */
    @GetMapping("/delVendorProduct")
    public AjaxResponse delVendorProduct(String vid,String pid){
        System.out.println("vid:"+vid+", pid:"+pid);
        BaseVendorProduct baseVendorProduct=new BaseVendorProduct();
        baseVendorProduct.setVendorId(vid);
        baseVendorProduct.setProductId(pid);

        List<PurchaseOrderDetails> list=purchaseOrderDetailsService.findPODofVidAndPid(baseVendorProduct);
        System.out.println("list:"+list);
        Boolean b=false;
        if(list.size()==0){
            b=baseVendorProductService.deleteById(baseVendorProduct);
            System.out.println("del:"+b);
        }
        return AjaxResponse.success(b);
    };
}
