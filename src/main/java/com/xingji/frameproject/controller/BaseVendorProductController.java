package com.xingji.frameproject.controller;

import com.xingji.frameproject.mybatis.entity.BaseVendor;
import com.xingji.frameproject.mybatis.entity.BaseVendorProduct;
import com.xingji.frameproject.service.BaseVendorProductService;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.BaseVendorProductVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 根据供应商id查询供应商下的产品 返回list
     * @return 产品集合
     */
    @GetMapping("/findAllbaseVendorProduct/list")
    public AjaxResponse findAllVendorToList(String id){
        BaseVendorProductVo baseVendor=new BaseVendorProductVo();
        baseVendor.setVendorId(id);
        List<BaseVendorProductVo> list=baseVendorProductService.queryAllBaseVendorProductVo(baseVendor);
        System.out.println(list);
        return AjaxResponse.success(list);
    };
}
