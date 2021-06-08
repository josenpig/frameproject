package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.BaseCharge;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BaseCharge)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-01 16:45:26
 */
@Mapper
public interface BaseChargeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param chargeId 主键
     * @return 实例对象
     */
    BaseCharge queryById(Integer chargeId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseCharge> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseCharge 实例对象
     * @return 对象列表
     */
    List<BaseCharge> queryAll(BaseCharge baseCharge);

    /**
     * 新增数据
     *
     * @param baseCharge 实例对象
     * @return 影响行数
     */
    int insert(BaseCharge baseCharge);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseCharge> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BaseCharge> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseCharge> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<BaseCharge> entities);

    /**
     * 修改数据
     *
     * @param baseCharge 实例对象
     * @return 影响行数
     */
    int update(BaseCharge baseCharge);

    /**
     * 通过主键删除数据
     *
     * @param chargeId 主键
     * @return 影响行数
     */
    int deleteById(Integer chargeId);

    /**
     * 查询所有负责人
     * @return
     */
    List<BaseCharge> findAllCharge();
}

