package com.xingji.frameproject.vo;

import com.xingji.frameproject.mybatis.entity.BaseCustomer;
import com.xingji.frameproject.mybatis.entity.BaseVendor;
import com.xingji.frameproject.mybatis.entity.SysUser;
import lombok.Data;

import java.util.List;

/***
 * @author: 顾渊白
 * @date: 2021/6/3 16:37
 * @version 1.0
 */
@Data
public class OfpeopleVo {
    private List<SysUser> salemans;//销售人员
    private List<SysUser> purchasemans;//采购人员
    private List<BaseCustomer> customers;//客户
    private List<SysUser> notifiers;//通知人
    private List<BaseVendor> vendors;//供应商
}
