package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.PurchaseReturnsDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PurchaseReturnsDetails)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-15 18:49:12
 */
public interface PurchaseReturnsDetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseReturnsDetails queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PurchaseReturnsDetails> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param purchaseReturnsDetails 实例对象
     * @return 对象列表
     */
    List<PurchaseReturnsDetails> queryAll(PurchaseReturnsDetails purchaseReturnsDetails);

    /**
     * 新增数据
     *
     * @param purchaseReturnsDetails 实例对象
     * @return 影响行数
     */
    int insert(PurchaseReturnsDetails purchaseReturnsDetails);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PurchaseReturnsDetails> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PurchaseReturnsDetails> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PurchaseReturnsDetails> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PurchaseReturnsDetails> entities);

    /**
     * 修改数据
     *
     * @param purchaseReturnsDetails 实例对象
     * @return 影响行数
     */
    int update(PurchaseReturnsDetails purchaseReturnsDetails);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

