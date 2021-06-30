package com.xingji.frameproject.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class messageVo {
        /**
         * 消息id
         */
        private Integer mid;

        /**
         * 接收人
         */
        private String recver;

        /**
         * 已读状态（0：已读状态，1：未读状态，2：被删除）
         */
        private String status;

        /**
         * 发送人
         */
        private String sender;

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
