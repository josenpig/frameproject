package com.xingji.frameproject.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (BaseProduct)实体类
 *
 * @author makejava
 * @since 2021-05-26 14:50:59
 */
@Data
public class BaseProduct implements Serializable {
    private static final long serialVersionUID = -97017808994842311L;
    /**
     * 产品编号
     */
    private String productId;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 成份
     */
    private String ingredient;
    /**
     * 规格
     */
    private String productSpec;
    /**
     * 单位id： 连接单位表
     */
    private Integer unitId;
    /**
     * 产品分类id： 连接分类表
     */
    private Integer productTypeId;
    /**
     * 销售单价
     */
    private Double purchaseUnitPrice;
    /**
     * 采购单价
     */
    private Double purchaseMoney;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 产品描述
     */
    private String productDescribe;
    /**
     * 图片id： 连接图片表
     */
    private Integer pictureId;
    /**
     * 状态:（已启用：1；已禁用：0）
     */
    private Integer state;
    /**
     * 创建人id: 连接用户表
     */
    private Integer userId;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creationTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 克重
     */
    private String gramHeavy;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getGramHeavy() {
        return gramHeavy;
    }

    public void setGramHeavy(String gramHeavy) {
        this.gramHeavy = gramHeavy;
    }

    public BaseProduct() {
    }
}
