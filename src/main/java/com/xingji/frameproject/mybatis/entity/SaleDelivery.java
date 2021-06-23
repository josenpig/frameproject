package com.xingji.frameproject.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (SaleDelivery)实体类
 *
 * @author makejava
 * @since 2021-05-24 11:45:15
 */
@Data
public class SaleDelivery implements Serializable {
    private static final long serialVersionUID = 236295506361513007L;
    /**
     * 销售出库编号无法手动修改  XSCKD+时间戳
     */
    private String deliveryId;
    /**
     * 出库日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deliveryTime;
    /**
     * 客户
     */
    private String customer;
    /**
     * 默认当前登录的销售人
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
     * 审批人用户名
     */
    private String approver;
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
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 关联销售订单
     */
    private String orderId;
    /**
     * 关联退货单
     */
    private String returnId;
    /**
     * 关联收款单
     */
    private String receiptId;
    /**
     * 关联核销单
     */
    private String cavId;
    /**
     * 关联销售开票
     */
    private String billingId;
    /**
     * 最后审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastApprovalTime;
    /**
     * 审批状态 -2为草稿 -1为二级审批不通过 0为待二级审批  1为二级审批以通过
     */
    private Integer approvalState;
    /**
     * 出库状态 0为未出库   1为完全出库
     */
    private Integer deliveryState;
    /**
     * 订单状态 0为执行中   1为已结束
     */
    private Integer orderState;
    /**
     * 审批备注
     */
    private String approvalRemarks;
    /**
     * 关联收款单id
     */
    private List<CapitalReceiptBill> receipts;
    /**
     * 关联核销单id
     */
    private List<CapitalCavCiaBill> cavcias;
}
