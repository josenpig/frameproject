package com.xingji.frameproject.vo.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BaseDepotQueryForm implements Serializable {
    private static final long serialVersionUID = -27567200884546299L;
    /**
     * *仓库编号
     */
    private String depotId;
    /**
     * *仓库名称
     */
    private String depotName;
    /**
     * 仓库地址
     */
    private String depotAddress;
    /**
     * *负责人id: 连接负责人表
     */
    private Integer chargeId;
    /**
     * 联系电话
     */
    private String contactNumber;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 状态: （已启用：1；已禁用：0）
     */
    private Integer state;

    private Integer pageNum;    //当前页
    private Integer PageSize;   //页大小
}