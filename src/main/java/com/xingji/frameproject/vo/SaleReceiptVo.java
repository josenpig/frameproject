package com.xingji.frameproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/***
 * @author: 顾渊白
 * @date: 2021/6/1 20:07
 * @version 1.0
 */
@Data
public class SaleReceiptVo {
    private String saleId;
    private String saleType;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date saleTime;
    private String customer;
    private Double receiptMoney;
    private Double receivedMoney;
    private Double uncollectedMoney;
}
