package com.xingji.frameproject.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.BaseDepot;
import com.xingji.frameproject.service.BaseDepotService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (BaseDepot)表控制层
 *
 * @author makejava
 * @since 2021-05-28 19:30:48
 */
@RestController
@RequestMapping("baseDepot")
public class BaseDepotController {
    /**
     * 服务对象
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private BaseDepotService baseDepotService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BaseDepot selectOne(String id) {
        return this.baseDepotService.queryById(id);
    }

    /**
     * 查询所有仓库信息
     * @return 仓库集合
     */
    @GetMapping("/findAllDepot")
    public AjaxResponse findAllProduct(Integer currentPage, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<BaseDepot> baseDepotVoList=baseDepotService.findAllDepot();
        System.out.println(baseDepotVoList);
        map.put("total",page.getTotal());
        map.put("rows",baseDepotVoList);
        return AjaxResponse.success(map);
    };
}
