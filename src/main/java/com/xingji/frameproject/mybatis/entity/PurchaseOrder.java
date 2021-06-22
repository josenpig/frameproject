package com.xingji.frameproject.mybatis.entity;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * (PurchaseOrder)实体类
 *
 * @author makejava
 * @since 2021-06-17 16:42:50
 */
@Data
public class PurchaseOrder implements Serializable {
    private static final long serialVersionUID = 421376632837238973L;
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
     * 供应商id
     */
    private String vendorName;
    /**
     * 单据日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date documentsDate;
    /**
     * 当前审批人用户名id
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
     * 关联的入库单id
     */
    private String receiptOrderId;
    /**
     * 关联的退货单id
     */
    private String exitOrderId;
    /**
     * 关联的付款单id
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
     * 采购人员姓名id
     */
    private String buyerName;
    /**
     * 创建人姓名id
     */
    private String createPeople;
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
