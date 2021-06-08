package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.BaseVendor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * (BaseVendor)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-04 15:11:24
 */
@Mapper
public interface BaseVendorDao {

    /**
     * 通过ID查询单条数据
     *
     * @param vendorId 主键
     * @return 实例对象
     */
    BaseVendor queryById(String vendorId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseVendor> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseVendor 实例对象
     * @return 对象列表
     */
    List<BaseVendor> queryAll(BaseVendor baseVendor);

    /**
     * 新增数据
     *
     * @param baseVendor 实例对象
     * @return 影响行数
     */
    int insert(BaseVendor baseVendor);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseVendor> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BaseVendor> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseVendor> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<BaseVendor> entities);

    /**
     * 修改数据
     *
     * @param baseVendor 实例对象
     * @return 影响行数
     */
    int update(BaseVendor baseVendor);

    /**
     * 通过主键删除数据
     *
     * @param vendorId 主键
     * @return 影响行数
     */
    int deleteById(String vendorId);

    /**
     * 查询所有供应商信息
     * @return
     */
    List<BaseVendor> findAllVendor(BaseVendor baseVendor);
}

