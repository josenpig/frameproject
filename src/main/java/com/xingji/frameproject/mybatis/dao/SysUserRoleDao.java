package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserRoleDao {
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    List<Integer> queryRoleIdByUserId(Integer userId);
}