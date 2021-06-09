package com.xingji.frameproject.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (CapitalCavCiaCap)实体类
 *
 * @author makejava
 * @since 2021-06-08 18:48:19
 */
@Data
public class CapitalCavCiaCap implements Serializable {
    private static final long serialVersionUID = -24063676064060100L;

    private Integer id;
    /**
     * 核销单编号
     */
    private String cavId;
    /**
     * 收付款单编号
     */
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCavId() {
        return cavId;
    }

    public void setCavId(String cavId) {
        this.cavId = cavId;
    }

    public String getCapitalId() {
        return capitalId;
    }

    public void setCapitalId(String capitalId) {
        this.capitalId = capitalId;
    }

    public String getCapitalType() {
        return capitalType;
    }

    public void setCapitalType(String capitalType) {
        this.capitalType = capitalType;
    }

    public Date getCapitalTime() {
        return capitalTime;
    }

    public void setCapitalTime(Date capitalTime) {
        this.capitalTime = capitalTime;
    }

    public Double getBeforeMoney() {
        return beforeMoney;
    }

    public void setBeforeMoney(Double beforeMoney) {
        this.beforeMoney = beforeMoney;
    }

    public Double getWrittenMoney() {
        return writtenMoney;
    }

    public void setWrittenMoney(Double writtenMoney) {
        this.writtenMoney = writtenMoney;
    }

    public Double getUnwrittenMoney() {
        return unwrittenMoney;
    }

    public void setUnwrittenMoney(Double unwrittenMoney) {
        this.unwrittenMoney = unwrittenMoney;
    }

    public Double getThisMoney() {
        return thisMoney;
    }

    public void setThisMoney(Double thisMoney) {
        this.thisMoney = thisMoney;
    }

}
