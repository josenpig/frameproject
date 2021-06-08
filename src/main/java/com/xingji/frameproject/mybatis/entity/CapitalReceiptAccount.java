package com.xingji.frameproject.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (CapitalReceiptAccount)实体类
 *
 * @author makejava
 * @since 2021-06-02 20:17:30
 */
@Data
public class CapitalReceiptAccount implements Serializable {
    private static final long serialVersionUID = 380019506311101649L;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
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
