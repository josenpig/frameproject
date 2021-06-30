package com.xingji.frameproject.controller;

import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.*;
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
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    BaseDepotService depotService;

    @GetMapping("/ofpeople")
    public AjaxResponse roleusers(){
        List<SysUser> salemens=us.roleusers(3);//销售人员
        List<SysUser> purchasemans=us.roleusers(2);//采购人员
        List<SysUser> capitals=us.roleusers(5);//资金收付款人员
        List<SysUser> stocks=us.roleusers(4);//库存管理人员
        List<SysUser> notifiers=us.queryAll(new SysUser());//所有人员
        List<BaseCustomer> customers=bcs.queryAll(new BaseCustomer());//客户
        List<BaseVendor> vendors=bvs.findAllVendor(new BaseVendor());//供应商
        List<SysRole> sysRoles=sysRoleService.queryAll(new SysRole());//所有角色
        List<BaseDepot> depots = depotService.findAll();//所有仓库
        OfpeopleVo vo=new OfpeopleVo();
        vo.setDepots(depots);
        vo.setSalemans(salemens);
        vo.setPurchasemans(purchasemans);
        vo.setCapitals(capitals);
        vo.setStocks(stocks);
        vo.setCustomers(customers);
        vo.setNotifiers(notifiers);
        vo.setVendors(vendors);
        vo.setSysRoles(sysRoles);
        return AjaxResponse.success(vo);
    }
}