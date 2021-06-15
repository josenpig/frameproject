package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.PurchaseReceiptDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PurchaseReceiptDetails)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-15 18:48:49
 */
public interface PurchaseReceiptDetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseReceiptDetails queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PurchaseReceiptDetails> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param purchaseReceiptDetails 实例对象
     * @return 对象列表
     */
    List<PurchaseReceiptDetails> queryAll(PurchaseReceiptDetails purchaseReceiptDetails);

    /**
     * 新增数据
     *
     * @param purchaseReceiptDetails 实例对象
     * @return 影响行数
     */
    int insert(PurchaseReceiptDetails purchaseReceiptDetails);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PurchaseReceiptDetails> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PurchaseReceiptDetails> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PurchaseReceiptDetails> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PurchaseReceiptDetails> entities);

    /**
     * 修改数据
     *
     * @param purchaseReceiptDetails 实例对象
     * @return 影响行数
     */
    int update(PurchaseReceiptDetails purchaseReceiptDetails);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

