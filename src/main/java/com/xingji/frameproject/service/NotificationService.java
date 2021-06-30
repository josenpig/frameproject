package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.Notification;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface NotificationService {
    void insert(Notification notification);

    List<Notification> selectBystatus(int stuats);

    void updateStautsByMsgid(int i, String msgid);

    void update(int count, LocalDateTime updatetime, LocalDateTime trytime,String Msgid);

    List<Notification> selectAll();
}
