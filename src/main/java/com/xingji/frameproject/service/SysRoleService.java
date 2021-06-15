package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.SysRole;
import com.xingji.frameproject.mybatis.entity.SysRoleMenu;
import com.xingji.frameproject.mybatis.entity.SysUserRole;

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

    List<SysUserRole> findtfhasuser(Integer roleId);

    boolean update(SysRole sysRole);

    boolean deletemenus(Integer roleId);

    boolean insertBatch(List<SysRoleMenu> sysRoleMenus);

<<<<<<< HEAD
=======
    SysRole insert(SysRole sysRole);
>>>>>>> ed5442202ac7008815ab9ba5cf69e8b886b29c21
}
