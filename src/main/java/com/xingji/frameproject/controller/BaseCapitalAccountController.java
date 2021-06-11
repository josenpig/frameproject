package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.mybatis.entity.BaseCapitalAccount;
import com.xingji.frameproject.service.BaseCapitalAccountService;
import com.xingji.frameproject.service.CapitalReceiptAccountService;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.BaseCapitalAccountVo;
import io.lettuce.core.dynamic.annotation.Param;
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
    @Resource
    private CapitalReceiptAccountService capitalReceiptAccountService;

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
     * @return 资金账户集合
     */
    @GetMapping("/findAllCapitalAccountVo")
    public AjaxResponse findAllProduct(Integer currentPage, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        BaseCapitalAccountVo baseCapitalAccount=new BaseCapitalAccountVo();
        List<BaseCapitalAccountVo> list=baseCapitalAccountService.queryAllVo(baseCapitalAccount);
        System.out.println(list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    };

    /**
     * 根据资金账户编号或资金账户名称查询资金账户
     * @return 产品集合
     */
    @GetMapping("/findAllCapitalAccountVo/ByIdOrName")
    public AjaxResponse findAllDepotByIdOrName(@Param("currentPage")Integer currentPage, @Param("pageSize") Integer pageSize, @Param("select") String select, @Param("SearchContent") String SearchContent){
        System.out.println(select+"++++"+SearchContent);
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        BaseCapitalAccountVo baseCapitalAccountVo = new BaseCapitalAccountVo();
        if (select.equals("资金账户名称")){
            baseCapitalAccountVo.setFundAccount(SearchContent);
        };
        if (select.equals("资金账户编号")){
            baseCapitalAccountVo.setCapitalId(SearchContent);
        };
        List<BaseCapitalAccountVo> list=baseCapitalAccountService.queryAllVo(baseCapitalAccountVo);
        System.out.println(list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    };

    /**
     * 删除资金账户
     * @param uid 单位编号
     * @return
     */
    @GetMapping("/delCapitalAccount")
    public AjaxResponse delCapitalAccount(String uid){
        System.out.println("del:"+uid);
        CapitalReceiptAccount capitalReceiptAccount=new CapitalReceiptAccount();
        capitalReceiptAccount.setFundAccount(uid);
        List<CapitalReceiptAccount> list=capitalReceiptAccountService.queryAll(capitalReceiptAccount);
        Boolean recript=false;
        if(list.size()==0){
            recript=baseCapitalAccountService.deleteById(uid);
        }
        return AjaxResponse.success(recript);
    };

    /**
     * 判断资金账户Id是否重复
     * @param id
     * @return
     */
    @GetMapping("/judgeCapitalId")
    public Boolean judgeId(String id){
        System.out.println("id:"+id);
        BaseCapitalAccount baseCapitalAccount =baseCapitalAccountService.queryById(id);
        Boolean result=false;
        if (baseCapitalAccount==null){
            result=true;
        };
        return result;
    };

    /**
     * 新增资金账户
     * @param add
     * @return
     */
    @RequestMapping("/addCapitalAccount")
    public AjaxResponse addCapitalAccount(@RequestBody String add){
        System.out.println(add);
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("CapitalAccount");
        BaseCapitalAccount CapitalAccount = JSON.parseObject(one, BaseCapitalAccount.class);
        System.out.println("c:"+CapitalAccount);
        BaseCapitalAccount newc=baseCapitalAccountService.insert(CapitalAccount);
        return AjaxResponse.success(newc);
    };

    /**
     * 修改资金账户
     * @param add
     * @return
     */
    @RequestMapping("/updateCapitalAccount")
    public AjaxResponse updateCapitalAccount(@RequestBody String add){
        System.out.println(add);
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("CapitalAccount");
        BaseCapitalAccount CapitalAccount = JSON.parseObject(one, BaseCapitalAccount.class);
        BaseCapitalAccount baseCapitalAccount=baseCapitalAccountService.update(CapitalAccount);
        return AjaxResponse.success(baseCapitalAccount);
    };

    /**
     * 设为默认账户
     * @param uid 单位编号
     * @return
     */
    @GetMapping("/setState")
    public AjaxResponse setState(String uid){
        System.out.println("setState:"+uid);
        //取消之前的默认账户
        BaseCapitalAccountVo baseCapitalAccountVo=new BaseCapitalAccountVo();
        baseCapitalAccountVo.setState(1);
        List<BaseCapitalAccountVo> on=baseCapitalAccountService.queryAllVo(baseCapitalAccountVo);
        BaseCapitalAccount noBaseCapitalAccount=new BaseCapitalAccount();
        noBaseCapitalAccount.setCapitalId(on.get(0).getCapitalId());
        noBaseCapitalAccount.setState(0);
        BaseCapitalAccount onAccount=baseCapitalAccountService.update(noBaseCapitalAccount);
        System.out.println(onAccount);
        //设置当前账户为默认账户
        BaseCapitalAccount now=new BaseCapitalAccount();
        noBaseCapitalAccount.setCapitalId(uid);
        noBaseCapitalAccount.setState(1);
        BaseCapitalAccount nowAccount=baseCapitalAccountService.update(noBaseCapitalAccount);
        return AjaxResponse.success(nowAccount);
    };
}
