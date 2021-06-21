package com.xingji.frameproject.mybatis.entity;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * (PurchaseReturns)实体类
 *
 * @author makejava
 * @since 2021-06-18 00:46:45
 */
@Data
public class PurchaseReturns implements Serializable {
    private static final long serialVersionUID = 226738119366229764L;
    /**
     * 主键
     */
    private String id;
    /**
     * 退货日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date exitDate;
    /**
     * 供应商用户名id
     */
    private String vendorName;
    /**
     * 采购人用户名id
     */
    private String buyerName;
    /**
     * 仓库名
     */
    private String depotName;
    /**
     * 优惠后付款
     */
    private Double offersPrice;
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
     * 订单状态
     */
    private Integer state;
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
     * 关联的采购订单id
     */
    private String purchaseOrder;
    /**
     * 关联的入库单id
     */
    private String receiptOrder;
    /**
     * 关联付款单id
     */
    private String paymentOrder;
    /**
     * 关联的核销单id
     */
    private String cavOrder;
}
