package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.CapitalPayable;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (CapitalPayable)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-17 15:23:32
 */
@Mapper
public interface CapitalPayableDao {

    /**
     * 通过ID查询单条数据
     *
     * @param deliveryId 主键
     * @return 实例对象
     */
    CapitalPayable queryById(String deliveryId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalPayable> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param capitalPayable 实例对象
     * @return 对象列表
     */
    List<CapitalPayable> queryAll(CapitalPayable capitalPayable);

    /**
     * 新增数据
     *
     * @param capitalPayable 实例对象
     * @return 影响行数
     */
    int insert(CapitalPayable capitalPayable);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalPayable> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CapitalPayable> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalPayable> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<CapitalPayable> entities);

    /**
     * 修改数据
     *
     * @param capitalPayable 实例对象
     * @return 影响行数
     */
    int update(CapitalPayable capitalPayable);

    /**
     * 通过主键删除数据
     *
     * @param deliveryId 主键
     * @return 影响行数
     */
    int deleteById(String deliveryId);

}

