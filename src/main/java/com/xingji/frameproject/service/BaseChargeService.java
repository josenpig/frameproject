package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.BaseCharge;

import java.util.List;

/**
 * (BaseCharge)表服务接口
 *
 * @author makejava
 * @since 2021-06-01 17:01:49
 */
public interface BaseChargeService {

    /**
     * 通过ID查询单条数据
     *
     * @param chargeId 主键
     * @return 实例对象
     */
    BaseCharge queryById(Integer chargeId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseCharge> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param baseCharge 实例对象
     * @return 实例对象
     */
    BaseCharge insert(BaseCharge baseCharge);

    /**
     * 修改数据
     *
     * @param baseCharge 实例对象
     * @return 实例对象
     */
    BaseCharge update(BaseCharge baseCharge);

    /**
     * 通过主键删除数据
     *
     * @param chargeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer chargeId);

    /**
     * 查询所有负责人
     * @return
     */
    List<BaseCharge> findAllCharge();
}
