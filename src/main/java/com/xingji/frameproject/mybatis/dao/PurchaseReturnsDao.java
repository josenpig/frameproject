package com.xingji.frameproject.mybatis.dao;


import com.xingji.frameproject.mybatis.entity.PurchaseReturns;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PurchaseReturns)表数据库访问层
 *
 * @author protagonist
 * @since 2021-06-18 00:46:46
 */
@Mapper
public interface PurchaseReturnsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseReturns selectById(String id);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<PurchaseReturns> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param purchaseReturns 实例对象
     * @return 对象列表
     */
    List<PurchaseReturns> selectList(PurchaseReturns purchaseReturns);

    /**
     * 新增数据
     *
     * @param purchaseReturns 实例对象
     * @return 影响行数
     */
    int insert(PurchaseReturns purchaseReturns);

    /**
     * 批量新增
     *
     * @param purchaseReturnss 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<PurchaseReturns> purchaseReturnss);

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

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}
