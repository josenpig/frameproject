package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.Message1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageDao {
    int deleteByPrimaryKey(Integer mid);

    int insert(Message1 record);

    int insertSelective(Message1 record);

    Message1 selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Message1 record);

    int updateByPrimaryKey(Message1 record);

    Message1 selectByOrderid(@Param("orderid") String id);

    List<Message1> selecctByRecver(@Param("recver") Integer recver);

    void updateisreadByorderid(@Param("recver") Integer queryUserIdByUserName, @Param("orderid")String orderid);

    void updatenotreadByorderid(@Param("recver") Integer queryUserIdByUserName, @Param("orderid")String orderid);

    void updatenotreadAll(@Param("orderid") String orderid);

    List<String> selectstatusis1(@Param("recver") Integer queryUserIdByUserName);

    List<Message1> selecctByRecverandstatusis1(@Param("recver") Integer queryUserIdByUserName);


    List<Message1> selecctByRecverandstatusis0(Integer queryUserIdByUserName);
}