package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xingji.frameproject.annotation.Log;
import com.xingji.frameproject.mybatis.entity.BaseProduct;
import com.xingji.frameproject.mybatis.entity.BaseProductType;
import com.xingji.frameproject.service.BaseProductService;
import com.xingji.frameproject.service.BaseProductTypeService;
import com.xingji.frameproject.vo.AjaxResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * (BaseProductType)表控制层
 *
 * @author makejava
 * @since 2021-06-15 10:00:17
 */
@RestController
@RequestMapping("baseProductType")
public class BaseProductTypeController {
    /**
     * 服务对象
     */
    @Resource
    private BaseProductTypeService baseProductTypeService;
    @Resource
    private BaseProductService baseProductService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @Log("查询单个产品分类")
    public BaseProductType selectOne(Integer id) {
        return this.baseProductTypeService.queryById(id);
    }

    /**
     * 查询所有产品分类信息
     * @return 产品集合
     */
    @Log("查询所有产品分类信息")
    @GetMapping("/findProType")
    public AjaxResponse findAllProduct(){
        BaseProductType baseProductType=new BaseProductType();
        List<BaseProductType> usermenu = baseProductTypeService.queryAll(baseProductType);
        //获取父菜单
        List<BaseProductType> treemenu = usermenu.stream().filter(m -> m.getProductTypeParentId() == 0).map(
                (m) -> {
                    m.setChildren(getChildrens(m, usermenu));
                    return m;
                }
        ).collect(Collectors.toList());
        return AjaxResponse.success(treemenu);
    };

    /**
     * 查询所有产品分类信息
     * @return 产品集合
     */
    @Log("查询所有产品分类信息")
    @GetMapping("/findProType/list")
    public AjaxResponse findAllProductToList(){
        BaseProductType baseProductType=new BaseProductType();
        List<BaseProductType> list = baseProductTypeService.queryAll(baseProductType);
        return AjaxResponse.success(list);
    };

    /**
     * 递归查询产品分类
     * @param root 根菜单
     * @param all  所有菜单
     * @return 菜单信息
     */
    @Log("递归查询产品分类")
    private List<BaseProductType> getChildrens(BaseProductType root, List<BaseProductType> all) {
        List<BaseProductType> children = all.stream().filter(m -> {
            return Objects.equals(m.getProductTypeParentId(), root.getId());
        }).map(
                (m) -> {
                    m.setChildren(getChildrens(m, all));
                    return m;
                }
        ).collect(Collectors.toList());
        return children;
    }

    /**
     * 判断产品分类名称是否重复
     * @param ProductTypeName
     * @return
     */
    @Log("判断产品分类名称是否重复")
    @GetMapping("/judgeProductTypeName")
    public AjaxResponse judgeProductTypeName(String ProductTypeName){
        System.out.println("ProductTypeName:"+ProductTypeName);
        BaseProductType baseProductType =new BaseProductType();
        baseProductType.setLabel(ProductTypeName);
        List<BaseProductType> list=baseProductTypeService.queryAll(baseProductType);
        Boolean result=false;
        if (list.size()==0){
            result=true;
        };
        return AjaxResponse.success(result);
    };
    
    /**
     * 新增产品分类
     * @param add
     * @return
     */
    @Log("新增产品分类")
    @RequestMapping("/addProductType")
    public AjaxResponse addProductType(@RequestBody String add){
        System.out.println(add);
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("ProductType");
        BaseProductType ProductType = JSON.parseObject(one, BaseProductType.class);
        BaseProductType newc=baseProductTypeService.insert(ProductType);
        return AjaxResponse.success(newc);
    };

    /**
     * 修改产品分类
     * @param add
     * @return
     */
    @Log("修改产品分类")
    @RequestMapping("/updateProductType")
    public AjaxResponse updateProductType(@RequestBody String add){
        System.out.println(add);
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("ProductType");
        BaseProductType ProductType = JSON.parseObject(one, BaseProductType.class);
        BaseProductType newProductType= baseProductTypeService.update(ProductType);
        return AjaxResponse.success(newProductType);
    };
    
    /**
     * 删除产品分类--
     * @param id 产品编号
     * @return
     */
    @Log("删除产品分类")
    @GetMapping("/delProductType")
    public AjaxResponse delProductType(Integer id){
        System.out.println("del:"+id);
        BaseProduct baseProduct=new BaseProduct();
        baseProduct.setProductTypeId(id);
        List<BaseProduct> list=baseProductService.queryAll(baseProduct);
        Boolean del=false;
        if(list.size()==0){
            del=baseProductTypeService.deleteById(id);
        }
        System.out.println("删除是否成功："+del);
        return AjaxResponse.success(del);
    };
}
