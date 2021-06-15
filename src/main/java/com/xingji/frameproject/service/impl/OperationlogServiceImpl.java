package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.dao.OperationlogDao;
import com.xingji.frameproject.mybatis.entity.Operationlog;
import com.xingji.frameproject.service.OperationlogService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("OperationlogService")
public class OperationlogServiceImpl implements OperationlogService {
    @Resource
    private OperationlogDao operationlogDao;
    /**
     * 新增数据
     * @param operationlog
     * @return 实列对象
     */
    @Override
    public Operationlog InsertLog(Operationlog operationlog) {
        this.operationlogDao.insert(operationlog);
        return  operationlog;
    }

    @Override
    public List<Operationlog> findAll(Operationlog operationlog) {
        return this.operationlogDao.findAll(operationlog);
    }

    @Override
    public List<Operationlog> findbyCreateTimeAndOperatorAndInput(String time, String operator, String input) {
        return this.operationlogDao.findbyCreateTimeAndOperatorAndInput(time,operator,input);
    }

    @Override
    public List<Operationlog> findbyCreateTimeAndOperator(String time, String operator) {
        return this.operationlogDao.findbyCreateTimeAndOperator(time,operator);
    }

    @Override
    public List<Operationlog> findbyInputAndOperator(String operator, String input) {
        return this.operationlogDao.findbyInputAndOperator(operator,input);
    }

    @Override
    public List<Operationlog> findbyCreateTimeAndInput(String time, String input) {
        return this.operationlogDao.findbyCreateTimeAndInput(time,input);
    }

    @Override
    public List<Operationlog> findbyCreateTime(String time) {
        return this.operationlogDao.findbyCreateTime(time);
    }

    @Override
    public List<Operationlog> findbyOperator(String operator) {
        return this.operationlogDao.findbyOperator(operator);
    }

    @Override
    public List<Operationlog> findbyInput(String input) {
        return this.operationlogDao.findbyInput(input);
    }
}
