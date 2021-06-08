package com.xingji.frameproject.vo;

import lombok.Data;

/***
 * @author: 顾渊白
 * @date: 2021/6/4 17:05
 * @version 1.0
 */
@Data
public class SaleConditionPageVo {
    //销售
    private String orderId;
    private String orderTime;
    private String otimeState;
    private String otimeEnd;
    private String deliveryTime;
    private String dtimeState;
    private String dtimeEnd;
    private String approvalState;
    private String customer;
    private String founder;
    private String salesmen;
}
