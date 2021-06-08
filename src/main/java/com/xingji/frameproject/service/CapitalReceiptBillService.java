package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.CapitalReceiptBill;

import java.util.List;

/**
 * (CapitalReceiptBill)表服务接口
 *
 * @author makejava
 * @since 2021-06-02 20:22:25
 */
public interface CapitalReceiptBillService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<CapitalReceiptBill> queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalReceiptBill> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param capitalReceiptBill 实例对象
     * @return 实例对象
     */
    CapitalReceiptBill insert(CapitalReceiptBill capitalReceiptBill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<CapitalReceiptBill> insertBatch(List<CapitalReceiptBill> capitalReceiptBill);

    boolean update(CapitalReceiptBill capitalReceiptBill);
}
