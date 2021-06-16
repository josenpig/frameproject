package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.CapitalPayment;

import java.util.List;

/**
 * (CapitalPayment)表服务接口
 *
 * @author makejava
 * @since 2021-06-16 19:14:12
 */
public interface CapitalPaymentService {

    /**
     * 通过ID查询单条数据
     *
     * @param paymentId 主键
     * @return 实例对象
     */
    CapitalPayment queryById(String paymentId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalPayment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param capitalPayment 实例对象
     * @return 实例对象
     */
    CapitalPayment insert(CapitalPayment capitalPayment);

    /**
     * 修改数据
     *
     * @param capitalPayment 实例对象
     * @return 实例对象
     */
    CapitalPayment update(CapitalPayment capitalPayment);

    /**
     * 通过主键删除数据
     *
     * @param paymentId 主键
     * @return 是否成功
     */
    boolean deleteById(String paymentId);

}
