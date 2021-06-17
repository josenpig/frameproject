package com.xingji.frameproject.mybatis.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (CapitalPayment)实体类
 *
 * @author makejava
 * @since 2021-06-16 19:19:31
 */
@Data
public class CapitalPayment implements Serializable {
    private static final long serialVersionUID = -98318408878716065L;
    /**
     * 付款单编号
     */
    private String paymentId;
    /**
     * 付款日期
     */
    private Date paymentTime;
    /**
     * 供应商名称
     */
    private String vendor;
    /**
     * 付款人
     */
    private String drawee;
    /**
     * 付款类别
     */
    private String paymentType;
    /**
     * 付款金额
     */
    private Double paymentMoney;
    /**
     * 预付金额
     */
    private Double piaMoney;
    /**
     * 预付余额
     */
    private Double piaBalance;
    /**
     * 关联核销单
     */
    private String cavId;
    /**
     * 创建人
     */
    private String founder;
    /**
     * 单据备注
     */
    private String remarks;
    /**
     * 审批状态
     */
    private Integer approvalState;
    /**
     * 当前审批人
     */
    private String approver;
    /**
     * 最后审批时间
     */
    private Date lastApprovalTime;
    /**
     * 创建时间
     */
    private Date foundTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 审批备注
     */
    private String approvalRemarks;


    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDrawee() {
        return drawee;
    }

    public void setDrawee(String drawee) {
        this.drawee = drawee;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Double getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(Double paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    public Double getPiaMoney() {
        return piaMoney;
    }

    public void setPiaMoney(Double piaMoney) {
        this.piaMoney = piaMoney;
    }

    public Double getPiaBalance() {
        return piaBalance;
    }

    public void setPiaBalance(Double piaBalance) {
        this.piaBalance = piaBalance;
    }

    public String getCavId() {
        return cavId;
    }

    public void setCavId(String cavId) {
        this.cavId = cavId;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getApprovalState() {
        return approvalState;
    }

    public void setApprovalState(Integer approvalState) {
        this.approvalState = approvalState;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public Date getLastApprovalTime() {
        return lastApprovalTime;
    }

    public void setLastApprovalTime(Date lastApprovalTime) {
        this.lastApprovalTime = lastApprovalTime;
    }

    public Date getFoundTime() {
        return foundTime;
    }

    public void setFoundTime(Date foundTime) {
        this.foundTime = foundTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getApprovalRemarks() {
        return approvalRemarks;
    }

    public void setApprovalRemarks(String approvalRemarks) {
        this.approvalRemarks = approvalRemarks;
    }

}
