package com.xingji.frameproject.controller;

import com.xingji.frameproject.mybatis.entity.CapitalPayable;
import com.xingji.frameproject.service.CapitalPayableService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    @Resource
    private CapitalPayableService capitalPayableService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CapitalPayable selectOne(String id) {
        return this.capitalPayableService.queryById(id);
    }

}
