package com.xingji.frameproject.mybatis.entity;

import java.io.Serializable;

/**
 * (BaseIncomeType)实体类
 *
 * @author makejava
 * @since 2021-06-07 16:27:01
 */
public class BaseIncomeType implements Serializable {
    private static final long serialVersionUID = -91465684569388932L;
    /**
     * *收入类型id
     */
    private Integer incomeTypeId;
    /**
     * *收入类型名称
     */
    private String incomeType;


    public Integer getIncomeTypeId() {
        return incomeTypeId;
    }

    public void setIncomeTypeId(Integer incomeTypeId) {
        this.incomeTypeId = incomeTypeId;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

}
