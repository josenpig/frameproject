package com.xingji.frameproject.vo;

import lombok.Data;

/***
 * @author: 顾渊白
 * @date: 2021/6/10 14:43
 * @version 1.0
 */
@Data
public class CapitalAccountVo {
    /**
     * 账户列表id
     */
    private Integer id;
    /**
     * 收款单编号
     */
    private String receiptId;
    /**
     * 资金账户名称
     */
    private String fundAccount;
    /**
     * 账户结算类型
     */
    private String settlementType;
    /**
     * 本次收款
     */
    private Double thisMoney;
}
