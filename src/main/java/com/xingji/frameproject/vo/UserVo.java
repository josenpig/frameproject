package com.xingji.frameproject.vo;

import com.xingji.frameproject.mybatis.entity.SysMenu;
import com.xingji.frameproject.mybatis.entity.SysUser;
import lombok.Data;

import java.util.List;


@Data
public class UserVo {
    private String token;
    private boolean isValidate;
    private SysUser user;
    private List<SysMenu> menus;
}