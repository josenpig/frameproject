package com.xingji.frameproject.mybatis.entity;

import java.io.Serializable;

/**
 * (BaseExpenditureType)实体类
 *
 * @author makejava
 * @since 2021-06-07 16:26:49
 */
public class BaseExpenditureType implements Serializable {
    private static final long serialVersionUID = -89311962241720020L;
    /**
     * *支出类型id
     */
    private Integer paymentTypeId;
    /**
     * *支出类型名称
     */
    private String paymentType;


    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

}
