package com.xingji.frameproject.mybatis.entity;

import java.io.Serializable;

/**
 * (PurchaseReturnsDetails)实体类
 *
 * @author makejava
 * @since 2021-06-15 18:49:12
 */
public class PurchaseReturnsDetails implements Serializable {
    private static final long serialVersionUID = 353550573899682176L;
    /**
     * 采购退货单id
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

    public Integer getReturnNum() {
        return returnNum;
    }

    public void setReturnNum(Integer returnNum) {
        this.returnNum = returnNum;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
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

    public String getDepotName() {
        return depotName;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName;
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
