package com.xingji.frameproject.mybatis.dao;


import com.xingji.frameproject.mybatis.entity.Operationlog;
import com.xingji.frameproject.vo.operationlogVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OperationlogDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Operationlog record);

    int insertSelective(Operationlog record);

    int updateByPrimaryKeySelective(Operationlog record);

    int updateByPrimaryKey(Operationlog record);
    List<operationlogVo> findAll();

    List<operationlogVo> findbyCreateTimeAndOperatorAndInput(@Param("time") String time, @Param("operatorid") Integer operatorid, @Param("input") String input);

    List<operationlogVo> findbyCreateTimeAndOperator(@Param("time") String time,  @Param("operatorid")Integer operatorid);

    List<operationlogVo> findbyInputAndOperator(@Param("operatorid") Integer operatorid, @Param("input") String input);

    List<operationlogVo> findbyCreateTimeAndInput(@Param("time") String time,@Param("input") String input);

    List<operationlogVo> findbyCreateTime(String time);

    List<operationlogVo> findbyOperator(Integer operatorid);

    List<operationlogVo> findbyInput(String input);
}