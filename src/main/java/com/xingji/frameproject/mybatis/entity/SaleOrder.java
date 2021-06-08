package com.xingji.frameproject.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * (SaleOrder)实体类
 *
 * @author makejava
 * @since 2021-05-21 09:20:42
 */
@Data
public class SaleOrder implements Serializable {
    private static final long serialVersionUID = 526267975642142258L;
    /**
     * 销售编号 无法手动修改  XSDD+时间戳
     */
    private String orderId;
    /**
     * 单据日期 默认为创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderTime;
    /**
     * 交货日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
     * 优惠率
     */
    private Double disrate;
    /**
     * 优惠金额
     */
    private Double dismoney;
    /**
     * 优惠后应收款
     */
    private Double receivables;
    /**
     * 客户联系人
     */
    private String contacts;
    /**
     * 联系人手机号
     */
    private String contactsPhone;
    /**
     * 联系人地址
     */
    private String contactsAddress;
    /**
     * 单据备注
     */
    private String remarks;
    /**
     * 当前审批人
     */
    private String approver;
    /**
     * 创建人 当前登录用户
     */
    private String founder;
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
     * 关联出库单id
     */
    private String deliveryId;
    /**
     * 关联退货单id
     */
    private String returnId;
    /**
     * 关联收款单id
     */
    private String receiptId;
    /**
     * 最后审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastApprovalTime;
    /**
     * 审批状态  -2为草稿 -1为一级审批不通过 0为待一级审批  1为一级审批以通过
     */
    private Integer approvalState;
    /**
     * 出库状态  0为未出库   1为已出库
     */
    private Integer deliveryState;
    /**
     * 订单状态  0为执行中   1为已结束
     */
    private Integer orderState;
    /**
     * 订单预收款
     */
    private Double advance;
    /**
     * 审批备注
     */
    private String approvalRemarks;
}
