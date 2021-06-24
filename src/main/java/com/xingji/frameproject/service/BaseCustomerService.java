package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.BaseCustomer;

import java.util.List;

/**
 * (BaseCustomer)表服务接口
 *
 * @author makejava
 * @since 2021-06-03 16:44:13
 */
public interface BaseCustomerService {

    /**
     * 通过ID查询单条数据
     *
     * @param customerNumber 主键
     * @return 实例对象
     */
    BaseCustomer queryById(String customerNumber);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseCustomer> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param baseCustomer 实例对象
     * @return 实例对象
     */
    BaseCustomer insert(BaseCustomer baseCustomer);

    /**
     * 修改数据
     *
     * @param baseCustomer 实例对象
     * @return 实例对象
     */
    BaseCustomer update(BaseCustomer baseCustomer);

    /**
     * 通过主键删除数据
     *
     * @param customerNumber 主键
     * @return 是否成功
     */
    String deleteById(String customerNumber);

    List<BaseCustomer> queryAll(BaseCustomer baseCustomer);
    /**
     * 查询所有客户信息||通过条件查询客户
     * @return
     */
    List<BaseCustomer> findAllCustomer(BaseCustomer baseCustomer);
}
