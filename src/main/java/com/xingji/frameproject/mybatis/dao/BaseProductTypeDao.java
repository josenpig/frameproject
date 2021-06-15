package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.BaseProductType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BaseProductType)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-15 09:58:08
 */
@Mapper
public interface BaseProductTypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param productTypeId 主键
     * @return 实例对象
     */
    BaseProductType queryById(Integer productTypeId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseProductType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseProductType 实例对象
     * @return 对象列表
     */
    List<BaseProductType> queryAll(BaseProductType baseProductType);

    /**
     * 新增数据
     *
     * @param baseProductType 实例对象
     * @return 影响行数
     */
    int insert(BaseProductType baseProductType);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseProductType> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BaseProductType> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseProductType> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<BaseProductType> entities);

    /**
     * 修改数据
     *
     * @param baseProductType 实例对象
     * @return 影响行数
     */
    int update(BaseProductType baseProductType);

    /**
     * 通过主键删除数据
     *
     * @param productTypeId 主键
     * @return 影响行数
     */
    int deleteById(Integer productTypeId);

}

