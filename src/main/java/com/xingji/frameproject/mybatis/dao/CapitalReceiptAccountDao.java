package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.CapitalReceiptAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (CapitalReceiptAccount)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-02 20:17:31
 */
@Mapper
public interface CapitalReceiptAccountDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<CapitalReceiptAccount> queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalReceiptAccount> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param capitalReceiptAccount 实例对象
     * @return 对象列表
     */
    List<CapitalReceiptAccount> queryAll(CapitalReceiptAccount capitalReceiptAccount);

    /**
     * 新增数据
     *
     * @param capitalReceiptAccount 实例对象
     * @return 影响行数
     */
    int insert(CapitalReceiptAccount capitalReceiptAccount);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalReceiptAccount> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CapitalReceiptAccount> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalReceiptAccount> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<CapitalReceiptAccount> entities);

    /**
     * 修改数据
     *
     * @param capitalReceiptAccount 实例对象
     * @return 影响行数
     */
    int update(CapitalReceiptAccount capitalReceiptAccount);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

