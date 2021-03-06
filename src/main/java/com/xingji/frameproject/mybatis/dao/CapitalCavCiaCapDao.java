package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.CapitalCavCiaCap;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (CapitalCavCiaCap)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-08 18:48:19
 */
@Mapper
public interface CapitalCavCiaCapDao {

    /**
     * 通过ID查询单条数据
     *
     * @param cavId
     * @return 实例对象
     */
    List<CapitalCavCiaCap> queryById(String cavId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalCavCiaCap> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param capitalCavCiaCap 实例对象
     * @return 对象列表
     */
    List<CapitalCavCiaCap> queryAll(CapitalCavCiaCap capitalCavCiaCap);

    /**
     * 新增数据
     *
     * @param capitalCavCiaCap 实例对象
     * @return 影响行数
     */
    int insert(CapitalCavCiaCap capitalCavCiaCap);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalCavCiaCap> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CapitalCavCiaCap> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalCavCiaCap> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<CapitalCavCiaCap> entities);

    /**
     * 修改数据
     *
     * @param capitalCavCiaCap 实例对象
     * @return 影响行数
     */
    int update(CapitalCavCiaCap capitalCavCiaCap);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

