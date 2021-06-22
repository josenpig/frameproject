package com.xingji.frameproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
public class FundAccountsStatisticsVo {
    /**
     * *资金账户编号
     */
    private String capitalId;
    /**
     * *资金账户名称
     */
    private String fundAccount;
    /**
     * *结算类型id
     */
    private Integer settlementTypeId;

    /**
     * *结算类型名称
     */
    private String settlementType;
    /**
     * *初期金额
     */
    private Double initialAmount;
    /**
     * 当前金额
     */
    private Double currentAmount;
    /**
     * 是否为默认账户: （是：1；否：0）
     */
    private Integer state;

    /**
     * 付款支出合计
     */
    private Double paymentMoney;
    /**
     * 收款收入合计
     */
    private Double receiptMoney;

    /**
     * 期间开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 期间开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
