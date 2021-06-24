package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.BaseCustomer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BaseCustomer)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-04 10:30:53
 */
@Mapper
public interface BaseCustomerDao {

    /**
     * 查询客户
     *
     * @param customerNumber 主键
     * @return 实例对象
     */
    BaseCustomer queryById(String customerNumber);


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseCustomer> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseCustomer 实例对象
     * @return 对象列表
     */
    List<BaseCustomer> queryAll(BaseCustomer baseCustomer);

    /**
     * 新增数据
     *
     * @param baseCustomer 实例对象
     * @return 影响行数
     */
    int insert(BaseCustomer baseCustomer);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseCustomer> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BaseCustomer> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseCustomer> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<BaseCustomer> entities);

    /**
     * 修改数据
     *
     * @param baseCustomer 实例对象
     * @return 影响行数
     */
    int update(BaseCustomer baseCustomer);

    /**
     * 通过主键删除数据
     *
     * @param customerNumber 主键
     * @return 影响行数
     */
    int deleteById(String customerNumber);

    /**
     * 查询所有客户信息
     * @return
     */
    List<BaseCustomer> findAllCustomer(BaseCustomer baseCustomer);

}