package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-15 12:43:03
 */
@Mapper
public interface SysUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    SysUser queryById(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUser 实例对象
     * @return 对象列表
     */
    List<SysUser> queryAll(SysUser sysUser);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int insert(SysUser sysUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUser> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysUser> entities);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Integer userId);
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
    /**
     * 通过角色id查询用户
     * @param id 角色id
     * @return 实列对象
     */
    List<SysUser> roleusers(Integer id);

    /**
     * 通过UsernName查询user
     * @param userName
     * @return
     */
    Integer queryUserIdByUserName(String userName);

    Integer queryUserIdByPhone(String phone);

    String queryUserNameByUserId(Integer userid);

    SysUser updateUserName(@Param("userid") Integer userid, @Param("username") String username);

}

