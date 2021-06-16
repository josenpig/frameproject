package com.xingji.frameproject.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (CapitalPaymentAccount)实体类
 *
 * @author makejava
 * @since 2021-06-16 19:13:29
 */
@Data
public class CapitalPaymentAccount implements Serializable {
    private static final long serialVersionUID = -84617268856485361L;
    /**
     * 账户列表id
     */
    private Integer id;
    /**
     * 付款单编号
     */
    private String paymentId;
    /**
     * 资金账户
     */
    private String fundAccount;
    /**
     * 账户结算类型
     */
    private String settlementType;
    /**
     * 本次付款
     */
    private Double thisMoney;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }

    public Double getThisMoney() {
        return thisMoney;
    }

    public void setThisMoney(Double thisMoney) {
        this.thisMoney = thisMoney;
    }

}
