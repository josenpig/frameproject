package com.xingji.frameproject.vo;

import com.xingji.frameproject.mybatis.entity.PurchaseOrder;
import com.xingji.frameproject.mybatis.entity.PurchaseOrderDetails;
import lombok.Data;

import java.util.List;

/**
 * 采购订单详情页面信息Vo
 */
@Data
public class PurchaseOrderVo {
    private PurchaseOrder purchaseOrder;//订单信息
    private List<PurchaseOrderDetails> list;//订单详情信息
}
