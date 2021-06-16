package com.xingji.frameproject.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (BaseOpening)实体类
 *
 * @author makejava
 * @since 2021-05-28 16:38:54
 */
@Data
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

}
