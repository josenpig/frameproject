package com.xingji.frameproject.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (BaseCapitalAccount)实体类
 *
 * @author makejava
 * @since 2021-06-02 08:54:58
 */
@Data
public class BaseCapitalAccount implements Serializable {
    private static final long serialVersionUID = 560019887627276586L;
    /**
     * *资金账户编号
     */
    private String capitalId;
    /**
     * *资金账户名称
     */
    private String fundAccount;
    /**
     * *结算类型名称
     */
    private String settlementType;
    /**
     * *初期金额
     */
    private Double initialAmount;
    /**
     * 当前金额
     */
    private Double currentAmount;
    /**
     * 是否为默认账户: （是：1；否：0）
     */
    private Integer state;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCapitalId() {
        return capitalId;
    }

    public void setCapitalId(String capitalId) {
        this.capitalId = capitalId;
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

    public void setSettlementType(String settlementTypeName) {
        this.settlementType = settlementTypeName;
    }

    public Double getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(Double initialAmount) {
        this.initialAmount = initialAmount;
    }

    public Double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
