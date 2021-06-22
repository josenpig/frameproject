package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.PurchaseReturnsDetails;

import java.util.List;

/**
 * (PurchaseReturnsDetails)表服务接口
 *
 * @author makejava
 * @since 2021-06-15 18:49:12
 */
public interface PurchaseReturnsDetailsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseReturnsDetails queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PurchaseReturnsDetails> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param purchaseReturnsDetails 实例对象
     * @return 实例对象
     */
    PurchaseReturnsDetails insert(PurchaseReturnsDetails purchaseReturnsDetails);

    /**
     * 修改数据
     *
     * @param purchaseReturnsDetails 实例对象
     * @return 实例对象
     */
    PurchaseReturnsDetails update(PurchaseReturnsDetails purchaseReturnsDetails);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    int insertBatch(List<PurchaseReturnsDetails> deliverydetails);

    /**
     * 根据采购退货单查询采购退货单详情
     * @param id
     * @return
     */
    List<PurchaseReturnsDetails> queryAllByOrderId(String id);
}
