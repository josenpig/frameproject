package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.SaleReturn;
import com.xingji.frameproject.vo.SaleConditionPageVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (SaleReturn)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-30 21:16:52
 */
@Mapper
public interface SaleReturnDao {

    /**
     * 通过ID查询单条数据
     *
     * @param returnId 主键
     * @return 实例对象
     */
    SaleReturn queryByIdVo(String returnId);
    /**
     * 通过ID查询单条数据
     *
     * @param returnId 主键
     * @return 实例对象
     */
    SaleReturn queryById(String returnId);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SaleReturn> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param saleReturn 实例对象
     * @return 对象列表
     */
    List<SaleReturn> queryAll(SaleReturn saleReturn);

    /**
     * 新增数据
     *
     * @param saleReturn 实例对象
     * @return 影响行数
     */
    int insert(SaleReturn saleReturn);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SaleReturn> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SaleReturn> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SaleReturn> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SaleReturn> entities);

    /**
     * 修改数据
     *
     * @param saleReturn 实例对象
     * @return 影响行数
     */
    int update(SaleReturn saleReturn);

    /**
     * 通过主键删除数据
     *
     * @param returnId 主键
     * @return 影响行数
     */
    int deleteById(String returnId);
    /**
     * 分页查询
     * @return 影响行数
     */
    List <SaleReturn> conditionpage(SaleConditionPageVo order);
}

