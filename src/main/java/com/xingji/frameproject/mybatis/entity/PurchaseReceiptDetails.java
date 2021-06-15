package com.xingji.frameproject.mybatis.entity;

import java.io.Serializable;

/**
 * (PurchaseReceiptDetails)实体类
 *
 * @author makejava
 * @since 2021-06-15 18:48:49
 */
public class PurchaseReceiptDetails implements Serializable {
    private static final long serialVersionUID = 233951081908668783L;
    /**
     * 采购入库单id
     */
    private Integer id;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDepotName() {
        return depotName;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public Double getPlannedPrice() {
        return plannedPrice;
    }

    public void setPlannedPrice(Double plannedPrice) {
        this.plannedPrice = plannedPrice;
    }

    public Double getPurchaseUnitPrice() {
        return purchaseUnitPrice;
    }

    public void setPurchaseUnitPrice(Double purchaseUnitPrice) {
        this.purchaseUnitPrice = purchaseUnitPrice;
    }

    public Double getPurchaseMoney() {
        return purchaseMoney;
    }

    public void setPurchaseMoney(Double purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getGramHeavy() {
        return gramHeavy;
    }

    public void setGramHeavy(String gramHeavy) {
        this.gramHeavy = gramHeavy;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

}
