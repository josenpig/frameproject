package com.xingji.frameproject.task;

import com.xingji.frameproject.util.Constants;
import com.xingji.frameproject.mybatis.entity.Notification;
import com.xingji.frameproject.service.NotificationService;
//import org.springframework.amqp.rabbit.connection.CorrelationData;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

//@Component
public class MessageTask {
//    @Autowired
//    private NotificationService notificationService;
//    @Autowired
//    private RabbitTemplate  rabbitTemplate;
//    /**
//     * 信息发送任务
//     * 十秒发送一次
//     */
//    @Scheduled(cron = "0/10 * * * * ?")
//    public void MessageTask() {
//        if (notificationService.selectAll()!=null) {
//            List<Notification> list = notificationService.selectBystatus(0);
//            list.forEach(notification -> {
//                if (3 <= notification.getCount()) {
//                    notificationService.updateStautsByMsgid(2, notification.getMsgid());
//                }
//                //发送消息
//                notificationService.update(notification.getCount() + 1, LocalDateTime.now(), LocalDateTime.now().plusMinutes(Constants.MSG_TIMEOUT), notification.getMsgid());
//                rabbitTemplate.convertAndSend(Constants.MAIL_EXCHANGE_NAME, Constants.MAIL_ROUTING_KEY_NAME, notification, new CorrelationData(notification.getMsgid()));
//
//            });
//        }
//    }
}
