package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.SysMenu;
import com.xingji.frameproject.mybatis.entity.SysUser;
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
    /**
     * 通过用户名查询
     *
     * @param userName 用户账户
     * @return 实列对象
     */
    SysUser login(String userName);
    /**
     * 通过用户名查询
     *
     * @param userPhone 用户手机号
     * @return 实列对象
     */
    SysUser gologin(String userPhone);
    List<SysMenu> usermenu(Integer userId);

    List<SysUser> roleusers(Integer id);

    List<SysUser> queryAll(SysUser sysUser);

    Integer queryUserIdByUserName(String userName);

    List<SysUser> findsysName();
}
