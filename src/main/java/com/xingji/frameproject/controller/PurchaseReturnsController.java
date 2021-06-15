package com.xingji.frameproject.controller;

import com.xingji.frameproject.entity.PurchaseReturns;
import com.xingji.frameproject.service.PurchaseReturnsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PurchaseReturns)表控制层
 *
 * @author makejava
 * @since 2021-06-15 18:49:02
 */
@RestController
@RequestMapping("purchaseReturns")
public class PurchaseReturnsController {
    /**
     * 服务对象
     */
    @Resource
    private PurchaseReturnsService purchaseReturnsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PurchaseReturns selectOne(String id) {
        return this.purchaseReturnsService.queryById(id);
    }

}
