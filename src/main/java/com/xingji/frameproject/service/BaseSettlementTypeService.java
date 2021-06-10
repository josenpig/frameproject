package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.BaseSettlementType;

import java.util.List;

/**
 * (BaseSettlementType)表服务接口
 *
 * @author makejava
 * @since 2021-06-10 16:22:51
 */
public interface BaseSettlementTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BaseSettlementType queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseSettlementType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param baseSettlementType 实例对象
     * @return 实例对象
     */
    BaseSettlementType insert(BaseSettlementType baseSettlementType);

    /**
     * 修改数据
     *
     * @param baseSettlementType 实例对象
     * @return 实例对象
     */
    BaseSettlementType update(BaseSettlementType baseSettlementType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseSettlementType 实例对象
     * @return 对象列表
     */
    List<BaseSettlementType> queryAll(BaseSettlementType baseSettlementType);
}
