package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.dao.OperationlogDao;
import com.xingji.frameproject.mybatis.entity.Operationlog;
import com.xingji.frameproject.service.OperationlogService;
import com.xingji.frameproject.vo.operationlogVo;
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
    public List<operationlogVo> findAll() {
        return this.operationlogDao.findAll();
    }

    @Override
    public List<operationlogVo> findbyCreateTimeAndOperatorAndInput(String time, Integer operatorid, String input) {
        return this.operationlogDao.findbyCreateTimeAndOperatorAndInput(time,operatorid,input);
    }

    @Override
    public List<operationlogVo> findbyCreateTimeAndOperator(String time, Integer operatorid) {
        return this.operationlogDao.findbyCreateTimeAndOperator(time,operatorid);
    }

    @Override
    public List<operationlogVo> findbyInputAndOperator(Integer operatorid, String input) {
        return this.operationlogDao.findbyInputAndOperator(operatorid,input);
    }

    @Override
    public List<operationlogVo> findbyCreateTimeAndInput(String time, String input) {
        return this.operationlogDao.findbyCreateTimeAndInput(time,input);
    }

    @Override
    public List<operationlogVo> findbyCreateTime(String time) {
        return this.operationlogDao.findbyCreateTime(time);
    }

    @Override
    public List<operationlogVo> findbyOperator(Integer operatorid) {
        return this.operationlogDao.findbyOperator(operatorid);
    }

    @Override
    public List<operationlogVo> findbyInput(String input) {
        return this.operationlogDao.findbyInput(input);
    }
}
