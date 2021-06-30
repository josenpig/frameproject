package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.annotation.Log;
import com.xingji.frameproject.mybatis.entity.BaseSettlementType;
import com.xingji.frameproject.mybatis.entity.BaseSettlementType;
import com.xingji.frameproject.service.BaseCapitalAccountService;
import com.xingji.frameproject.service.BaseSettlementTypeService;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.BaseCapitalAccountVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (BaseSettlementType)表控制层
 *
 * @author makejava
 * @since 2021-06-10 16:22:52
 */
@RestController
@RequestMapping("baseSettlementType")
public class BaseSettlementTypeController {
    /**
     * 服务对象
     */
    @Resource
    private BaseSettlementTypeService baseSettlementTypeService;
    @Resource
    private BaseCapitalAccountService baseCapitalAccountService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Log("查询单条结算类型")
    @GetMapping("selectOne")
    public BaseSettlementType selectOne(Integer id) {
        return this.baseSettlementTypeService.queryById(id);
    }

    /**
     * 查询所有结算类型信息
     * @return 结算类型集合
     */
    @Log("查询所有结算类型信息")
    @GetMapping("/findAllSettlementType")
    public AjaxResponse findAllProduct(Integer currentPage, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        BaseSettlementType baseSettlementType=new BaseSettlementType();
        List<BaseSettlementType> list=baseSettlementTypeService.queryAll(baseSettlementType);
        System.out.println(list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    };

    /**
     * 查询所有结算类型信息 集合
     * @return 结算类型集合
     */
    @Log("结算类型集合")
    @GetMapping("/findAllSettlementType/list")
    public AjaxResponse findAllProductToList(){
        BaseSettlementType baseSettlementType=new BaseSettlementType();
        List<BaseSettlementType> list=baseSettlementTypeService.queryAll(baseSettlementType);
        return AjaxResponse.success(list);
    };

    /**
     * 删除单位
     * @param uid 单位编号
     * @return
     */
    @Log("删除单位")
    @GetMapping("/delSettlementType")
    public AjaxResponse delSettlementType(String uid){
        Integer id=Integer.valueOf(uid);
        System.out.println("del:"+uid+","+id);
        BaseCapitalAccountVo baseCapitalAccountVo=new BaseCapitalAccountVo();
        baseCapitalAccountVo.setSettlementTypeId(id);
        List<BaseCapitalAccountVo> list=baseCapitalAccountService.queryAllVo(baseCapitalAccountVo);
        Boolean recript=false;
        if(list.size()==0){
            recript=baseSettlementTypeService.deleteById(id);
        }
        return AjaxResponse.success(recript);
    };

    /**
     * 判断单位名称是否重复
     * @param settlementType
     * @return
     */
    @Log("判断单位名称是否重复")
    @GetMapping("/judgeSettlementType")
    public AjaxResponse judgeSettlementTypeName(String settlementType){
        System.out.println("SettlementTypeName:"+settlementType);
        BaseSettlementType baseSettlementType =new BaseSettlementType();
        baseSettlementType.setSettlementType(settlementType);
        List<BaseSettlementType> list=baseSettlementTypeService.queryAll(baseSettlementType);
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
    @Log("新增单位")
    @RequestMapping("/addSettlementType")
    public AjaxResponse addSettlementType(@RequestBody String add){
        System.out.println("add"+add);
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("settlementType");
        BaseSettlementType SettlementType = JSON.parseObject(one, BaseSettlementType.class);
        System.out.println("SettlementType:"+SettlementType);
        BaseSettlementType newc=baseSettlementTypeService.insert(SettlementType);
        return AjaxResponse.success(newc);
    };

    /**
     * 修改单位
     * @param add
     * @return
     */
    @Log("修改单位")
    @RequestMapping("/updateSettlementType")
    public AjaxResponse updateSettlementType(@RequestBody String add){
        System.out.println(add);
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("settlementType");
        BaseSettlementType SettlementType = JSON.parseObject(one, BaseSettlementType.class);
        BaseSettlementType newSettlementType= baseSettlementTypeService.update(SettlementType);
        return AjaxResponse.success(newSettlementType);
    };
}
