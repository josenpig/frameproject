package com.xingji.frameproject.mybatis.entity;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * (PurchaseReceipt)实体类
 *
 * @author makejava
 * @since 2021-06-16 10:15:40
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PurchaseReceipt implements Serializable {
    private static final long serialVersionUID = -11234392647483049L;
    /**
     * 入库单编号
     */
    private String id;
    /**
     * 入库日期
     */
    private Date inboundDate;
    /**
     * 供应商用户名
     */
    private String vendorName;
    /**
     * 采购人用户名
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
     * 当前审批人用户名
     */
    private String vettingName;
    /**
     * 最后审批时间
     */
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
     * 创建人用户名
     */
    private String createPeople;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 更新人
     */
    private String updatePeople;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改时间
     */
    private Date updateDate;
    /**
     * 打印次数
     */
    private Integer counter;
}
