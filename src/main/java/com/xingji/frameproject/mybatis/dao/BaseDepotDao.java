package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.BaseDepot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BaseDepot)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-28 19:29:58
 */
@Mapper
public interface BaseDepotDao {

    /**
     * 通过ID查询单条数据
     *
     * @param depotNumber 主键
     * @return 实例对象
     */
    BaseDepot queryById(String depotNumber);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseDepot> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseDepot 实例对象
     * @return 对象列表
     */
    List<BaseDepot> queryAll(BaseDepot baseDepot);

    /**
     * 新增数据
     *
     * @param baseDepot 实例对象
     * @return 影响行数
     */
    int insert(BaseDepot baseDepot);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseDepot> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BaseDepot> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseDepot> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<BaseDepot> entities);

    /**
     * 修改数据
     *
     * @param baseDepot 实例对象
     * @return 影响行数
     */
    int update(BaseDepot baseDepot);

    /**
     * 通过主键删除数据
     *
     * @param depotNumber 主键
     * @return 影响行数
     */
    int deleteById(String depotNumber);

    /**
     * 查询所有仓库
     * @return
     */
    List<BaseDepot> findAllDepot();
    /**
     * 查询所有的仓库
     * @return
     */
    List<BaseDepot> findAll();
}

