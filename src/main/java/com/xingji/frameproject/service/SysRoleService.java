package com.xingji.frameproject.service;

public interface SysRoleService {
   /**
    * 通过角色id获取角色名
    * @param roleId
    * @return
    */
   String queryRoleNameByroleId(Integer roleId);
}
