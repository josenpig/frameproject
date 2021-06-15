package com.xingji.frameproject.vo;

import com.xingji.frameproject.mybatis.entity.StockInventory;
import com.xingji.frameproject.mybatis.entity.StockInventoryDetails;
import lombok.Data;

import java.util.List;

/**
 * 库存盘点订单以及订单详情Vo
 */
@Data
public class InventoryDetailsVo {
    private StockInventory stockInventory;//库存订单
    private List<StockInventoryDetails> list;//库存订单详情
}
