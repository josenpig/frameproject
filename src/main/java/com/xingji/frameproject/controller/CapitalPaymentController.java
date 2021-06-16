package com.xingji.frameproject.controller;

import com.xingji.frameproject.mybatis.entity.CapitalPayment;
import com.xingji.frameproject.service.CapitalPaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (CapitalPayment)表控制层
 *
 * @author makejava
 * @since 2021-06-16 19:14:13
 */
@RestController
@RequestMapping("/capitalPayment")
public class CapitalPaymentController {
    /**
     * 服务对象
     */
    @Resource
    private CapitalPaymentService capitalPaymentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public CapitalPayment selectOne(String id) {
        return this.capitalPaymentService.queryById(id);
    }

}
