package com.xingji.frameproject.vo.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StockInventoryQueryForm implements Serializable {
    private static final long serialVersionUID = 384420321960952452L;
    /**
     * 盘点编号
     */
    private String id;
    /**
     * 盘点时间
     */
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

    private Integer pageNum;    //当前页
    private Integer PageSize;   //页大小
}