package com.xingji.frameproject.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysRoleMenu)实体类
 *
 * @author makejava
 * @since 2021-06-11 18:32:41
 */
@Data
public class SysRoleMenu implements Serializable {
    private static final long serialVersionUID = 944238006075952458L;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 菜单id
     */
    private Integer menuId;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

}
