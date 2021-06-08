package com.xingji.frameproject.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.annotation.Log;
import com.xingji.frameproject.mybatis.entity.BaseCharge;
import com.xingji.frameproject.mybatis.entity.BaseCustomer;
import com.xingji.frameproject.mybatis.entity.Loginin;
import com.xingji.frameproject.service.LogininService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录日志（表控制层）
 */
@RestController
@RequestMapping("operationlog")
public class OperationlogController {
    /**
     * 服务对象
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private LogininService logininService;
    /**
     * 通过登陆日期查询
     * @param logintime
     * @return 登录日志集合
     */
    public AjaxResponse findloginlogbylogtime(Date logintime){
        return null;
    }
    /**
     * 查询所有登录日志
     * @return 日志记录集合
     */
    @Log("test")
    @GetMapping("/findAll")
   public AjaxResponse findAllLoginin(Integer currentPage, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        Loginin loginin=new Loginin();
        List<Loginin> list=logininService.findAll(loginin);
        System.out.println(list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
   }
}
