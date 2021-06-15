package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.Operationlog;

import java.util.List;


public interface OperationlogService {
    /**
     * 新增数据
     * @param operationlog
     * @return 实列对象
     */
    Operationlog InsertLog(Operationlog operationlog);

    /**
     * 查询所有操作日志
     * @param operationlog
     * @return
     */
    List<Operationlog> findAll(Operationlog operationlog);

    List<Operationlog> findbyCreateTimeAndOperatorAndInput(String time, String operator, String input);

    List<Operationlog> findbyCreateTimeAndOperator(String time, String operator);

    List<Operationlog> findbyInputAndOperator(String operator, String input);

    List<Operationlog> findbyCreateTimeAndInput(String time, String input);

    List<Operationlog> findbyCreateTime(String time);

    List<Operationlog> findbyOperator(String operator);

    List<Operationlog> findbyInput(String input);
}
