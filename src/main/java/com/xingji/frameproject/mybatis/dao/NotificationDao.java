package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.Notification;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface NotificationDao {
    int insert(Notification record);

    int insertSelective(Notification record);

    List<Notification> selectBystaus(int stuats);

    void updateStautsByMsgid(int i, String msgid);

    void update(int count, LocalDateTime updatetime, LocalDateTime trytime,String Msgid);

    List<Notification> selectAll();
}