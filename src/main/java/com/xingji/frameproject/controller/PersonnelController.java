package com.xingji.frameproject.controller;

import com.xingji.frameproject.mybatis.entity.BaseCustomer;
import com.xingji.frameproject.mybatis.entity.BaseProduct;
import com.xingji.frameproject.mybatis.entity.SysMenu;
import com.xingji.frameproject.mybatis.entity.SysUser;
import com.xingji.frameproject.service.BaseCapitalAccountService;
import com.xingji.frameproject.service.BaseCustomerService;
import com.xingji.frameproject.service.SysUserService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.util.SendSms;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.SaleofpeopleVo;
import com.xingji.frameproject.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @GetMapping("/saleofpeople/{id}")
    public AjaxResponse roleusers(@PathVariable("id") Integer id){
        List<SysUser> salemens=us.roleusers(id);
        List<SysUser> notifiers=us.queryAll(new SysUser());
        List<BaseCustomer> customers=bcs.queryAll(new BaseCustomer());
        SaleofpeopleVo vo=new SaleofpeopleVo();
        vo.setSalemans(salemens);
        vo.setCustomers(customers);
        vo.setNotifiers(notifiers);
        return AjaxResponse.success(vo);
    }
}