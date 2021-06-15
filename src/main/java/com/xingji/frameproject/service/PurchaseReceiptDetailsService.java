package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.PurchaseReceiptDetails;

import java.util.List;

/**
 * (PurchaseReceiptDetails)表服务接口
 *
 * @author makejava
 * @since 2021-06-15 18:48:49
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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PurchaseReceiptDetails> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param purchaseReceiptDetails 实例对象
     * @return 实例对象
     */
    PurchaseReceiptDetails insert(PurchaseReceiptDetails purchaseReceiptDetails);

    /**
     * 修改数据
     *
     * @param purchaseReceiptDetails 实例对象
     * @return 实例对象
     */
    PurchaseReceiptDetails update(PurchaseReceiptDetails purchaseReceiptDetails);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}