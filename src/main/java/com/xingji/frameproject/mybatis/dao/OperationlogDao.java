package com.xingji.frameproject.mybatis.dao;


import com.xingji.frameproject.mybatis.entity.Operationlog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface OperationlogDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Operationlog record);

    int insertSelective(Operationlog record);

    Operationlog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Operationlog record);

    int updateByPrimaryKey(Operationlog record);
    List<Operationlog> findAll(Operationlog operationlog);

    List<Operationlog> findbyCreateTimeAndOperatorAndInput(@Param("time") String time, @Param("operator") String operator, @Param("input") String input);

    List<Operationlog> findbyCreateTimeAndOperator(@Param("time") String time,  @Param("operator")String operator);

    List<Operationlog> findbyInputAndOperator(@Param("operator") String operator, @Param("input") String input);

    List<Operationlog> findbyCreateTimeAndInput(@Param("time") String time,@Param("input") String input);

    List<Operationlog> findbyCreateTime(String time);

    List<Operationlog> findbyOperator(String operator);

    List<Operationlog> findbyInput(String input);
}