package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.BaseOpening;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (BaseOpening)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-28 08:49:01
 */
@Mapper
public interface BaseOpeningDao {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    BaseOpening queryById();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseOpening> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseOpening 实例对象
     * @return 对象列表
     */
    List<BaseOpening> queryAll(BaseOpening baseOpening);

    /**
     * 新增数据
     *
     * @param baseOpening 实例对象
     * @return 影响行数
     */
    int insert(BaseOpening baseOpening);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseOpening> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BaseOpening> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseOpening> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<BaseOpening> entities);

    /**
     * 修改数据
     *
     * @param baseOpening 实例对象
     * @return 影响行数
     */
    int update(BaseOpening baseOpening);

    /**
     * 通过主键删除数据
     *
     * @return 影响行数
     */
    int deleteById();
    List<BaseOpening> finddepot(String productId);
    /**
     * 通过产品及仓库修改库存
     *
     * @return 成功失败
     */
    boolean expectreduce(@Param("productId") String productId,@Param("depotName")String depotName,@Param("expectNumber")int expectNumber);
    boolean productereduce(@Param("productId")String productId,@Param("depotName")String depotName,@Param("productNumber")int productNumber);
    boolean expectadd(@Param("productId") String productId,@Param("depotName")String depotName,@Param("expectNumber")int expectNumber);
    boolean producteadd(@Param("productId")String productId,@Param("depotName")String depotName,@Param("productNumber")int productNumber);
}

