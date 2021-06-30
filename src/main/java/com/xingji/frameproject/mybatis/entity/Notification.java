package com.xingji.frameproject.mybatis.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * Notification
 * @author 
 */
@Data
public class Notification implements Serializable {
    /**
     * 消息id
     */
    private String msgid;

    /**
     * 接收员工id
     */
    private Integer eid;

    /**
     * 状态（0：消息投送，1：投送成功）
     */
    private Integer status;

    /**
     * 路由键
     */
    private String routekey;

    /**
     * 交换器
     */
    private String exchange;

    /**
     * 重试次数
     */
    private Integer count;

    /**
     * 重试时间
     */
    private LocalDateTime trytime;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 更新时间
     */
    private LocalDateTime updatetime;

    private static final long serialVersionUID = 1L;

}