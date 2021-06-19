package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.CapitalPaymentBill;

import java.util.List;

/**
 * (CapitalPaymentBill)表服务接口
 *
 * @author makejava
 * @since 2021-06-16 19:13:55
 */
public interface CapitalPaymentBillService {

    /**
     * 通过ID查询多条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<CapitalPaymentBill> queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalPaymentBill> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param capitalPaymentBill 实例对象
     * @return 实例对象
     */
    CapitalPaymentBill insert(CapitalPaymentBill capitalPaymentBill);

    List<CapitalPaymentBill> insertBatch(List<CapitalPaymentBill> capitalPaymentBill);


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
