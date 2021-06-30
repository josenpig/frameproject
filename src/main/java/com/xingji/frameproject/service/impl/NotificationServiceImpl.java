package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.dao.NotificationDao;
import com.xingji.frameproject.mybatis.entity.Notification;
import com.xingji.frameproject.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service("NotificationService")
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationDao dao;
    @Override
    public void insert(Notification notification) {
        this.dao.insert(notification);
    }

    @Override
    public List<Notification> selectBystatus(int stuats) {
        return this.dao.selectBystaus(stuats);
    }

    @Override
    public void updateStautsByMsgid(int i, String msgid) {
        this.dao.updateStautsByMsgid(i,msgid);
    }

    @Override
    public void update(int count, LocalDateTime updatetime, LocalDateTime trytime,String Msgid) {
        this.dao.update(count,updatetime,trytime,Msgid);
    }

    @Override
    public List<Notification> selectAll() {
        return this.dao.selectAll();
    }
}
