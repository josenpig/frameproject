package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.CapitalPaymentAccount;

import java.util.List;

/**
 * (CapitalPaymentAccount)表服务接口
 *
 * @author makejava
 * @since 2021-06-16 19:14:02
 */
public interface CapitalPaymentAccountService {

    /**
     * 通过ID查询duo条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<CapitalPaymentAccount> queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalPaymentAccount> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param capitalPaymentAccount 实例对象
     * @return 实例对象
     */
    CapitalPaymentAccount insert(CapitalPaymentAccount capitalPaymentAccount);

    List<CapitalPaymentAccount> insertBatch(List<CapitalPaymentAccount> capitalPaymentAccount);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
