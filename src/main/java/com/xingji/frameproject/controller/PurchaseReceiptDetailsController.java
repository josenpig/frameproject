package com.xingji.frameproject.controller;

import com.xingji.frameproject.annotation.Log;
import com.xingji.frameproject.mybatis.entity.PurchaseReceiptDetails;
import com.xingji.frameproject.service.PurchaseReceiptDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


import java.util.List;

/**
 * (PurchaseReceiptDetails)表控制层
 *
 * @author makejava
 * @since 2021-06-16 23:42:54
 */
@RestController
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
    @Log("查询单条采购入库单详情")
    @GetMapping("/purchaseReceiptDetails/one")
    public PurchaseReceiptDetails selectOne(Integer id) {
        return this.purchaseReceiptDetailsService.queryById(id);
    }


    /**
     * 批量新增数据
     *
     * @param PurchaseReceiptDetailsList 实例对象列表
     * @return 影响行数
     */
    @Log("批量新增采购入库单详情")
    @PostMapping("/purchaseReceiptDetails/batch")
    public boolean insertBatch(@RequestBody List<PurchaseReceiptDetails> PurchaseReceiptDetailsList) {
        return this.purchaseReceiptDetailsService.insertBatch(PurchaseReceiptDetailsList);
    }

    /**
     * 修改数据
     *
     * @param purchaseReceiptDetails 实例对象
     * @return 实例对象
     */
    @Log("修改采购入库单详情")
    @PutMapping("/purchaseReceiptDetails")
    public PurchaseReceiptDetails update(@RequestBody PurchaseReceiptDetails purchaseReceiptDetails) {
        return this.purchaseReceiptDetailsService.update(purchaseReceiptDetails);
    }


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Log("删除采购入库单详情")
    @DeleteMapping("/purchaseReceiptDetails")
    public boolean deleteById(Integer id) {
        return this.purchaseReceiptDetailsService.deleteById(id);
    }

}
