package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.SaleOrderDetails;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (SaleOrderDetails)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-20 19:05:27
 */
@Mapper
public interface SaleOrderDetailsDao {

    /**
     * 通过订单ID查询数据
     *
     * @param orderid
     * @return 实例对象
     */
    List<SaleOrderDetails> queryById(String orderid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SaleOrderDetails> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param saleOrderDetails 实例对象
     * @return 对象列表
     */
    List<SaleOrderDetails> queryAll(SaleOrderDetails saleOrderDetails);

    /**
     * 新增数据
     *
     * @param saleOrderDetails 实例对象
     * @return 影响行数
     */
    int insert(SaleOrderDetails saleOrderDetails);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SaleOrderDetails> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SaleOrderDetails> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SaleOrderDetails> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SaleOrderDetails> entities);

    /**
     * 修改数据
     *
     * @param saleOrderDetails 实例对象
     * @return 影响行数
     */
    int update(SaleOrderDetails saleOrderDetails);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

