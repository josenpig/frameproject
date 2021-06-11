package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (SysMenu)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-15 15:36:27
 */
@Mapper
public interface SysMenuDao {
    /**
     * 通过用户id查询对应菜单
     * @param userId 用户id
     * @return 对象列表
     */
    List<SysMenu> usermenu(Integer userId);
    /**
     * 通过角色id查询对应菜单
     * @param roleId 角色id
     * @return 对象列表
     */
    List<SysMenu> rolemenu(Integer roleId);
    /**
     * 通过菜单id修改菜单实体类
     *
     * @param sysMenu 菜单
     * @return 对象列表
     */
    int change(SysMenu sysMenu);

}

