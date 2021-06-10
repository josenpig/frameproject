package com.xingji.frameproject.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.BaseSettlementType;
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

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BaseSettlementType selectOne(Integer id) {
        return this.baseSettlementTypeService.queryById(id);
    }

    /**
     * 查询所有结算类型信息
     * @return 结算类型集合
     */
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
     * 查询所有结算类型信息
     * @return 结算类型集合
     */
    @GetMapping("/findAllSettlementType/list")
    public AjaxResponse findAllProductToList(){
        BaseSettlementType baseSettlementType=new BaseSettlementType();
        List<BaseSettlementType> list=baseSettlementTypeService.queryAll(baseSettlementType);
        return AjaxResponse.success(list);
    };
}
