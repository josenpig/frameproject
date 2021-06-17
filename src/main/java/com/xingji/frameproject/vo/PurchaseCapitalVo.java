package com.xingji.frameproject.vo;

<<<<<<< HEAD
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
=======
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/***
 * @author: 顾渊白
 * @date: 2021/6/16 8:53
 * @version 1.0
 */
@Data
public class PurchaseCapitalVo {
    private String purchaseId;
    private String purchaseType;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchaseTime;
    private String vendor;
    private Double payableMoney;
    private Double paidMoney;
    private Double unpaidMoney;
>>>>>>> 462ab7b18968e3b4066d2ecb0fff950ccb45c82e
}
