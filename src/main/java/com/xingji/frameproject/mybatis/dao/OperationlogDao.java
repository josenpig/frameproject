package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.Operationlog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperationlogDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Operationlog record);

    int insertSelective(Operationlog record);

    Operationlog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Operationlog record);

    int updateByPrimaryKey(Operationlog record);
}