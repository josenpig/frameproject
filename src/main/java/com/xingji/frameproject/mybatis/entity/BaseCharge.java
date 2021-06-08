package com.xingji.frameproject.mybatis.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * (BaseCharge)实体类
 *
 * @author makejava
 * @since 2021-06-01 16:45:26
 */
@Data
public class BaseCharge implements Serializable {
    private static final long serialVersionUID = -38621657403573518L;
    /**
     * 负责人id
     */
    private Integer chargeId;
    /**
     * 负责人名称
     */
    private String chargeName;


    public Integer getChargeId() {
        return chargeId;
    }

    public void setChargeId(Integer chargeId) {
        this.chargeId = chargeId;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

}
