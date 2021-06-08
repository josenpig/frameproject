package com.xingji.frameproject.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (PurchaseOrder)实体类
 *
 * @author makejava
 * @since 2021-06-02 15:24:42
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PurchaseOrder implements Serializable {
    private static final long serialVersionUID = 780299898411581616L;
    /**
     * 采购订单编号
     */
    private String id;
    /**
     * 交货日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deliceryDate;
    /**
     * 供应商用户名
     */
    private String vendorName;
    /**
     * 单据日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date documentsDate;
    /**
     * 当前审批人用户名
     */
    private String vettingName;
    /**
     * 优惠率
     */
    private Double disrate;
    /**
     * 优惠金额
     */
    private Double dismoney;
    /**
     * 优惠后付款
     */
    private Double offersPrice;
    /**
     * 订单状态
     */
    private Integer orderState;
    /**
     * 仓库名
     */
    private String depotName;
    /**
     * 关联的入库单
     */
    private String receiptOrderId;
    /**
     * 关联的退货单
     */
    private String exitOrderId;
    /**
     * 关联的付款单
     */
    private String paymentOrder;
    /**
     * 审批状态
     */
    private Integer vettingState;
    /**
     * 最后审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastVettingDate;
    /**
     * 入库状态
     */
    private Integer inboundState;
    /**
     * 采购人员姓名
     */
    private String buyerName;
    /**
     * 创建人姓名
     */
    private String createPeople;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateDate;
    /**
     * 打印次数
     */
    private Integer counter;
    /**
     * 订单已付款
     */
    private Double ostate;
}