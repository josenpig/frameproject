package com.xingji.frameproject.mybatis.entity;

import java.io.Serializable;

/**
 * (BaseOpening)实体类
 *
 * @author makejava
 * @since 2021-05-28 16:38:54
 */
public class BaseOpening implements Serializable {
    private static final long serialVersionUID = 183977685821429763L;
    /**
     * 仓库名称
     */
    private String depotName;
    /**
     * 期初数量
     */
    private Integer openingNumber;
    /**
     * 当前库存
     */
    private Integer productNumber;
    /**
     * 预计可用量
     */
    private Integer expectNumber;
    /**
     * 产品编号
     */
    private String productId;


    public String getDepotName() {
        return depotName;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }

    public Integer getOpeningNumber() {
        return openingNumber;
    }

    public void setOpeningNumber(Integer openingNumber) {
        this.openingNumber = openingNumber;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public Integer getExpectNumber() {
        return expectNumber;
    }

    public void setExpectNumber(Integer expectNumber) {
        this.expectNumber = expectNumber;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

}
