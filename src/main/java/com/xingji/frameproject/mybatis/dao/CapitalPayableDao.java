package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.CapitalPayable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (CapitalPayable)表数据库访问层
 *
 * @author protagonist
 * @since 2021-06-17 11:19:05
 */
@Mapper
public interface CapitalPayableDao {

    /**
     * 通过ID查询单条数据
     *
     * @param deliveryId 主键
     * @return 实例对象
     */
    CapitalPayable selectById(String deliveryId);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<CapitalPayable> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param capitalPayable 实例对象
     * @return 对象列表
     */
    List<CapitalPayable> selectList(CapitalPayable capitalPayable);

    /**
     * 新增数据
     *
     * @param capitalPayable 实例对象
     * @return 影响行数
     */
    int insert(CapitalPayable capitalPayable);

    /**
     * 批量新增
     *
     * @param capitalPayables 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<CapitalPayable> capitalPayables);

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

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}
