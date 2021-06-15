package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.SysRole;
import com.xingji.frameproject.mybatis.entity.SysRoleMenu;

import java.util.List;

public interface SysRoleService {
   /**
    * 通过角色id获取角色名
    * @param roleId
    * @return
    */
   String queryRoleNameByroleId(Integer roleId);

   List<SysRole> queryAll(SysRole role);

    List<SysRole> userhasrole(Integer userId);

    boolean update(SysRole sysRole);

    boolean deletemenus(Integer roleId);

    boolean insertBatch(List<SysRoleMenu> sysRoleMenus);

}
