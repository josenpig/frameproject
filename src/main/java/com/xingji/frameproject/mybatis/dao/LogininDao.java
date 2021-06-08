package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.Loginin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogininDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Loginin record);

    int insertSelective(Loginin record);

    Loginin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Loginin record);

    int updateByPrimaryKey(Loginin record);
}