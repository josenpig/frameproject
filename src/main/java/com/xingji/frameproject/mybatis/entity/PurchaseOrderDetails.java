package com.xingji.frameproject.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (PurchaseOrderDetails)实体类
 *
 * @author makejava
 * @since 2021-06-02 09:52:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PurchaseOrderDetails implements Serializable {
    private static final long serialVersionUID = -83853095052249273L;
    /**
     * 采购订单详情id
     */
    private Integer id;
    /**
     * 采购订单id
     */
    private String purchaseOrderId;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品编号
     */
    private String productId;
    /**
     * 产品数量
     */
    private Integer productNum;
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
     * 备注
     */
    private String remark;
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