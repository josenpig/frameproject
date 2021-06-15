package com.xingji.frameproject.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (StockInventory)实体类
 *
 * @author makejava
 * @since 2021-06-08 21:08:18
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StockInventory implements Serializable {
    private static final long serialVersionUID = -90387579664765741L;
    /**
     * 盘点编号
     */
    private String id;
    /**
     * 盘点时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inventoryTime;
    /**
     * 仓库编号
     */
    private String depotId;
    /**
     * 仓库名称
     */
    private String depotName;
    /**
     * 盘点产品量
     */
    private Integer inventorycount;
    /**
     * 已盘产品量
     */
    private Integer inventorycounter;
    /**
     * 盘点人
     */
    private String inventorypeople;
    /**
     * 盘点状态0临时保存，1盘点完成
     */
    private Integer inventorystate;
    /**
     * 盘点盈亏
     */
    private Double inventorypl;
    /**
     * 单据备注
     */
    private String remarks;
    /**
     * 关联其他入库单
     */
    private String stockin;
    /**
     * 关联其他出库单
     */
    private String stockout;
}