package com.xingji.frameproject.mybatis.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (CapitalCavCiaBill)实体类
 *
 * @author makejava
 * @since 2021-06-08 18:46:17
 */
@Data
public class CapitalCavCiaBill implements Serializable {
    private static final long serialVersionUID = 436067112729108282L;

    private Integer id;
    /**
     * 核销单编号
     */
    private String cavId;
    /**
     * 单据编号
     */
    private String saleId;
    /**
     * 单据类型
     */
    private String saleType;
    /**
     * 单据日期
     */
    private Date saleTime;
    /**
     * 应收付款金额
     */
    private Double shouldMoney;
    /**
     * 已收付金额
     */
    private Double alreadyMoney;
    /**
     * 未收付金额
     */
    private Double notMoney;
    /**
     * 本次核销金额
     */
    private Double thisMoney;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCavId() {
        return cavId;
    }

    public void setCavId(String cavId) {
        this.cavId = cavId;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public Double getShouldMoney() {
        return shouldMoney;
    }

    public void setShouldMoney(Double shouldMoney) {
        this.shouldMoney = shouldMoney;
    }

    public Double getAlreadyMoney() {
        return alreadyMoney;
    }

    public void setAlreadyMoney(Double alreadyMoney) {
        this.alreadyMoney = alreadyMoney;
    }

    public Double getNotMoney() {
        return notMoney;
    }

    public void setNotMoney(Double notMoney) {
        this.notMoney = notMoney;
    }

    public Double getThisMoney() {
        return thisMoney;
    }

    public void setThisMoney(Double thisMoney) {
        this.thisMoney = thisMoney;
    }

}
