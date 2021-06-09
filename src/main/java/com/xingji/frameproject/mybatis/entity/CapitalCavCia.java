package com.xingji.frameproject.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (CapitalCavCia)实体类
 *
 * @author makejava
 * @since 2021-06-09 15:17:22
 */
@Data
public class CapitalCavCia implements Serializable {
    private static final long serialVersionUID = 916105656043423061L;
    /**
     * 核销单编号无法手动修改  HXD+时间戳
     */
    private String cavId;
    /**
     * 单据日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderTime;
    /**
     * 客户或供应商名称
     */
    private String otherParty;
    /**
     * 核销人
     */
    private String cavBy;
    /**
     * 核销方式
     */
    private String cavType;
    /**
     * 本次核销金额
     */
    private Double thisMoney;
    /**
     * 创建人
     */
    private String founder;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date foundTime;
    /**
     * 单据备注
     */
    private String remarks;
    /**
     * 当前审批人
     */
    private String approver;
    /**
     * 审批状态
     */
    private Integer approvalState;
    /**
     * 审批备注
     */
    private String approvalRemarks;
    /**
     * 最后审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastApprovalTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


    public String getCavId() {
        return cavId;
    }

    public void setCavId(String cavId) {
        this.cavId = cavId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOtherParty() {
        return otherParty;
    }

    public void setOtherParty(String otherParty) {
        this.otherParty = otherParty;
    }

    public String getCavBy() {
        return cavBy;
    }

    public void setCavBy(String cavBy) {
        this.cavBy = cavBy;
    }

    public String getCavType() {
        return cavType;
    }

    public void setCavType(String cavType) {
        this.cavType = cavType;
    }

    public Double getThisMoney() {
        return thisMoney;
    }

    public void setThisMoney(Double thisMoney) {
        this.thisMoney = thisMoney;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Date getFoundTime() {
        return foundTime;
    }

    public void setFoundTime(Date foundTime) {
        this.foundTime = foundTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public Integer getApprovalState() {
        return approvalState;
    }

    public void setApprovalState(Integer approvalState) {
        this.approvalState = approvalState;
    }

    public String getApprovalRemarks() {
        return approvalRemarks;
    }

    public void setApprovalRemarks(String approvalRemarks) {
        this.approvalRemarks = approvalRemarks;
    }

    public Date getLastApprovalTime() {
        return lastApprovalTime;
    }

    public void setLastApprovalTime(Date lastApprovalTime) {
        this.lastApprovalTime = lastApprovalTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
