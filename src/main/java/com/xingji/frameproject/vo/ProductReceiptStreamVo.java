package com.xingji.frameproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
public class ProductReceiptStreamVo {//产品入库
    /**
     * 产品编号
     */
    private String productId;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 采购入库单id
     */
    private String receiptid;
    /**
     * 产品数量
     */
    private Integer productNum;
   /**
     * 采购金额
     */
    private Double purchaseMoney;
    /**
     * 仓库名
     */
    private String depotName;
    /**
     * 最后审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastVettingTime;

}
