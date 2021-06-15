package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import java.util.List;

@Mapper
public interface SysUserRoleDao {
    int insert(SysUserRole record);
    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysUserRole> entities);
    int insertSelective(SysUserRole record);
<<<<<<< HEAD

    List<Integer> queryRoleIdByUserId(Integer userId);
=======
    /**
     * 通过角色id查询该角色下是否存在用户
     * @param roleId 角色id
     * @return SysUserRole
     */
    List<SysUserRole> findtfhasuser(Integer roleId);
    Integer queryRoleIdByUserId(Integer userId);
    /**
     * 通过用户id删除数据
     *
     * @param
     * @return 影响行数
     */
    int deleteById(Integer userId);
>>>>>>> ed5442202ac7008815ab9ba5cf69e8b886b29c21
}