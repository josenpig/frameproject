package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.PurchaseReturns;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PurchaseReturns)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-15 18:49:01
 */
@Mapper
public interface PurchaseReturnsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseReturns queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PurchaseReturns> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param purchaseReturns 实例对象
     * @return 对象列表
     */
    List<PurchaseReturns> queryAll(PurchaseReturns purchaseReturns);

    /**
     * 新增数据
     *
     * @param purchaseReturns 实例对象
     * @return 影响行数
     */
    int insert(PurchaseReturns purchaseReturns);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PurchaseReturns> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PurchaseReturns> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PurchaseReturns> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PurchaseReturns> entities);

    /**
     * 修改数据
     *
     * @param purchaseReturns 实例对象
     * @return 影响行数
     */
    int update(PurchaseReturns purchaseReturns);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

