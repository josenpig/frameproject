package com.xingji.frameproject.vo;

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
public class PurchaseReceiptVo {
    private String purchaseId;
    private String purchaseType;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchaseTime;
    private String vendor;
    private Double payableMoney;
    private Double paidMoney;
    private Double unpaidMoney;
}
