package com.xingji.frameproject.controller;

import com.xingji.frameproject.mybatis.entity.PurchaseReceiptDetails;
import com.xingji.frameproject.vo.form.PurchaseReceiptDetailsQueryForm;
import com.xingji.frameproject.service.PurchaseReceiptDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;

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
    @PutMapping("/purchaseReceiptDetails")
    public PurchaseReceiptDetails update(@RequestBody PurchaseReceiptDetails purchaseReceiptDetails) {
        return this.purchaseReceiptDetailsService.update(purchaseReceiptDetails);
    }

    /**
     * 批量修改数据
     *
     * @param purchaseReceiptDetailsList 实例对象列表
     * @return 影响行数
     */
    @PutMapping("/purchaseReceiptDetails/batch")
    public boolean updateBatch(@RequestBody List<PurchaseReceiptDetails> purchaseReceiptDetailsList) {
        return this.purchaseReceiptDetailsService.updateBatch(purchaseReceiptDetailsList);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/purchaseReceiptDetails")
    public boolean deleteById(Integer id) {
        return this.purchaseReceiptDetailsService.deleteById(id);
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    @DeleteMapping("/purchaseReceiptDetails/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return this.purchaseReceiptDetailsService.deleteBatch(ids);
    }
}
