package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.PurchaseOrderDetails;
import com.xingji.frameproject.mybatis.entity.PurchaseReceiptDetails;
import com.xingji.frameproject.vo.form.PurchaseOrderDetailsQueryForm;
import java.util.List;
import com.github.pagehelper.PageInfo;

/**
 * (PurchaseOrderDetails)表服务接口
 *
 * @author makejava
 * @since 2021-06-02 09:52:31
 */
public interface PurchaseOrderDetailsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseOrderDetails queryById(Integer id);

    List<PurchaseOrderDetails> queryAllByOrderId(String orderid);

    /**
     * 查询所有数据
     *
     * @param purchaseOrderDetailsQueryForm 实例对象
     * @return 实例对象
     */
    PageInfo<PurchaseOrderDetails> queryAll(PurchaseOrderDetailsQueryForm purchaseOrderDetailsQueryForm);

    /**
     * 根据查询条件搜索数据
     *
     * @param purchaseOrderDetailsQueryForm
     * @return 对象列表
     */
    PageInfo<PurchaseOrderDetails> queryBySearch(PurchaseOrderDetailsQueryForm purchaseOrderDetailsQueryForm);

    /**
     * 根据查询条件筛选数据
     *
     * @param purchaseOrderDetailsQueryForm
     * @return 对象列表
     */
    PageInfo<PurchaseOrderDetails> queryByScreen(PurchaseOrderDetailsQueryForm purchaseOrderDetailsQueryForm);

    /**
     * 新增数据
     *
     * @param purchaseOrderDetails 实例对象
     * @return 实例对象
     */
    PurchaseOrderDetails insert(PurchaseOrderDetails purchaseOrderDetails);

    /**
     * 批量新增数据
     *
     * @param PurchaseOrderDetailsList 实例对象列表
     * @return 影响行数
     */
    int insertBatch(List<PurchaseOrderDetails> PurchaseOrderDetailsList);

    /**
     * 修改数据
     *
     * @param purchaseOrderDetails 实例对象
     * @return 实例对象
     */
    PurchaseOrderDetails update(PurchaseOrderDetails purchaseOrderDetails);



    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);



}