package com.xingji.frameproject.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SalesTopVo {
    /**
     * 总销售量
     */
    private Integer psum;
    /**
     * 产品编号
     */
    private String productId;
    /**
     * 产品名称
     */
    private String productName;
}
