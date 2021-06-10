package com.xingji.frameproject.vo.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StockInventoryDetailsQueryForm implements Serializable {
    private static final long serialVersionUID = 551213021290339588L;
    /**
     * 盘点详情id
     */
    private Integer id;
    /**
     * 盘点id
     */
    private String inventoryId;
    /**
     * 盘点商品名称
     */
    private String productName;
    /**
     * 盘点商品id
     */
    private String productId;
    /**
     * 盘点商品属性
     */
    private String productNature;
    /**
     * 盘点商品规格
     */
    private String productSpe;
    /**
     * 盘点商品分类
     */
    private String productType;
    /**
     * 盘点商品单位
     */
    private String productUnit;
    /**
     * 盘点系统数量
     */
    private Integer systemNum;
    /**
     * 盘点数量
     */
    private Integer inventoryNum;
    /**
     * 盘点盈亏
     */
    private Double unitPl;
    /**
     * 单据备注
     */
    private String remarks;

    private Integer pageNum;    //当前页
    private Integer PageSize;   //页大小
}