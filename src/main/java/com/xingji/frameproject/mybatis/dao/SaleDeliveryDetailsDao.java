package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.SaleDeliveryDetails;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (SaleDeliveryDetails)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-24 11:48:17
 */
@Mapper
public interface SaleDeliveryDetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param deliveryId
     * @return 实例对象
     */
    List<SaleDeliveryDetails> queryById(String deliveryId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SaleDeliveryDetails> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param saleDeliveryDetails 实例对象
     * @return 对象列表
     */
    List<SaleDeliveryDetails> queryAll(SaleDeliveryDetails saleDeliveryDetails);

    /**
     * 新增数据
     *
     * @param saleDeliveryDetails 实例对象
     * @return 影响行数
     */
    int insert(SaleDeliveryDetails saleDeliveryDetails);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SaleDeliveryDetails> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SaleDeliveryDetails> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SaleDeliveryDetails> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SaleDeliveryDetails> entities);

    /**
     * 修改数据
     *
     * @param saleDeliveryDetails 实例对象
     * @return 影响行数
     */
    int update(SaleDeliveryDetails saleDeliveryDetails);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

