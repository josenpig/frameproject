package com.xingji.frameproject.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.BaseCapitalAccount;
import com.xingji.frameproject.service.BaseCapitalAccountService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (BaseCapitalAccount)表控制层
 *
 * @author makejava
 * @since 2021-06-02 08:55:31
 */
@RestController
@RequestMapping("baseCapitalAccount")
public class BaseCapitalAccountController {
    /**
     * 服务对象
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private BaseCapitalAccountService baseCapitalAccountService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BaseCapitalAccount selectOne(String id) {
        return this.baseCapitalAccountService.queryById(id);
    }

    /**
     * 查询所有资金账户信息
     * @return 产品集合
     */
    @GetMapping("/findAllCapitalAccount")
    public AjaxResponse findAllProduct(Integer currentPage, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<BaseCapitalAccount> baseCapitalAccountVos=baseCapitalAccountService.findAllCapitalAccount();
        System.out.println(baseCapitalAccountVos);
        map.put("total",page.getTotal());
        map.put("rows",baseCapitalAccountVos);
        return AjaxResponse.success(map);
    };
}
