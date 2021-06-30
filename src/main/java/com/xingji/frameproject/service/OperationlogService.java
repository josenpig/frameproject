package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.Operationlog;
import com.xingji.frameproject.vo.operationlogVo;

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
     * @return
     */
    List<operationlogVo> findAll();

    List<operationlogVo> findbyCreateTimeAndOperatorAndInput(String time, Integer operatorid, String input);

    List<operationlogVo> findbyCreateTimeAndOperator(String time, Integer operatorid);

    List<operationlogVo> findbyInputAndOperator(Integer operatorid, String input);

    List<operationlogVo> findbyCreateTimeAndInput(String time, String input);

    List<operationlogVo> findbyCreateTime(String time);

    List<operationlogVo> findbyOperator(Integer operatorid);

    List<operationlogVo> findbyInput(String input);
}
