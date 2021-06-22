package com.xingji.frameproject.mybatis.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * (PurchaseReceiptDetails)实体类
 *
 * @author makejava
 * @since 2021-06-16 23:42:50
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PurchaseReceiptDetails implements Serializable {
    private static final long serialVersionUID = 888353737434030051L;
    /**
     * 采购入库单详情id
     */
    private Integer id;
    /**
     * 采购入库单id
     */
    private String receiptid;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品编号
     */
    private String productId;
    /**
     * 仓库名
     */
    private String depotName;
    /**
     * 产品数量
     */
    private Integer productNum;
    /**
     * 产品单位
     */
    private String productUnit;
    /**
     * 计划价
     */
    private Double plannedPrice;
    /**
     * 采购单价
     */
    private Double purchaseUnitPrice;
    /**
     * 采购金额
     */
    private Double purchaseMoney;
    /**
     * 成份
     */
    private String ingredient;
    /**
     * 克重
     */
    private String gramHeavy;
    /**
     * 产品描述
     */
    private String productDescribe;

    private int returnNum;


}