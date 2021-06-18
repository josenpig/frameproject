package com.xingji.frameproject.mybatis.entity;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * (PurchaseReceipt)实体类
 *
 * @author makejava
 * @since 2021-06-17 19:02:48
 */
@Data
public class PurchaseReceipt implements Serializable {
    private static final long serialVersionUID = 681325297909336992L;
    /**
     * 入库单编号
     */
    private String id;
    /**
     * 入库日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inboundDate;
    /**
     * 供应商用户名id
     */
    private String vendorName;
    /**
     * 采购人用户名id
     */
    private String buyerName;
    /**
     * 订单状态
     */
    private Integer state;
    /**
     * 采购类型
     */
    private String buyerType;
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
     * 仓库名
     */
    private String depotName;
    /**
     * 当前审批人用户名id
     */
    private String vettingName;
    /**
     * 最后审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastVettingTime;
    /**
     * 审批状态
     */
    private Integer vettingState;
    /**
     * 关联的采购订单id
     */
    private String associatedOrder;
    /**
     * 关联的退货单id
     */
    private String exitOrderId;
    /**
     * 关联的付款单id
     */
    private String paymentOrder;
    /**
     * 关联的核销单id
     */
    private String cavId;
    /**
     * 关联的采购收票id
     */
    private String invoiceId;
    /**
     * 创建人用户名id
     */
    private String createPeople;
    /**
     * 更新人id
     */
    private String updatePeople;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateDate;
    /**
     * 打印次数
     */
    private Integer counter;
}
