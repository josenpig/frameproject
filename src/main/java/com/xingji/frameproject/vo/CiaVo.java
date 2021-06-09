package com.xingji.frameproject.vo;

import com.xingji.frameproject.mybatis.entity.CapitalCavCia;
import com.xingji.frameproject.mybatis.entity.CapitalCavCiaBill;
import com.xingji.frameproject.mybatis.entity.CapitalCavCiaCap;
import lombok.Data;

import java.util.List;

/***
 * @author: 顾渊白
 * @date: 2021/6/9 17:04
 * @version 1.0
 */
@Data
public class CiaVo {
    private CapitalCavCia order;
    private List<CapitalCavCiaBill> bills;
    private List<CapitalCavCiaCap> caps;
}
