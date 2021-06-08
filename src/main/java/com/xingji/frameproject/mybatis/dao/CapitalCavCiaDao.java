package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.CapitalCavCia;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (CapitalCavCia)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-08 18:35:41
 */
@Mapper
public interface CapitalCavCiaDao {

    /**
     * 通过ID查询单条数据
     *
     * @param cavId 主键
     * @return 实例对象
     */
    CapitalCavCia queryById(String cavId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalCavCia> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param capitalCavCia 实例对象
     * @return 对象列表
     */
    List<CapitalCavCia> queryAll(CapitalCavCia capitalCavCia);

    /**
     * 新增数据
     *
     * @param capitalCavCia 实例对象
     * @return 影响行数
     */
    int insert(CapitalCavCia capitalCavCia);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalCavCia> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CapitalCavCia> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalCavCia> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<CapitalCavCia> entities);

    /**
     * 修改数据
     *
     * @param capitalCavCia 实例对象
     * @return 影响行数
     */
    int update(CapitalCavCia capitalCavCia);

    /**
     * 通过主键删除数据
     *
     * @param cavId 主键
     * @return 影响行数
     */
    int deleteById(String cavId);

}

