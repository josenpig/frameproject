package com.xingji.frameproject.controller;

import com.xingji.frameproject.entity.PurchaseReceipt;
import com.xingji.frameproject.service.PurchaseReceiptService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PurchaseReceipt)表控制层
 *
 * @author makejava
 * @since 2021-06-15 18:48:36
 */
@RestController
@RequestMapping("purchaseReceipt")
public class PurchaseReceiptController {
    /**
     * 服务对象
     */
    @Resource
    private PurchaseReceiptService purchaseReceiptService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PurchaseReceipt selectOne(String id) {
        return this.purchaseReceiptService.queryById(id);
    }

}
