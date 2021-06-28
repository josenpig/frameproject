package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.SaleReturnDetails;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (SaleReturnDetails)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-30 19:05:38
 */
@Mapper
public interface SaleReturnDetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param returnId 主键
     * @return 实例对象
     */
    List<SaleReturnDetails> queryById(String returnId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SaleReturnDetails> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param saleReturnDetails 实例对象
     * @return 对象列表
     */
    List<SaleReturnDetails> queryAll(SaleReturnDetails saleReturnDetails);

    /**
     * 新增数据
     *
     * @param saleReturnDetails 实例对象
     * @return 影响行数
     */
    int insert(SaleReturnDetails saleReturnDetails);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SaleReturnDetails> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SaleReturnDetails> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SaleReturnDetails> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SaleReturnDetails> entities);

    /**
     * 修改数据
     *
     * @param saleReturnDetails 实例对象
     * @return 影响行数
     */
    int update(SaleReturnDetails saleReturnDetails);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

