package com.xingji.frameproject.controller;

import com.xingji.frameproject.mybatis.entity.PurchaseReturnsDetails;
import com.xingji.frameproject.service.PurchaseReturnsDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PurchaseReturnsDetails)表控制层
 *
 * @author makejava
 * @since 2021-06-15 18:49:12
 */
@RestController
@RequestMapping("purchaseReturnsDetails")
public class PurchaseReturnsDetailsController {
    /**
     * 服务对象
     */
    @Resource
    private PurchaseReturnsDetailsService purchaseReturnsDetailsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PurchaseReturnsDetails selectOne(Integer id) {
        return this.purchaseReturnsDetailsService.queryById(id);
    }

}
