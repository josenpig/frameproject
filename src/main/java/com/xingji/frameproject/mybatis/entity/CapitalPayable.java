package com.xingji.frameproject.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (CapitalPayable)实体类
 *
 * @author makejava
 * @since 2021-06-15 17:16:18
 */
public class CapitalPayable implements Serializable {
    private static final long serialVersionUID = -45273393782735898L;
    /**
     * 单据编号
     */
    private String deliveryId;
    /**
     * 单据日期
     */
    private Date deliveryTime;
    /**
     * 客户
     */
    private String customer;
    /**
     * 销售人员
     */
    private String salesmen;
    /**
     * 应收金额
     */
    private Double receivables;
    /**
     * 已收金额
     */
    private Double received;
    /**
     * 未收金额
     */
    private Double uncollected;
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
     * 最后收款备注
     */
    private String receiptRemark;
    /**
     * 最后收款时间
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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSalesmen() {
        return salesmen;
    }

    public void setSalesmen(String salesmen) {
        this.salesmen = salesmen;
    }

    public Double getReceivables() {
        return receivables;
    }

    public void setReceivables(Double receivables) {
        this.receivables = receivables;
    }

    public Double getReceived() {
        return received;
    }

    public void setReceived(Double received) {
        this.received = received;
    }

    public Double getUncollected() {
        return uncollected;
    }

    public void setUncollected(Double uncollected) {
        this.uncollected = uncollected;
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

    public String getReceiptRemark() {
        return receiptRemark;
    }

    public void setReceiptRemark(String receiptRemark) {
        this.receiptRemark = receiptRemark;
    }

    public Date getLastCollectionTime() {
        return lastCollectionTime;
    }

    public void setLastCollectionTime(Date lastCollectionTime) {
        this.lastCollectionTime = lastCollectionTime;
    }

}
