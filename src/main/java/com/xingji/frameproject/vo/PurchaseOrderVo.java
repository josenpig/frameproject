package com.xingji.frameproject.vo;

import com.xingji.frameproject.mybatis.entity.*;
import lombok.Data;

import java.util.List;

/**
 * 采购订单详情页面信息Vo
 */
@Data
public class PurchaseOrderVo {
    private PurchaseOrder purchaseOrder;//订单信息
    private List<PurchaseOrderDetails> list;//订单详情信息
    private List<CapitalPaymentBill> payments;//该订单绑定的付款单
    private List<CapitalCavCiaBill> ciaBills;
}
