package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.PurchaseReceipt;
import com.xingji.frameproject.mybatis.entity.PurchaseReturns;
import com.xingji.frameproject.vo.form.PurchaseReceiptQueryForm;

import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * (PurchaseReceipt)表服务接口
 *
 * @author makejava
 * @since 2021-06-16 10:00:49
 */
public interface PurchaseReceiptService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseReceipt queryById(String id);

    /**
     * 查询所有数据
     *
     * @param purchaseReceiptQueryForm 实例对象
     * @return 实例对象
     */
    PageInfo<PurchaseReceipt> queryAll(PurchaseReceiptQueryForm purchaseReceiptQueryForm);

    /**
     * 根据查询条件搜索数据
     *
     * @param purchaseReceiptQueryForm
     * @return 对象列表
     */
    PageInfo<PurchaseReceipt> queryBySearch(PurchaseReceiptQueryForm purchaseReceiptQueryForm);

    /**
     * 根据查询条件筛选数据
     *
     * @param purchaseReceiptQueryForm
     * @return 对象列表
     */
    PageInfo<PurchaseReceipt> queryByScreen(PurchaseReceiptQueryForm purchaseReceiptQueryForm);

    /**
     * 新增数据
     *
     * @param purchaseReceipt 实例对象
     * @return 实例对象
     */
    PurchaseReceipt insert(PurchaseReceipt purchaseReceipt);

    /**
     * 批量新增数据
     *
     * @param PurchaseReceiptList 实例对象列表
     * @return 影响行数
     */
    boolean insertBatch(List<PurchaseReceipt> PurchaseReceiptList);

    /**
     * 修改数据
     *
     * @param purchaseReceipt 实例对象
     * @return 实例对象
     */
    PurchaseReceipt update(PurchaseReceipt purchaseReceipt);


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);


    /**
     * 查询所有的可可以采购退货的订单
     * @return
     */
    List<PurchaseReceipt> queryAllByVettingState();
}
