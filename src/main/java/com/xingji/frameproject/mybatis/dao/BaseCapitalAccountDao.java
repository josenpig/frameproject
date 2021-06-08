package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.BaseCapitalAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (BaseCapitalAccount)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-02 18:29:45
 */
@Mapper
public interface BaseCapitalAccountDao {

    /**
     * 通过ID查询单条数据
     *
     * @param capitalId 主键
     * @return 实例对象
     */
    BaseCapitalAccount queryById(String capitalId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseCapitalAccount> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseCapitalAccount 实例对象
     * @return 对象列表
     */
    List<BaseCapitalAccount> queryAll(BaseCapitalAccount baseCapitalAccount);

    /**
     * 新增数据
     *
     * @param baseCapitalAccount 实例对象
     * @return 影响行数
     */
    int insert(BaseCapitalAccount baseCapitalAccount);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseCapitalAccount> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BaseCapitalAccount> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseCapitalAccount> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<BaseCapitalAccount> entities);

    /**
     * 修改数据
     *
     * @param baseCapitalAccount 实例对象
     * @return 影响行数
     */
    int update(BaseCapitalAccount baseCapitalAccount);

    /**
     * 通过主键删除数据
     *
     * @param capitalId 主键
     * @return 影响行数
     */
    int deleteById(String capitalId);
    /**
     * 查询所有资金账户
     * @return
     */
    List<BaseCapitalAccount> findAllCapitalAccount();
    boolean currentAmountadd(BaseCapitalAccount baseCapitalAccount);
}

