package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.BaseOpening;

import java.util.List;

/**
 * (BaseOpening)表服务接口
 *
 * @author makejava
 * @since 2021-05-28 08:59:41
 */
public interface BaseOpeningService {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    BaseOpening queryById();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseOpening> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param baseOpening 实例对象
     * @return 实例对象
     */
    BaseOpening insert(BaseOpening baseOpening);

    /**
     * 修改数据
     *
     * @param baseOpening 实例对象
     * @return 实例对象
     */
    BaseOpening update(BaseOpening baseOpening);

    /**
     * 通过主键删除数据
     *
     * @return 是否成功
     */
    boolean deleteById();

    List<BaseOpening> finddepot(String productId);

    boolean expectreduce(String productId, String depotName, int expectNumber);

    boolean productereduce(String productId, String depotName, int product_number);

    boolean expectadd(String productId, String depotName, int expectNumber);

    boolean producteadd(String productId, String depotName, int product_number);
}
