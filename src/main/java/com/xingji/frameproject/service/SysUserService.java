package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.SysMenu;
import com.xingji.frameproject.mybatis.entity.SysRole;
import com.xingji.frameproject.mybatis.entity.SysUser;
import com.xingji.frameproject.mybatis.entity.SysUserRole;
import com.xingji.frameproject.vo.LoginLogVo;

import java.util.List;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2021-05-15 12:46:31
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    SysUser queryById(Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser insert(SysUser sysUser);

    boolean insertBatch(List<SysUserRole> SysUserRole);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

    boolean deleteroles(Integer userId);

    /**
     * 账户密码登录
     * @param userName 用户账户
     * @return 实列对象
     */
    SysUser login(String userName);
    /**
     * 手机号登录
     * @param userPhone 用户手机号
     * @return 实列对象
     */
    SysUser gologin(String userPhone);
    /**
     * 查询某用户所具有的菜单
     * @param userId 用户id
     * @return 实列对象
     */
    List<SysMenu> usermenu(Integer userId);
    /**
     * 通过角色id查询用户
     * @param id 角色id
     * @return 实列对象
     */
    List<SysUser> roleusers(Integer id);

    List<SysUser> queryAll(SysUser sysUser);

    /**
     * 通过UsernName查询user
     * @param userName
     * @return
     */
    Integer queryUserIdByUserName(String userName);



}
