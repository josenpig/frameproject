package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.dao.SysMenuDao;
import com.xingji.frameproject.mybatis.dao.SysUserDao;
import com.xingji.frameproject.mybatis.entity.SysMenu;
import com.xingji.frameproject.mybatis.entity.SysUser;
import com.xingji.frameproject.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2021-05-15 12:46:32
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private SysMenuDao sysMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Integer userId) {
        return this.sysUserDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUser> queryAllByLimit(int offset, int limit) {
        return this.sysUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser insert(SysUser sysUser) {
        this.sysUserDao.insert(sysUser);
        return sysUser;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser update(SysUser sysUser) {
        this.sysUserDao.update(sysUser);
        return this.queryById(sysUser.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.sysUserDao.deleteById(userId) > 0;
    }
    /**
     * 账户密码登录
     * @param userName 用户账户
     * @return 实列对象
     */
    @Override
    public SysUser login(String userName) {
        return this.sysUserDao.login(userName);
    }
    /**
     * 手机号登录
     * @param userPhone 用户手机号
     * @return 实列对象
     */
    @Override
    public SysUser gologin(String userPhone) {
        return this.sysUserDao.gologin(userPhone);
    }
    /**
     * 查询某用户所具有的菜单
     * @param userId 用户id
     * @return 实列对象
     */
    @Override
    public List<SysMenu> usermenu(Integer userId) {
        return this.sysMenuDao.usermenu(userId);
    }
    /**
     * 通过角色id查询用户
     * @param id 角色id
     * @return 实列对象
     */
    @Override
    public List<SysUser> roleusers(Integer id){
        return this.sysUserDao.roleusers(id);
    }
    @Override
    public List<SysUser> queryAll(SysUser sysUser){
        return this.sysUserDao.queryAll(sysUser);
    }
    @Override
    public Integer queryUserIdByUserName(String userName) {
        return this.sysUserDao.queryUserIdByUserName(userName);
    }

    @Override
    public List<String> findsysName() {
        return this.sysUserDao.findsysName();
    }
}
