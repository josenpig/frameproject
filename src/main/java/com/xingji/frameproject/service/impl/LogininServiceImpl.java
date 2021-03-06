package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.dao.LogininDao;
import com.xingji.frameproject.mybatis.entity.Loginin;
import com.xingji.frameproject.service.LogininService;
import com.xingji.frameproject.vo.LoginLogVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("LogininService")
public class LogininServiceImpl implements LogininService {
    @Resource
    LogininDao logininDao;
    @Override
    public int insertLoginin(Loginin loginin) {
        return this.logininDao.insert(loginin);
    }

    @Override
    public List<LoginLogVo> findloginlogbylogtime(Date logintime) {
        return this.logininDao.findloginlogbylogtime(logintime);
    }

    @Override
    public List<Loginin> findAll(Loginin loginin) {
        return this.logininDao.findAll(loginin);
    }
}
