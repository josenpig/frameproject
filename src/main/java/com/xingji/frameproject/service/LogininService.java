package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.Loginin;

import java.util.List;

public interface LogininService {
    /**
     *插入一条登陆日志数据
     * @param loginin
     * @return
     */
    int insertLoginin(Loginin loginin);


    /**
     * 查询所有登录日志
     * @param loginin
     * @return
     */
    List<Loginin> findAll(Loginin loginin);

    List<Loginin> findlogByOperator(String operator);

    List<Loginin> findlogbyLogintime( String time);

    List<Loginin> findlogbyLogintimeAndOperator(String time, String operator);

    List<Loginin> findlogByOperatorType(String operatorType);

    List<Loginin> findlogByOperatorTypeAndLogintime(String time, String operatorType);

    List<Loginin> findlogByOperatorAndOperatorType(String operator, String operatorType);

    List<Loginin> findlogbyLogintimeAndOperatorAndOperatorType(String time , String operator, String operatorType);
}
