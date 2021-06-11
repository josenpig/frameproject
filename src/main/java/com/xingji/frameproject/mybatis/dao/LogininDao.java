package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.Loginin;
import com.xingji.frameproject.vo.LoginLogVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
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
}