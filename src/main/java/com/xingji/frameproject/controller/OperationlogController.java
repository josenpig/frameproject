package com.xingji.frameproject.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.annotation.Log;
import com.xingji.frameproject.mybatis.entity.Loginin;
import com.xingji.frameproject.mybatis.entity.Operationlog;
import com.xingji.frameproject.mybatis.entity.SysUser;
import com.xingji.frameproject.service.LogininService;
import com.xingji.frameproject.service.OperationlogService;
import com.xingji.frameproject.service.SysUserService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.LoginLogVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录日志（表控制层）
 */
@Slf4j
@RestController
@RequestMapping("/operationlog")
public class OperationlogController {
    /**
     * 服务对象
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private LogininService logininService;
    @Resource
    private OperationlogService operationlogService;

    /**
     * 查询所有登录日志
     * @return 日志记录集合
     */
    @GetMapping("/findAll")
   public AjaxResponse findAllLoginin(Integer currentPage, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        Loginin loginin=new Loginin();
        List<Loginin> list=logininService.findAll(loginin);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
   }

    /**
     * 查询所有操作日志
     * @return 日志记录集合
     */
    @Log("查询操作日志")
    @GetMapping("/findAllLog")
    public AjaxResponse findAllOperationLog(Integer currentPage, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        Operationlog operationlog=new Operationlog();
        List<Operationlog> list= operationlogService.findAll(operationlog);
        System.out.println(list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }

    @GetMapping("/findlogbyOperator")
    public AjaxResponse findLogbyOperator(String operator,Integer currentPage, Integer pagesize ,String logintime) {
        Map<String,Object> map=new HashMap<>();
        char i = logintime.charAt(9);
        int num = Integer.parseInt(String.valueOf(i));
        System.out.println("-----------"+num);
        num=num+1;
        String as=String.valueOf(num);
        StringBuilder sb=new StringBuilder(as);
        String time=logintime.substring(0,9);
        System.out.println("--------------"+time);
        sb.insert(0,time);
        time=sb.toString();
        System.out.println("char:"+i+ "String as:"+as+"Num:"+num+"time:"+time);
        Page<Object> page= PageHelper.startPage(currentPage,pagesize);
        List<Loginin> list = null;
        Loginin loginin=new Loginin();
        time=time+"%";
        list=logininService.findlogbyLogintime(time);
        if(operator==null || operator==""){
            list=logininService.findAll(loginin);
        }else{
            list=logininService.findlogByOperator(operator);
        }
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
}
