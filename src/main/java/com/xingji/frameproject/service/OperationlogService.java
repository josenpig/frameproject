package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.Operationlog;


public interface OperationlogService {
    /**
     * 新增数据
     * @param operationlog
     * @return 实列对象
     */
    Operationlog InsertLog(Operationlog operationlog);
}
