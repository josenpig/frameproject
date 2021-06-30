package com.xingji.frameproject.config;

import com.xingji.frameproject.util.Constants;
import com.xingji.frameproject.mybatis.entity.Notification;
import com.xingji.frameproject.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * rabbitmq配置类
 */
@Slf4j
@Configuration
public class RabbitMQConfig {
//    @Autowired
//    private CachingConnectionFactory cachingConnectionFactory;
//    @Autowired
//    private NotificationService notificationService;
//    @Bean
//    public Queue queue(){
//        return new Queue(Constants.MAIL_QUEUE_NAME);
//    }
//
//    /**
//     * 路由模式，直连
//     * @return
//     */
//    @Bean
//    public DirectExchange directExchange(){
//        return new DirectExchange(Constants.MAIL_EXCHANGE_NAME);
//    }
//    @Bean
//    public Binding binding(){
//        return BindingBuilder.bind(queue()).to(directExchange()).with(Constants.MAIL_ROUTING_KEY_NAME);
//    }
//    @Bean
//    public RabbitTemplate rabbitTemplate(){
//       RabbitTemplate rabbitTemplate= new RabbitTemplate(cachingConnectionFactory);
//        /**
//         * 消息确认回调，确认消息是否到达borker
//         * data:消息唯一表示
//         * ack:确认结果
//         * cause: 失败原因
//         */
//
//       rabbitTemplate.setConfirmCallback((data,ack,cause)->{
//        String msgId= data.getId();
//        if(ack){
//            System.out.println("============>"+msgId);
//            Notification notification=new Notification();
//            notification.setMsgid(msgId);
//            notification.setStatus(1);
//            notificationService.updateStautsByMsgid(notification.getStatus(),notification.getMsgid());
//        }else{
//            log.error("{}==============>消息发送失败",msgId);
//        }
//           /**
//            * 消息回调失败,比如router不到queue时回调
//            * msg:消息主题
//            * repCode: 相应码
//            * repText:相应描述
//            * exchange:交换机
//            * routingkey:路由键
//            */
//           rabbitTemplate.setReturnCallback((msg,repCode,repText,exchange,routingkey)->{
//               log.error("{}==============>消息发送到queue时失败",msg.getBody());
//           });
//       });
//        return  rabbitTemplate;
//    }


}
