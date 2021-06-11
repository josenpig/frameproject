package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (SysRoleMenu)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-11 18:32:42
 */
@Mapper
public interface SysRoleMenuDao {

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysRoleMenu 实例对象
     * @return 对象列表
     */
    List<SysRoleMenu> queryAll(SysRoleMenu sysRoleMenu);

    /**
     * 新增数据
     *
     * @param sysRoleMenu 实例对象
     * @return 影响行数
     */
    int insert(SysRoleMenu sysRoleMenu);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRoleMenu> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysRoleMenu> entities);

    /**
     * 通过角色删除数据
     *
     * @param
     * @return 影响行数
     */
    int deleteById(Integer roleId);

}

