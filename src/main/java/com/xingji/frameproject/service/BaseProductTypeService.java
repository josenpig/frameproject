package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.BaseProductType;

import java.util.List;

/**
 * (BaseProductType)表服务接口
 *
 * @author makejava
 * @since 2021-06-15 10:00:16
 */
public interface BaseProductTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param productTypeId 主键
     * @return 实例对象
     */
    BaseProductType queryById(Integer productTypeId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseProductType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param baseProductType 实例对象
     * @return 实例对象
     */
    BaseProductType insert(BaseProductType baseProductType);

    /**
     * 修改数据
     *
     * @param baseProductType 实例对象
     * @return 实例对象
     */
    BaseProductType update(BaseProductType baseProductType);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseProductType 实例对象
     * @return 对象列表
     */
    List<BaseProductType> queryAll(BaseProductType baseProductType);

    /**
     * 通过主键删除数据
     *
     * @param productTypeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer productTypeId);

}
