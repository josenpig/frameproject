package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.dao.MessageDao;
import com.xingji.frameproject.mybatis.entity.Message1;
import com.xingji.frameproject.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("MessageService")
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageDao messageDao;
    @Override
    public void insert(Message1 m) {
        this.messageDao.insert(m);
    }

    @Override
    public List<Message1> selectByOrderid(String id) {
        return this.messageDao.selectByOrderid(id);
    }

    @Override
    public List<Message1> selecctByRecver(Integer recver) {
        return this.messageDao.selecctByRecver(recver);
    }

    @Override
    public List<Message1> updateisreadByorderid(Integer queryUserIdByUserName, String orderid) {
        this.messageDao.updateisreadByorderid(queryUserIdByUserName,orderid);
        return this.messageDao.selecctByRecver(queryUserIdByUserName);
    }

    @Override
    public List<Message1> updatenotreadByorderid(Integer queryUserIdByUserName, String orderid) {
        this.messageDao.updatenotreadByorderid(queryUserIdByUserName,orderid);
        return this.messageDao.selecctByRecver(queryUserIdByUserName);
    }

    @Override
    public void updateisreadAll(String orderid) {
       this.messageDao.updatenotreadAll(orderid);
    }

    @Override
    public List<String> selectstatusis1(Integer queryUserIdByUserName) {
        return this.messageDao.selectstatusis1(queryUserIdByUserName);
    }

    @Override
    public List<Message1> selecctByRecverandstatusis1(Integer queryUserIdByUserName) {
        return this.messageDao.selecctByRecverandstatusis1(queryUserIdByUserName);
    }

    @Override
    public List<Message1> selecctByRecverandstatusis0(Integer queryUserIdByUserName) {
        return this.messageDao.selecctByRecverandstatusis0(queryUserIdByUserName);
    }

    @Override
    public void setmessage(Integer sender, Integer recver, String orderid, Integer mid) {
        this.messageDao.setmessage(sender,recver,orderid,mid);
    }
}
