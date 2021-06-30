package com.xingji.frameproject.vo;

import com.xingji.frameproject.mybatis.entity.CapitalCavCiaBill;
import com.xingji.frameproject.mybatis.entity.CapitalPaymentBill;
import com.xingji.frameproject.mybatis.entity.PurchaseReceipt;
import com.xingji.frameproject.mybatis.entity.PurchaseReceiptDetails;
import lombok.Data;

import java.util.List;

/**
 * 采购入库单详情Vo
 */
@Data
public class PurchaseReceiptVo {
    private PurchaseReceipt receipt;
    private List<PurchaseReceiptDetails> receiptDetails;
    private List<CapitalPaymentBill> paymentBills;
    private List<CapitalCavCiaBill> ciaBills;
}
