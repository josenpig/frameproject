package com.xingji.frameproject.service;

import java.util.List;

public interface SysUserRoleService {
    /**
     * 通过用户id获取角色id
     * @param UserId
     * @return
     */
    List<Integer> queryRoleIdbyUserId(Integer UserId);
}
