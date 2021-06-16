package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.CapitalPaymentAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (CapitalPaymentAccount)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-16 19:13:29
 */
@Mapper
public interface CapitalPaymentAccountDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CapitalPaymentAccount queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalPaymentAccount> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param capitalPaymentAccount 实例对象
     * @return 对象列表
     */
    List<CapitalPaymentAccount> queryAll(CapitalPaymentAccount capitalPaymentAccount);

    /**
     * 新增数据
     *
     * @param capitalPaymentAccount 实例对象
     * @return 影响行数
     */
    int insert(CapitalPaymentAccount capitalPaymentAccount);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalPaymentAccount> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CapitalPaymentAccount> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalPaymentAccount> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<CapitalPaymentAccount> entities);

    /**
     * 修改数据
     *
     * @param capitalPaymentAccount 实例对象
     * @return 影响行数
     */
    int update(CapitalPaymentAccount capitalPaymentAccount);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

