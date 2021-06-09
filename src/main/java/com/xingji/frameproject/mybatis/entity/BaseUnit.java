package com.xingji.frameproject.mybatis.entity;

import lombok.ToString;

import java.io.Serializable;

/**
 * (BaseUnit)实体类
 *
 * @author makejava
 * @since 2021-06-09 14:39:18
 */
@ToString
public class BaseUnit implements Serializable {
    private static final long serialVersionUID = 254562572521798550L;
    /**
     * 单位id
     */
    private Integer unitId;
    /**
     * 单位名称
     */
    private String unitName;


    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

}
