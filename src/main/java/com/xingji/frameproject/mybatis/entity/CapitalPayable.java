package com.xingji.frameproject.mybatis.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (CapitalPayable)实体类
 *
 * @author makejava
 * @since 2021-06-17 15:23:31
 */
public class CapitalPayable implements Serializable {
    private static final long serialVersionUID = -20948961804988009L;
    /**
     * 单据编号
     */
    private String deliveryId;
    /**
     * 单据日期
     */
    private Date deliveryTime;
    /**
     * 供应商
     */
    private String vendor;
    /**
     * 采购人员
     */
    private String buyer;
    /**
     * 应付金额
     */
    private Double payables;
    /**
     * 已付金额
     */
    private Double paid;
    /**
     * 未付金额
     */
    private Double unpaid;
    /**
     * 单据备注
     */
    private String remarks;
    /**
     * 创建人
     */
    private String founder;
    /**
     * 结案状态
     */
    private Integer caseState;
    /**
     * 最后付款备注
     */
    private String paymentRemark;
    /**
     * 最后付款时间
     */
    private Date lastCollectionTime;


    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Double getPayables() {
        return payables;
    }

    public void setPayables(Double payables) {
        this.payables = payables;
    }

    public Double getPaid() {
        return paid;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
    }

    public Double getUnpaid() {
        return unpaid;
    }

    public void setUnpaid(Double unpaid) {
        this.unpaid = unpaid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Integer getCaseState() {
        return caseState;
    }

    public void setCaseState(Integer caseState) {
        this.caseState = caseState;
    }

    public String getPaymentRemark() {
        return paymentRemark;
    }

    public void setPaymentRemark(String paymentRemark) {
        this.paymentRemark = paymentRemark;
    }

    public Date getLastCollectionTime() {
        return lastCollectionTime;
    }

    public void setLastCollectionTime(Date lastCollectionTime) {
        this.lastCollectionTime = lastCollectionTime;
    }

}
