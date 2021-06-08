package com.xingji.frameproject.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * (SysMenu)实体类
 *
 * @author makejava
 * @since 2021-05-22 19:02:25
 */
@Data
public class SysMenu implements Serializable {
    private static final long serialVersionUID = -44758494030917654L;
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
     * 菜单类型（M目录 C菜单 F按钮）
     */
    private String menuType;
    /**
     * 路由地址
     */
    private String path;
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
     * 路由名
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<SysMenu> childMenu =new ArrayList();//菜单信息树

    public List<SysMenu> getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(List<SysMenu> childMenu) {
        this.childMenu = childMenu;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

}
