package com.xingji.frameproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/***
 * @author: 顾渊白
 * @date: 2021/6/8 21:52
 * @version 1.0
 */
@Data
public class CiaBillVo {
    private String saleId;
    private String saleType;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date saleTime;
    private String otherParty;
    private BigDecimal shouldMoney;
    private BigDecimal alreadyMoney;
    private BigDecimal notMoney;
}
