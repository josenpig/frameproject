package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.CapitalCavCiaBill;
import com.xingji.frameproject.mybatis.entity.CapitalReceivable;
import com.xingji.frameproject.vo.CapitalConditionPageVo;
import com.xingji.frameproject.vo.CiaBillVo;
import com.xingji.frameproject.vo.SaleReceiptVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * (CapitalReceivable)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-01 11:26:21
 */
@Mapper
public interface CapitalReceivableDao {

    /**
     * 通过ID查询单条数据
     *
     * @param deliveryId 主键
     * @return 实例对象
     */
    CapitalReceivable queryById(String deliveryId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalReceivable> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param capitalReceivable 实例对象
     * @return 对象列表
     */
    List<CapitalReceivable> queryAll(CapitalReceivable capitalReceivable);

    /**
     * 新增数据
     *
     * @param capitalReceivable 实例对象
     * @return 影响行数
     */
    int insert(CapitalReceivable capitalReceivable);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalReceivable> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CapitalReceivable> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalReceivable> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<CapitalReceivable> entities);

    /**
     * 修改数据
     *
     * @param capitalReceivable 实例对象
     * @return 影响行数
     */
    int update(CapitalReceivable capitalReceivable);

    /**
     * 通过主键删除数据
     *
     * @param deliveryId 主键
     * @return 影响行数
     */
    int deleteById(String deliveryId);
    List<CapitalReceivable> queryAllByPage(CapitalConditionPageVo vo);
    /**
     * 通过实体类条件查询应收款单
     * @param vo 实体类
     * @return 影响行数
     */
    List<SaleReceiptVo> queryReceipt(SaleReceiptVo vo);
    /**
     * 通过saleId查询本次应收款单
     * @param saleId
     * @return 影响行数
     */
    SaleReceiptVo querythisReceipt(String saleId);
    int receivedadd(CapitalReceivable capitalReceivable);
    /**
     * 通过实体类条件查询核销单中的应收款单
     * @param vo 实体类
     * @return 影响行数
     */
    List<CiaBillVo> querycavReceipt(CiaBillVo vo);
}

