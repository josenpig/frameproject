package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.dao.SysUserRoleDao;
import com.xingji.frameproject.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("SysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Resource
    private SysUserRoleDao sysUserRoleDao;

    /**
     * 通过用户id获取角色id
     * @param UserId
     * @return
     */
    @Override
    public List<Integer> queryRoleIdbyUserId(Integer UserId) {
        return sysUserRoleDao.queryRoleIdByUserId(UserId);
    }
}
