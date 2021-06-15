package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.PurchaseReceipt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PurchaseReceipt)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-15 18:48:35
 */
public interface PurchaseReceiptDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseReceipt queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PurchaseReceipt> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param purchaseReceipt 实例对象
     * @return 对象列表
     */
    List<PurchaseReceipt> queryAll(PurchaseReceipt purchaseReceipt);

    /**
     * 新增数据
     *
     * @param purchaseReceipt 实例对象
     * @return 影响行数
     */
    int insert(PurchaseReceipt purchaseReceipt);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PurchaseReceipt> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PurchaseReceipt> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PurchaseReceipt> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PurchaseReceipt> entities);

    /**
     * 修改数据
     *
     * @param purchaseReceipt 实例对象
     * @return 影响行数
     */
    int update(PurchaseReceipt purchaseReceipt);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

