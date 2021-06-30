package com.xingji.frameproject.util;

/**
 * 消息状态
 */
public class Constants {
    //投送中
    public  static final Integer DELIVERING=0;
    //投送成功
    public  static final Integer SUCCESS=1;
    //投送失败
    public  static final Integer FAILURE=2;
    //最大充实次数
    public  static final Integer MAX_TRY_COUNT=3;
    //消息超时时间
    public  static final Integer MSG_TIMEOUT=1;
    //队列
    public  static final String MAIL_QUEUE_NAME="mail.queue";
    //交换机
    public  static final String MAIL_EXCHANGE_NAME="mail.exchange";
    //路由键
    public  static final String MAIL_ROUTING_KEY_NAME="mail.routing.key";
}