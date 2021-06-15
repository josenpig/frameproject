package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.dao.LogininDao;
import com.xingji.frameproject.mybatis.entity.Loginin;
import com.xingji.frameproject.service.LogininService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public List<Loginin> findAll(Loginin loginin) {
        return this.logininDao.findAll(loginin);
    }

    @Override
    public List<Loginin> findlogByOperator(String operator) {
        return this.logininDao.findlogbyOperator(operator);
    }

    @Override
    public List<Loginin> findlogbyLogintime(String time) {
        return this.logininDao.findlogByLogintime(time);
    }

    @Override
    public List<Loginin> findlogbyLogintimeAndOperator(String time, String operator) {
        return this.logininDao.findlogByLogintimeAndOperator(time,operator);
    }

    @Override
    public List<Loginin> findlogByOperatorType(String operatorType) {
        return this.logininDao.findlogByOperatorType(operatorType);
    }

    @Override
    public List<Loginin> findlogByOperatorTypeAndLogintime(String time, String operatorType) {
        return this.logininDao.findlogByOperatorTypeAndLogintime(time,operatorType);
    }

    @Override
    public List<Loginin> findlogByOperatorAndOperatorType(String operator, String operatorType) {
        return this.logininDao.findlogByOperatorAndOperatorType(operator,operatorType);
    }

    @Override
    public List<Loginin> findlogbyLogintimeAndOperatorAndOperatorType(String logintime , String operator , String operatorType) {
        return this.logininDao.findlogbyLogintimeAndOperatorAndOperatorType(logintime,operator,operatorType);
    }
}
