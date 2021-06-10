package com.xingji.frameproject.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (SysMenu)实体类
 *
 * @author makejava
 * @since 2021-06-10 11:22:48
 */
@Data
public class SysMenu implements Serializable {
    private static final long serialVersionUID = -85448115594527407L;
    /**
     * 菜单id
     */
    private Integer menuId;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 父菜单id
     */
    private Integer parentId;
    /**
     * 组件排序
     */
    private Integer orderNum;
    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    private String menuType;
    /**
     * 路由地址
     */
    private String path;
    /**
     * 路由名
     */
    private String name;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 权限标识
     */
    private String perms;
    /**
     * 菜单状态（0显示 1隐藏）
     */
    private Integer visible;
    /**
     * 组件路径
     */
    private String component;
    /**
     * 子组件
     */
    private List<SysMenu> childMenu;
}
