package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserRoleDao {
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    Integer queryRoleIdByUserId(Integer userId);
}