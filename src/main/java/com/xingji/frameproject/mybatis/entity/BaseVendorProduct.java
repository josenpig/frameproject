package com.xingji.frameproject.mybatis.entity;

import lombok.ToString;

import java.io.Serializable;

/**
 * (BaseVendorProduct)实体类
 *
 * @author makejava
 * @since 2021-06-25 15:14:22
 */
@ToString
public class BaseVendorProduct implements Serializable {
    private static final long serialVersionUID = 678535846531890223L;
    /**
     * 供应商id
     */
    private String vendorId;
    /**
     * 产品id
     */
    private String productId;
    /**
     * 调剂比例
     */
    private Double priceRatio;
    /**
     * 该产品在该供应商的采购价格
     */
    private Double money;


    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getPriceRatio() {
        return priceRatio;
    }

    public void setPriceRatio(Double priceRatio) {
        this.priceRatio = priceRatio;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

}
