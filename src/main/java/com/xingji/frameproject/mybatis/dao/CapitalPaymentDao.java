package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.CapitalPayment;
import com.xingji.frameproject.vo.CapitalConditionPageVo;
import com.xingji.frameproject.vo.CiaCapVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (CapitalPayment)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-16 19:13:13
 */
@Mapper
public interface CapitalPaymentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param paymentId 主键
     * @return 实例对象
     */
    CapitalPayment queryById(String paymentId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalPayment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param vo 实例对象
     * @return 对象列表
     */
    List<CapitalPayment> queryAll(CapitalConditionPageVo vo);

    /**
     * 新增数据
     *
     * @param capitalPayment 实例对象
     * @return 影响行数
     */
    int insert(CapitalPayment capitalPayment);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalPayment> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CapitalPayment> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalPayment> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<CapitalPayment> entities);

    /**
     * 修改数据
     *
     * @param capitalPayment 实例对象
     * @return 影响行数
     */
    int update(CapitalPayment capitalPayment);

    /**
     * 通过主键删除数据
     *
     * @param paymentId 主键
     * @return 影响行数
     */
    int deleteById(String paymentId);
    /**
     * 通过实体类条件查询核销单中的付款单
     * @param vo 实体类
     * @return 影响行数
     */
    List<CiaCapVo> querycavPayment(CiaCapVo vo);
}

