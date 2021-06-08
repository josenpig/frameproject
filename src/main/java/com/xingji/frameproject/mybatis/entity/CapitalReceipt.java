package com.xingji.frameproject.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (CapitalReceipt)实体类
 *
 * @author makejava
 * @since 2021-06-03 15:22:36
 */
@Data
public class CapitalReceipt implements Serializable {
    private static final long serialVersionUID = -13039665529423111L;
    /**
     * 收款单编号
     */
    private String receiptId;
    /**
     * 收款日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date receiptTime;
    /**
     * 客户名称
     */
    private String customer;
    /**
     * 收款人
     */
    private String payee;
    /**
     * 收款类别
     */
    private String incomeType;
    /**
     * 收款金额
     */
    private Double receiptMoney;
    /**
     * 预收金额
     */
    private Double ciaMoney;
    /**
     * 预收余额
     */
    private Double ciaBalance;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastApprovalTime;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date foundTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 审批备注
     */
    private String approvalRemarks;
}
