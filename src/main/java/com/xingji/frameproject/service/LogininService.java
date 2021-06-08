package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.Loginin;
import com.xingji.frameproject.vo.LoginLogVo;

import java.util.Date;
import java.util.List;

public interface LogininService {

    int insertLoginin(Loginin loginin);

    List<LoginLogVo> findloginlogbylogtime(Date logintime);

    List<Loginin> findAll(Loginin loginin);
}
