package com.xingji.frameproject.controller;

import com.xingji.frameproject.mybatis.entity.BaseVendorProduct;
import com.xingji.frameproject.service.BaseVendorProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (BaseVendorProduct)表控制层
 *
 * @author makejava
 * @since 2021-06-25 15:26:11
 */
@RestController
@RequestMapping("baseVendorProduct")
public class BaseVendorProductController {
    /**
     * 服务对象
     */
    @Resource
    private BaseVendorProductService baseVendorProductService;

    /**
     * 通过主键查询单条数据
     *
     * @param
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BaseVendorProduct selectOne(String vendorId) {
        return this.baseVendorProductService.queryById(vendorId);
    }


}
