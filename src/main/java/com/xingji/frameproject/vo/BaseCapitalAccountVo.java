package com.xingji.frameproject.vo;

import lombok.ToString;

@ToString
public class BaseCapitalAccountVo {
    private static final long serialVersionUID = 340427089143827676L;
    /**
     * *资金账户编号
     */
    private String capitalId;
    /**
     * *资金账户名称
     */
    private String fundAccount;
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
    /**
     * *结算类型id
     */
    private Integer settlementTypeId;
    /**
     * *结算类型名称
     */
    private String settlementType;

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

    public Integer getSettlementTypeId() {
        return settlementTypeId;
    }

    public void setSettlementTypeId(Integer settlementTypeId) {
        this.settlementTypeId = settlementTypeId;
    }

    public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }
}
