package com.xingji.frameproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/***
 * @author: 顾渊白
 * @date: 2021/6/9 9:02
 * @version 1.0
 */
@Data
public class CiaCapVo {
    private String capitalId;
    /**
     * 收付款类型
     */
    private String capitalType;
    /**
     * 收付款日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date capitalTime;
    /**
     * 预收付金额
     */
    private Double beforeMoney;
    /**
     * 已核销金额
     */
    private Double writtenMoney;
    /**
     * 未核销金额
     */
    private Double unwrittenMoney;
    /**
     * 本次核销金额
     */
    private Double thisMoney;
    private String otherParty;
}
