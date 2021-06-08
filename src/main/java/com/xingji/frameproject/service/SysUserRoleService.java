package com.xingji.frameproject.service;

public interface SysUserRoleService {
    /**
     * 通过用户id获取角色id
     * @param UserId
     * @return
     */
    Integer queryRoleIdbyUserId(Integer UserId);
}
