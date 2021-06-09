package com.xingji.frameproject.controller;

import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.BaseCustomerService;
import com.xingji.frameproject.service.BaseVendorService;
import com.xingji.frameproject.service.SysUserService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.OfpeopleVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/***
 * @author: 顾渊白
 * @date: 2021/5/14 16:06
 * @version 1.0
 */
@Slf4j
@RestController
@EnableSwagger2
@Api(description = "人员Api")
@RequestMapping("/personnel")
public class PersonnelController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    SysUserService us;
    @Autowired
    BaseCustomerService bcs;
    @Autowired
    BaseVendorService bvs;

    @GetMapping("/ofpeople")
    public AjaxResponse roleusers(){
        List<SysUser> salemens=us.roleusers(3);
        List<SysUser> purchasemans=us.roleusers(1);
        List<SysUser> notifiers=us.queryAll(new SysUser());
        List<BaseCustomer> customers=bcs.queryAll(new BaseCustomer());
        List<BaseVendor> vendors=bvs.findAllVendor(new BaseVendor());
        OfpeopleVo vo=new OfpeopleVo();
        vo.setSalemans(salemens);
        vo.setPurchasemans(purchasemans);
        vo.setCustomers(customers);
        vo.setNotifiers(notifiers);
        vo.setVendors(vendors);
        return AjaxResponse.success(vo);
    }
}