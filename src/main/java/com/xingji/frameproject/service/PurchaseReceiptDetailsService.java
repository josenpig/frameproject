package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.PurchaseReceiptDetails;
import com.xingji.frameproject.mybatis.entity.SaleDeliveryDetails;
import com.xingji.frameproject.vo.form.PurchaseReceiptDetailsQueryForm;

import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * (PurchaseReceiptDetails)表服务接口
 *
 * @author makejava
 * @since 2021-06-16 23:42:52
 */
public interface PurchaseReceiptDetailsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseReceiptDetails queryById(Integer id);

    /**
     * 查询所有数据
     *
     * @param purchaseReceiptDetailsQueryForm 实例对象
     * @return 实例对象
     */
    PageInfo<PurchaseReceiptDetails> queryAll(PurchaseReceiptDetailsQueryForm purchaseReceiptDetailsQueryForm);

    /**
     * 根据查询条件搜索数据
     *
     * @param purchaseReceiptDetailsQueryForm
     * @return 对象列表
     */
    PageInfo<PurchaseReceiptDetails> queryBySearch(PurchaseReceiptDetailsQueryForm purchaseReceiptDetailsQueryForm);

    /**
     * 根据查询条件筛选数据
     *
     * @param purchaseReceiptDetailsQueryForm
     * @return 对象列表
     */
    PageInfo<PurchaseReceiptDetails> queryByScreen(PurchaseReceiptDetailsQueryForm purchaseReceiptDetailsQueryForm);

    /**
     * 新增数据
     *
     * @param purchaseReceiptDetails 实例对象
     * @return 实例对象
     */
    PurchaseReceiptDetails insert(PurchaseReceiptDetails purchaseReceiptDetails);

    /**
     * 批量新增数据
     *
     * @param PurchaseReceiptDetailsList 实例对象列表
     * @return 影响行数
     */
    boolean insertBatch(List<PurchaseReceiptDetails> PurchaseReceiptDetailsList);

    /**
     * 修改数据
     *
     * @param purchaseReceiptDetails 实例对象
     * @return 实例对象
     */
    PurchaseReceiptDetails update(PurchaseReceiptDetails purchaseReceiptDetails);

    /**
     * 批量修改数据
     *
     * @param purchaseReceiptDetailsList 实例对象列表
     * @return 影响行数
     */
    boolean updateBatch(List<PurchaseReceiptDetails> purchaseReceiptDetailsList);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    boolean deleteBatch(List<Integer> ids);

    /**
     * 根据采购入库单查询采购入库单商品详情
     * @param id
     * @return
     */
    List<PurchaseReceiptDetails> queryAllByOrderId(String id);
}
