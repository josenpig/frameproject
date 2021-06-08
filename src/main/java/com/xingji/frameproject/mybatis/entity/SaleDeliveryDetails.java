package com.xingji.frameproject.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (SaleDeliveryDetails)实体类
 *
 * @author makejava
 * @since 2021-05-24 11:48:16
 */
@Data
public class SaleDeliveryDetails implements Serializable {
    private static final long serialVersionUID = -96391462867874774L;
    /**
     * 销售出库单详情编号
     */
    private Integer id;
    /**
     * 销售出库单编号
     */
    private String deliveryId;
    /**
     * 产品编号
     */
    private String productId;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品数量
     */
    private Integer productNum;
    /**
     * 产品单位
     */
    private String productUnit;
    /**
     * 产品克重
     */
    private String gramHeavy;
    /**
     * 产品成份
     */
    private String ingredient;
    /**
     * 产品规格
     */
    private String productSpec;
    /**
     * 产品描述
     */
    private String productDescribe;
    /**
     * 产品备注
     */
    private String remark;
    /**
     * 所属仓库
     */
    private String depot;
    /**
     * 销售单价（元）
     */
    private Double saleUnitPrice;
    /**
     * 销售金额（元）
     */
    private Double saleMoney;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getGramHeavy() {
        return gramHeavy;
    }

    public void setGramHeavy(String gramHeavy) {
        this.gramHeavy = gramHeavy;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDepot() {
        return depot;
    }

    public void setDepot(String depot) {
        this.depot = depot;
    }

    public Double getSaleUnitPrice() {
        return saleUnitPrice;
    }

    public void setSaleUnitPrice(Double saleUnitPrice) {
        this.saleUnitPrice = saleUnitPrice;
    }

    public Double getSaleMoney() {
        return saleMoney;
    }

    public void setSaleMoney(Double saleMoney) {
        this.saleMoney = saleMoney;
    }


}
