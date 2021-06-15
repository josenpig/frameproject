package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.dao.SysRoleDao;
import com.xingji.frameproject.mybatis.dao.SysRoleMenuDao;
import com.xingji.frameproject.mybatis.dao.SysUserRoleDao;
import com.xingji.frameproject.mybatis.entity.SysRole;
import com.xingji.frameproject.mybatis.entity.SysRoleMenu;
import com.xingji.frameproject.mybatis.entity.SysUserRole;
import com.xingji.frameproject.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("SyaRoleService")
@Slf4j
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleDao sysRoleDao;
    @Resource
    private SysRoleMenuDao sysRoleMenuDao;
    @Resource
    private SysUserRoleDao sysUserRoleDao;

    /**
     * 通过角色id获取角色名
     * @param roleId
     * @return
     */
    @Override
    public String queryRoleNameByroleId(Integer roleId) {
        return  sysRoleDao.queryRoleNameByroleId(roleId);

    }
    /**
     * 查询所有角色
     * @param role
     * @return
     */
    @Override
    public List<SysRole> queryAll(SysRole role) {
        return  sysRoleDao.queryAll(role);
    }
    /**
     * 通过用户id查询所属角色
     * @param userId 角色id
     * @return 实列对象
     */
    @Override
    public List<SysRole> userhasrole(Integer userId){
        return this.sysRoleDao.userhasrole(userId);
    }
    /**
     * 通过角色id查询该角色下是否存在用户
     * @param roleId 角色id
     * @return 影响行数
     */
    @Override
    public List<SysUserRole> findtfhasuser(Integer roleId){
        return this.sysUserRoleDao.findtfhasuser(roleId);
    }
    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 影响行数
     */
    @Override
    public boolean update(SysRole sysRole){
        return this.sysRoleDao.update(sysRole)>0;
    }
    /**
     * 通过角色id删除菜单权限
     * @param roleId 角色id
     * @return 影响行数
     */
    @Override
    public boolean deletemenus(Integer roleId){
        return this.sysRoleMenuDao.deleteById(roleId)>0;
    }
    /**
     * 批量新增角色菜单数据（MyBatis原生foreach方法）
     *
     * @param sysRoleMenus List<SysRoleMenu> 实例对象列表
     * @return 影响行数
     */
    @Override
    public boolean insertBatch(List<SysRoleMenu> sysRoleMenus){
        return this.sysRoleMenuDao.insertBatch(sysRoleMenus)>=0;
    }
    /**
     * 新增角色
     *
     * @param sysRole 实例对象
     * @return 新增对象
     */
    @Override
    public SysRole insert(SysRole sysRole){
        this.sysRoleDao.insert(sysRole);
        return sysRole;
    }
}
