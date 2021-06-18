package com.xingji.frameproject.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (PurchaseReturnsDetails)实体类
 *
 * @author makejava
 * @since 2021-06-15 18:49:12
 */
@Data
public class PurchaseReturnsDetails implements Serializable {
    private static final long serialVersionUID = 353550573899682176L;
    /**
     * 采购退货单详情id
     */
    private Integer id;
    /**
     * 采购退货单id
     */
    private String returnId;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品编号
     */
    private String productId;
    /**
     * 退货数量
     */
    private Integer returnNum;
    /**
     * 产品单位
     */
    private String productUnit;
    /**
     * 采购单价
     */
    private Double purchaseUnitPrice;
    /**
     * 采购金额
     */
    private Double purchaseMoney;
    /**
     * 仓库名
     */
    private String depotName;
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


}
