package com.xingji.frameproject.controller;

import com.github.pagehelper.PageInfo;
import com.xingji.frameproject.annotation.Log;
import com.xingji.frameproject.mybatis.entity.PurchaseOrderDetails;
import com.xingji.frameproject.service.PurchaseOrderDetailsService;
import com.xingji.frameproject.vo.form.PurchaseOrderDetailsQueryForm;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PurchaseOrderDetails)表控制层
 *
 * @author makejava
 * @since 2021-06-02 09:52:32
 */
@RestController
public class PurchaseOrderDetailsController {
    /**
     * 服务对象
     */
    @Resource
    private PurchaseOrderDetailsService purchaseOrderDetailsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Log("查询单条采购详情订单")
    @GetMapping("/purchaseOrderDetails/one")
    public PurchaseOrderDetails selectOne(Integer id) {
        return this.purchaseOrderDetailsService.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @param purchaseOrderDetailsQueryForm 实例对象
     * @return 实例对象
     */
    @Log("查询单条采购详情订单")
    @GetMapping("/purchaseOrderDetails")
    public PageInfo<PurchaseOrderDetails> queryAll(PurchaseOrderDetailsQueryForm purchaseOrderDetailsQueryForm) {
        return this.purchaseOrderDetailsService.queryAll(purchaseOrderDetailsQueryForm);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param purchaseOrderDetailsQueryForm
     * @return 对象列表
     */
    @Log("根据查询条件查询采购详情订单")
    @GetMapping("/purchaseOrderDetails/search")
    public PageInfo<PurchaseOrderDetails> queryBySearch(PurchaseOrderDetailsQueryForm purchaseOrderDetailsQueryForm) {
        return this.purchaseOrderDetailsService.queryBySearch(purchaseOrderDetailsQueryForm);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param purchaseOrderDetailsQueryForm
     * @return 对象列表
     */
    @Log("根据查询条件筛选采购详情订单")
    @GetMapping("/purchaseOrderDetails/screen")
    public PageInfo<PurchaseOrderDetails> queryByScreen(PurchaseOrderDetailsQueryForm purchaseOrderDetailsQueryForm) {
        return this.purchaseOrderDetailsService.queryByScreen(purchaseOrderDetailsQueryForm);
    }

    /**
     * 新增数据
     *
     * @param purchaseOrderDetails 实例对象
     * @return 实例对象
     */
    @Log("新增采购详情订单")
    @PostMapping("/purchaseOrderDetails")
    public PurchaseOrderDetails insert(@RequestBody PurchaseOrderDetails purchaseOrderDetails) {
        return this.purchaseOrderDetailsService.insert(purchaseOrderDetails);
    }

    /**
     * 批量新增数据
     *
     * @param PurchaseOrderDetailsList 实例对象列表
     * @return 影响行数
     */
    @Log("批量新增采购详情订单")
    @PostMapping("/purchaseOrderDetails/batch")
    public int insertBatch(@RequestBody List<PurchaseOrderDetails> PurchaseOrderDetailsList) {
        return this.purchaseOrderDetailsService.insertBatch(PurchaseOrderDetailsList);
    }

    /**
     * 修改数据
     *
     * @param purchaseOrderDetails 实例对象
     * @return 实例对象
     */
    @Log("修改采购详情订单")
    @PutMapping("/purchaseOrderDetails")
    public boolean update(@RequestBody PurchaseOrderDetails purchaseOrderDetails) {
        return this.purchaseOrderDetailsService.update(purchaseOrderDetails);
    }



    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Log("通过主键删除采购详情订单")
    @DeleteMapping("/purchaseOrderDetails")
    public boolean deleteById(Integer id) {
        return this.purchaseOrderDetailsService.deleteById(id);
    }


}