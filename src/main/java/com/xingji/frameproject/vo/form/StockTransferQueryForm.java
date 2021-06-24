package com.xingji.frameproject.vo.form;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StockTransferQueryForm implements Serializable {
    private static final long serialVersionUID = 804336148896234644L;
    /**
     * 调拨单id
     */
    private String id;
    /**
     * 调拨日期
     */
    private Date transferDate;
    /**
     * 单据日期
     */
    private Date
            documentDate;
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
    private Date vettingDate;
    /**
     * 审批人
     */
    private String vettingName;
    /**
     * 修改时间
     */
    private Date updateDate;

    private Integer pageNum;    //当前页
    private Integer pageSize;   //页大小

    public Integer getPageNum() {
        if (pageNum == null)
            return 1;
        return pageNum;
    }

    public Integer getPageSize() {
        if (pageSize == null)
            return 0;
        return pageSize;
    }
}
