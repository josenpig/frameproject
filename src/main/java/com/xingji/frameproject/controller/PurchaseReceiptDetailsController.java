package com.xingji.frameproject.controller;

import com.xingji.frameproject.entity.PurchaseReceiptDetails;
import com.xingji.frameproject.service.PurchaseReceiptDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PurchaseReceiptDetails)表控制层
 *
 * @author makejava
 * @since 2021-06-15 18:48:49
 */
@RestController
@RequestMapping("purchaseReceiptDetails")
public class PurchaseReceiptDetailsController {
    /**
     * 服务对象
     */
    @Resource
    private PurchaseReceiptDetailsService purchaseReceiptDetailsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PurchaseReceiptDetails selectOne(Integer id) {
        return this.purchaseReceiptDetailsService.queryById(id);
    }

}
