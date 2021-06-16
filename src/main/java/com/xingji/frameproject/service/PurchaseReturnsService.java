package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.PurchaseReturns;

import java.util.List;

/**
 * (PurchaseReturns)表服务接口
 *
 * @author makejava
 * @since 2021-06-15 18:49:01
 */
public interface PurchaseReturnsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseReturns queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PurchaseReturns> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param purchaseReturns 实例对象
     * @return 实例对象
     */
    PurchaseReturns insert(PurchaseReturns purchaseReturns);

    /**
     * 修改数据
     *
     * @param purchaseReturns 实例对象
     * @return 实例对象
     */
    PurchaseReturns update(PurchaseReturns purchaseReturns);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
