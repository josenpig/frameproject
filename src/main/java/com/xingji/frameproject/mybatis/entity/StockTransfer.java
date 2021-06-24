package com.xingji.frameproject.mybatis.entity;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * (StockTransfer)实体类
 *
 * @author hdr666
 * @since 2021-06-22 14:17:26
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StockTransfer implements Serializable {
    private static final long serialVersionUID = -35817946725604030L;
    /**
     * 调拨单id
     */
    private String id;
    /**
     * 调拨日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date transferDate;
    /**
     * 单据日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date documentDate;
    /**
     * 入库仓库
     */
    private String inwarehouse;
    /**
     * 出库仓库
     */
    private String outwarehouse;
    /**
     * 订单状态
     */
    private Integer state;
    /**
     * 创建人
     */
    private String createPeople;
    /**
     * 修改人
     */
    private String updatePeople;
    /**
     * 审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date vettingDate;
    /**
     * 审批人
     */
    private String vettingName;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateDate;
}
