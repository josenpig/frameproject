package com.xingji.frameproject.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.BaseProduct;
import com.xingji.frameproject.service.BaseDepotService;
import com.xingji.frameproject.service.BaseOpeningService;
import com.xingji.frameproject.service.BaseProductService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.BaseProductVo;
import com.xingji.frameproject.vo.PurchaseProductVo;
import com.xingji.frameproject.vo.SaleProductVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (BaseProduct)表控制层
 *
 * @author makejava
 * @since 2021-05-26 14:51:36
 */
@RestController
@RequestMapping("baseProduct")
public class BaseProductController {
    /**
     * 服务对象
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private BaseProductService baseProductService;
    @Resource
    private BaseOpeningService baseOpeningService;
    @Resource
    private BaseDepotService baseDepotService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BaseProduct selectOne(String id) {
        return this.baseProductService.queryById(id);
    }

    /**
     * 查询所有销售产品
     * @return 产品集合
     */
    @GetMapping("/allsaleproduct")
    public AjaxResponse findAllsaleproduct(Integer currentPage, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<SaleProductVo> SaleProductVo=baseProductService.allsaleproduct();
        for(SaleProductVo product:SaleProductVo){
            product.setBaseOpenings(baseOpeningService.finddepot(product.getProductId()));
        }
        map.put("total",page.getTotal());
        map.put("rows",SaleProductVo);
        return AjaxResponse.success(map);
    };
    /**
     * 查询所有采购的产品
     * @return 产品集合
     */
    @GetMapping("/allpurchaseproduct")
    public AjaxResponse findAllPurchaseProduct(Integer currentPage, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<PurchaseProductVo> purchaseProductVos=baseProductService.allPurchaseProduct();
        for(PurchaseProductVo product:purchaseProductVos){
            product.setBaseDepots(baseDepotService.findAll());
            product.getBaseDepots();
        }
        map.put("total",page.getTotal());
        map.put("rows",purchaseProductVos);
        return AjaxResponse.success(map);
    };
    /**
     * 查询所有类别的产品
     * @return 产品集合
     */
    @GetMapping("/findAllProduct")
    public AjaxResponse findAllProduct(Integer currentPage, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        BaseProductVo baseProductVo=new BaseProductVo();
        List<BaseProductVo> productShowList=baseProductService.findAllProduct(baseProductVo);
        System.out.println(productShowList);
        map.put("total",page.getTotal());
        map.put("rows",productShowList);
        return AjaxResponse.success(map);
    };

    /**
     * 根据产品id或产品名称查询的产品
     * @return 产品集合
     */
    @GetMapping("/findAllProduct/ByIdOrName")
    public AjaxResponse findAllProductByIdOrName(@Param("currentPage")Integer currentPage, @Param("pageSize") Integer pageSize, @Param("select") String select, @Param("SearchContent") String SearchContent){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        BaseProductVo baseProductVo = new BaseProductVo();
        System.out.println(select+",,,"+SearchContent);
        if (select.equals("产品名称")){
            baseProductVo.setProductName(SearchContent);
        };
        if (select.equals("产品编号")){
            baseProductVo.setProductId(SearchContent);
        };
        List<BaseProductVo> productShowList=baseProductService.findAllProduct(baseProductVo);
        System.out.println(productShowList);
        map.put("total",page.getTotal());
        map.put("rows",productShowList);
        return AjaxResponse.success(map);
    };

    /**
     * 删除产品
     * @param id 产品编号
     * @return
     */
    @GetMapping("/delProduct")
    public AjaxResponse delProduct(String id){
        System.out.println("del:"+id);
        String recript=baseProductService.deleteById(id);
        return AjaxResponse.success(recript);
    };

    /**
     * 批量删除产品
     * @param ids 产品编号集合
     * @return
     */
    @DeleteMapping("/delProduct/batch")
    public AjaxResponse bacthDelProduct(@RequestBody List<String> ids){
        System.out.println("delList："+ids);
        List<String> retList= new ArrayList<String>();
        for(int i=0;i < ids.size();i++){
            String recript=baseProductService.deleteById(ids.get(i));
            retList.add(recript);
        }
        return AjaxResponse.success(retList);
    };
}
