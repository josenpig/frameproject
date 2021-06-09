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
}
