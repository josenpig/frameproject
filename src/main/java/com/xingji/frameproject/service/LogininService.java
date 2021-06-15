package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.Loginin;
import com.xingji.frameproject.vo.LoginLogVo;

import java.util.Date;
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
}
