package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.Message1;

import java.util.List;

public interface MessageService {
    void insert(Message1 m);

    List<Message1> selectByOrderid(String id);

    List<Message1> selecctByRecver(Integer recver);

    List<Message1> updateisreadByorderid(Integer queryUserIdByUserName, String orderid);

    List<Message1> updatenotreadByorderid(Integer queryUserIdByUserName, String orderid);

    void updateisreadAll(String orderid);

    List<String> selectstatusis1(Integer queryUserIdByUserName);

    List<Message1> selecctByRecverandstatusis1(Integer queryUserIdByUserName);

    List<Message1> selecctByRecverandstatusis0(Integer queryUserIdByUserName);
}
