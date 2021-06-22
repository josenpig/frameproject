package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.CapitalPaymentBill;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (CapitalPaymentBill)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-16 19:13:36
 */
@Mapper
public interface CapitalPaymentBillDao {

    /**
     * 通过ID查询多条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<CapitalPaymentBill> queryById(String id);
    /**
     * 通过ID查询关联单据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<CapitalPaymentBill> relation(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalPaymentBill> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param capitalPaymentBill 实例对象
     * @return 对象列表
     */
    List<CapitalPaymentBill> queryAll(CapitalPaymentBill capitalPaymentBill);

    /**
     * 新增数据
     *
     * @param capitalPaymentBill 实例对象
     * @return 影响行数
     */
    int insert(CapitalPaymentBill capitalPaymentBill);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalPaymentBill> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CapitalPaymentBill> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalPaymentBill> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<CapitalPaymentBill> entities);

    /**
     * 修改数据
     *
     * @param capitalPaymentBill 实例对象
     * @return 影响行数
     */
    int update(CapitalPaymentBill capitalPaymentBill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

