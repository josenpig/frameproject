package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.Loginin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LogininDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Loginin record);

    int insertSelective(Loginin record);

    Loginin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Loginin record);

    int updateByPrimaryKey(Loginin record);


    List<Loginin>findAll(Loginin loginin);

    List<Loginin> findlogbyOperator(String operator);

    List<Loginin> findlogByLogintime(String time);

    List<Loginin> findlogByLogintimeAndOperator(@Param("time") String time, @Param("operator") String operator);

    List<Loginin> findlogByOperatorAndOperatorType(@Param("operator") String operator, @Param("operatorType") String operatorType);

    List<Loginin> findlogByOperatorType(String operatorType);

    List<Loginin> findlogByOperatorTypeAndLogintime(@Param("time") String time,@Param("operatorType") String operatorType);

    List<Loginin> findlogbyLogintimeAndOperatorAndOperatorType(@Param("logintime") String logintime,@Param("operator") String operator, @Param("typeofoperator") String operatorType);
}