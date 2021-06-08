package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.dao.LogininDao;
import com.xingji.frameproject.mybatis.entity.Loginin;
import com.xingji.frameproject.service.LogininService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service("LogininService")
public class LogininServiceImpl implements LogininService {
    @Resource
    LogininDao logininDao;
    @Override
    public int insertLoginin(Loginin loginin) {
        return this.logininDao.insert(loginin);
    }
}
