package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.SaleOrder;
import com.xingji.frameproject.vo.SaleConditionPageVo;
import com.xingji.frameproject.vo.SaleReceiptVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (SaleOrder)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-20 19:03:51
 */
@Mapper
public interface SaleOrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    SaleOrder queryById(String orderId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SaleOrder> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param saleOrder 实例对象
     * @return 对象列表
     */
    List<SaleOrder> queryAll(SaleOrder saleOrder);

    /**
     * 新增数据
     *
     * @param saleOrder 实例对象
     * @return 影响行数
     */
    int insert(SaleOrder saleOrder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SaleOrder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SaleOrder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SaleOrder> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SaleOrder> entities);

    /**
     * 修改数据
     *
     * @param saleOrder 实例对象
     * @return 影响行数
     */
    int update(SaleOrder saleOrder);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 影响行数
     */
    int deleteById(String orderId);
    /**
     * 分页查询
     *
     * @return 影响行数
     */
    List <SaleOrder> conditionpage(SaleConditionPageVo order);
    /**
     * 通过实体类查询所有可收款单
     * @param vo 实体类
     * @return 对象列表
     */
    List<SaleReceiptVo> queryReceipt(SaleReceiptVo vo);
    /**
     * 通过订单id查询本次收款单信息
     * @param saleId 销售单id
     * @return 对象列表
     */
    SaleReceiptVo querythisReceipt(String saleId);
    /**
     * 修改订单已收款数据
     *
     * @param saleOrder 实例对象
     * @return 实例对象
     */
    boolean advanceadd(SaleOrder saleOrder);
}

