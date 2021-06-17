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

    public BaseProduct() {
    }
}
