package com.xingji.frameproject.vo.form;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StockTransferDetailsQueryForm implements Serializable {
    private static final long serialVersionUID = -29122139689044995L;
    /**
     * 调拨单详情id
     */
    private Long id;
    /**
     * 调拨单id
     */
    private String transferId;
    /**
     * 产品id
     */
    private String productId;
    /**
     * 调拨数量
     */
    private Integer productNum;
    /**
     * 备注
     */
    private String remark;

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
