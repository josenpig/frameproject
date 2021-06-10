package com.xingji.frameproject.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.BaseCapitalAccount;
import com.xingji.frameproject.mybatis.entity.BaseCustomer;
import com.xingji.frameproject.service.BaseCapitalAccountService;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.BaseCapitalAccountVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (BaseCapitalAccount)表控制层
 *
 * @author makejava
 * @since 2021-06-10 15:19:50
 */
@RestController
@RequestMapping("baseCapitalAccount")
public class BaseCapitalAccountController {
    /**
     * 服务对象
     */
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
     * @return 客户集合
     */
    @GetMapping("/findAllCapitalAccountVo")
    public AjaxResponse findAllProduct(Integer currentPage, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        BaseCapitalAccountVo baseCustomer=new BaseCapitalAccountVo();
        List<BaseCapitalAccountVo> list=baseCapitalAccountService.queryAllVo(baseCustomer);
        System.out.println(list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    };
}
