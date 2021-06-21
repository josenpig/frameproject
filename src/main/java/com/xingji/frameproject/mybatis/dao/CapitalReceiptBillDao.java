package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.CapitalReceiptBill;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (CapitalReceiptBill)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-02 20:17:45
 */
@Mapper
public interface CapitalReceiptBillDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<CapitalReceiptBill> queryById(String id);
    /**
     * 通过ID查询关联单据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<CapitalReceiptBill> relation(String id);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalReceiptBill> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param capitalReceiptBill 实例对象
     * @return 对象列表
     */
    List<CapitalReceiptBill> queryAll(CapitalReceiptBill capitalReceiptBill);

    /**
     * 新增数据
     *
     * @param capitalReceiptBill 实例对象
     * @return 影响行数
     */
    int insert(CapitalReceiptBill capitalReceiptBill);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalReceiptBill> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CapitalReceiptBill> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalReceiptBill> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<CapitalReceiptBill> entities);

    /**
     * 修改数据
     *
     * @param capitalReceiptBill 实例对象
     * @return 影响行数
     */
    int update(CapitalReceiptBill capitalReceiptBill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

