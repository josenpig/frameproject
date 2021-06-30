package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.BaseProduct;
import com.xingji.frameproject.mybatis.entity.BaseUnit;
import com.xingji.frameproject.service.BaseProductService;
import com.xingji.frameproject.service.BaseUnitService;
import com.xingji.frameproject.vo.AjaxResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (BaseUnit)表控制层
 *
 * @author makejava
 * @since 2021-06-09 14:36:38
 */
@RestController
@RequestMapping("baseUnit")
public class BaseUnitController {
    /**
     * 服务对象
     */
    @Resource
    private BaseUnitService baseUnitService;
    @Resource
    private BaseProductService baseProductService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BaseUnit selectOne(Integer id) {
        return this.baseUnitService.queryById(id);
    }

    /**
     * 查询所有单位信息
     * @return 单位集合
     */
    @GetMapping("/findAllUnit")
    public AjaxResponse findAllUnit(Integer currentPage, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        BaseUnit baseUnit=new BaseUnit();
        List<BaseUnit> list=baseUnitService.queryAll(baseUnit);
        System.out.println(list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    };

    /**
     * 查询所有单位信息返回集合
     * @return 单位集合
     */
    @GetMapping("/findAllUnit/list")
    public AjaxResponse findAllUnitToList(){
        BaseUnit baseUnit=new BaseUnit();
        List<BaseUnit> list=baseUnitService.queryAll(baseUnit);
        return AjaxResponse.success(list);
    };

    /**
     * 删除单位
     * @param uid 单位编号
     * @return
     */
    @GetMapping("/delUnit")
    public AjaxResponse delUnit(String uid){
        Integer id=Integer.valueOf(uid);
        System.out.println("del:"+uid+","+id);
        BaseProduct baseProduct=new BaseProduct();
        baseProduct.setUnitId(id);
        List<BaseProduct> list=baseProductService.queryAll(baseProduct);
        Boolean recript=false;
        if(list.size()==0){
            recript=baseUnitService.deleteById(id);
        }
        return AjaxResponse.success(recript);
    };

    /**
     * 判断单位名称是否重复
     * @param UnitName
     * @return
     */
    @GetMapping("/judgeUnitName")
    public AjaxResponse judgeUnitName(String UnitName){
        System.out.println("UnitName:"+UnitName);
        BaseUnit baseUnit =new BaseUnit();
        baseUnit.setUnitName(UnitName);
        List<BaseUnit> list=baseUnitService.queryAll(baseUnit);
        Boolean result=false;
        if (list.size()==0){
            result=true;
        };
        return AjaxResponse.success(result);
    };

    /**
     * 新增单位
     * @param add
     * @return
     */
    @RequestMapping("/addUnit")
    public AjaxResponse addUnit(@RequestBody String add){
        System.out.println(add);
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("Unit");
        BaseUnit Unit = JSON.parseObject(one, BaseUnit.class);
        BaseUnit newc=baseUnitService.insert(Unit);
        return AjaxResponse.success(newc);
    };

    /**
     * 修改单位
     * @param add
     * @return
     */
    @RequestMapping("/updateUnit")
    public AjaxResponse updateUnit(@RequestBody String add){
        System.out.println(add);
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("Unit");
        BaseUnit Unit = JSON.parseObject(one, BaseUnit.class);
        BaseUnit newUnit= baseUnitService.update(Unit);
        return AjaxResponse.success(newUnit);
    };
}
