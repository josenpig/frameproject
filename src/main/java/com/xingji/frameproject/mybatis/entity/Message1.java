package com.xingji.frameproject.mybatis.entity;

import java.io.Serializable;
import java.time.LocalDateTime;;
import lombok.Data;
import lombok.ToString;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * message
 * @author
 */
@Data
@ToString
@SpringBootApplication
public class Message1 implements Serializable {
    /**
     * 消息id
     */
    private Integer mid;

    /**
     * 接收人
     */
    private Integer recver;

    /**
     * 已读状态（0：已读状态，1：未读状态，2：被删除）
     */
    private Integer status;

    /**
     * 发送人
     */
    private Integer sender;

    /**
     * 订单类型
     */
    private String ordertype;

    /**
     * 订单号
     */
    private String orderid;

    /**
     * 发送时间
     */

    private LocalDateTime sendtime;

    private static final long serialVersionUID = 1L;
}