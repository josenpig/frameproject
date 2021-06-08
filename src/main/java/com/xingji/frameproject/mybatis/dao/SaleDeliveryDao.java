package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.SaleDelivery;
import com.xingji.frameproject.vo.SaleConditionPageVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (SaleDelivery)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-24 11:45:15
 */
@Mapper
public interface SaleDeliveryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param deliveryId 主键
     * @return 实例对象
     */
    SaleDelivery queryById(String deliveryId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SaleDelivery> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param saleDelivery 实例对象
     * @return 对象列表
     */
    List<SaleDelivery> queryAll(SaleDelivery saleDelivery);

    /**
     * 新增数据
     *
     * @param saleDelivery 实例对象
     * @return 影响行数
     */
    int insert(SaleDelivery saleDelivery);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SaleDelivery> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SaleDelivery> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SaleDelivery> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SaleDelivery> entities);

    /**
     * 修改数据
     *
     * @param saleDelivery 实例对象
     * @return 影响行数
     */
    int update(SaleDelivery saleDelivery);

    /**
     * 通过主键删除数据
     *
     * @param deliveryId 主键
     * @return 影响行数
     */
    int deleteById(String deliveryId);
    /**
     * 分页查询
     *
     * @return 影响行数
     */
    List <SaleDelivery> queryAllByPage();
    /**
     * 查询可退换单据
     *
     * @return 影响行数
     */
    List<SaleDelivery> canreturn();
    List <SaleDelivery> conditionpage(SaleConditionPageVo order);
}

