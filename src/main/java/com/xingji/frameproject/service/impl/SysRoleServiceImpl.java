package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.dao.SysRoleDao;
import com.xingji.frameproject.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("SyaRoleService")
@Slf4j
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleDao sysRoleDao;

    /**
     * 通过角色id获取角色名
     * @param roleId
     * @return
     */
    @Override
    public String queryRoleNameByroleId(Integer roleId) {
        return  sysRoleDao.queryRoleNameByroleId(roleId);

    }
}
