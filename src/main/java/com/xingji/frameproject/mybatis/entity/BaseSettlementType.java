package com.xingji.frameproject.mybatis.entity;

import java.io.Serializable;

/**
 * (BaseSettlementType)实体类
 *
 * @author makejava
 * @since 2021-06-10 16:22:16
 */
public class BaseSettlementType implements Serializable {
    private static final long serialVersionUID = 985892440921881234L;
    /**
     * *结算类型id
     */
    private Integer id;
    /**
     * *结算类型名称
     */
    private String settlementType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }

}
