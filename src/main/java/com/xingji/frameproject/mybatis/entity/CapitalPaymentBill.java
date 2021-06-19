package com.xingji.frameproject.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (CapitalPaymentBill)实体类
 *
 * @author makejava
 * @since 2021-06-16 19:13:36
 */
@Data
public class CapitalPaymentBill implements Serializable {
    private static final long serialVersionUID = -68148161844444245L;
    /**
     * 列表id
     */
    private Integer id;
    /**
     * 付款单编号
     */
    private String paymentId;
    /**
     * 关联单据id
     */
    private String purchaseId;
    /**
     * 单据类型
     */
    private String purchaseType;
    /**
     * 单据日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchaseTime;
    /**
     * 应付款金额
     */
    private Double payableMoney;
    /**
     * 已付金额
     */
    private Double paidMoney;
    /**
     * 未付金额
     */
    private Double unpaidMoney;
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

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Double getPayableMoney() {
        return payableMoney;
    }

    public void setPayableMoney(Double payableMoney) {
        this.payableMoney = payableMoney;
    }

    public Double getPaidMoney() {
        return paidMoney;
    }

    public void setPaidMoney(Double paidMoney) {
        this.paidMoney = paidMoney;
    }

    public Double getUnpaidMoney() {
        return unpaidMoney;
    }

    public void setUnpaidMoney(Double unpaidMoney) {
        this.unpaidMoney = unpaidMoney;
    }

    public Double getThisMoney() {
        return thisMoney;
    }

    public void setThisMoney(Double thisMoney) {
        this.thisMoney = thisMoney;
    }

}
