package com.xingji.frameproject.util;

import com.xingji.frameproject.mybatis.entity.Message1;
import com.xingji.frameproject.mybatis.entity.Notification;
import com.xingji.frameproject.service.MessageService;
import com.xingji.frameproject.service.NotificationService;
//import org.springframework.amqp.rabbit.connection.CorrelationData;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;
@Component
public class MessageUtil {
    @Autowired
    private NotificationService notificationService;
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MessageService messageService;
    public void addMessage(Integer sender,String orderid){
        //消息落库
        String msgId= UUID.randomUUID().toString();
        Notification notification=new Notification();
        notification.setMsgid(msgId);
        notification.setEid(1);
        notification.setStatus(0);
        notification.setRoutekey(Constants.MAIL_ROUTING_KEY_NAME);
        notification.setExchange(Constants.MAIL_EXCHANGE_NAME);
        notification.setCount(0);
        notification.setTrytime(LocalDateTime.now().plusMinutes(Constants.MSG_TIMEOUT));
        notification.setCreatetime(LocalDateTime.now());
        notification.setUpdatetime(LocalDateTime.now());
        notificationService.insert(notification);
        //
        Message1 m=new Message1();
        m.setSender(sender);
        m.setRecver(1);
        m.setStatus(0);
        m.setOrderid(orderid);
        StringBuffer sb=new StringBuffer();

        for(int i=0;i<orderid.length();i++){
            char a= orderid.charAt(i);
            if((a<='z'&&a>='a')||(a<='Z'&&a>='A')){
                sb.append(a);
            }
        }
        if (sb.toString().equals("CGDD")){
            m.setOrdertype("采购订单");
        }
        else if (sb.toString().equals("CGRKD")){
            m.setOrdertype("采购入库单");
        }else if (sb.toString().equals("CGTHD")){
            m.setOrdertype("采购退货单");
        }else if (sb.toString().equals("XSDD")){
            m.setOrdertype("销售订单");
        }else if (sb.toString().equals("XSCKD")){
            m.setOrdertype("销售出库单");
        }else if (sb.toString().equals("XSTHD")){
            m.setOrdertype("销售退货单");
        }

        m.setSendtime(LocalDateTime.now());
        messageService.insert(m);
        Message1 message1=messageService.selectByOrderid(orderid);
        //发送信息
//        rabbitTemplate.convertAndSend(Constants.MAIL_EXCHANGE_NAME,Constants.MAIL_ROUTING_KEY_NAME,message1,new CorrelationData(msgId));
//        System.out.println("消息发送成功----------------------");
    }
}
