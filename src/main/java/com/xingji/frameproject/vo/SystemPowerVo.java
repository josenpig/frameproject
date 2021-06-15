package com.xingji.frameproject.vo;

import com.xingji.frameproject.mybatis.entity.SysMenu;
import com.xingji.frameproject.mybatis.entity.SysRole;
import com.xingji.frameproject.mybatis.entity.SysUser;
import lombok.Data;

import java.util.List;

/***
 * @author: 顾渊白
 * @date: 2021/6/11 11:44
 * @version 1.0
 */
@Data
public class SystemPowerVo {
    private List<SysMenu> allmenus;
    private List<SysMenu> menus;
}
