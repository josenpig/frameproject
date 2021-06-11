package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.BaseUnit;

import java.util.List;

/**
 * (BaseUnit)表服务接口
 *
 * @author makejava
 * @since 2021-06-09 14:36:37
 */
public interface BaseUnitService {

    /**
     * 通过ID查询单条数据
     *
     * @param unitId 主键
     * @return 实例对象
     */
    BaseUnit queryById(Integer unitId);

    /**
     * 新增数据
     *
     * @param baseUnit 实例对象
     * @return 实例对象
     */
    BaseUnit insert(BaseUnit baseUnit);

    /**
     * 修改数据
     *
     * @param baseUnit 实例对象
     * @return 实例对象
     */
    BaseUnit update(BaseUnit baseUnit);

    /**
     * 通过主键删除数据
     *
     * @param unitId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer unitId);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseUnit 实例对象
     * @return 对象列表
     */
    List<BaseUnit> queryAll(BaseUnit baseUnit);
}
