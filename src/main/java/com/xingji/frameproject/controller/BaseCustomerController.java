package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.BaseCustomer;
import com.xingji.frameproject.service.BaseCustomerService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * (BaseCustomer)表控制层
 *
 * @author makejava
 * @since 2021-06-01 09:29:18
 */
@RestController
@RequestMapping("baseCustomer")
public class BaseCustomerController {

    @Resource
    private BaseCustomerService baseCustomerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BaseCustomer selectOne(String id) {
        return this.baseCustomerService.queryById(id);
    }

    /**
     * 查询所有客户信息
     * @return 客户集合
     */
    @GetMapping("/findAllCustomer")
    public AjaxResponse findAllProduct(Integer currentPage, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        BaseCustomer baseCustomer=new BaseCustomer();
        List<BaseCustomer> list=baseCustomerService.findAllCutomer(baseCustomer);
        System.out.println(list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    };

    /**
     * 根据客户类型或负责人查询的客户
     * @return 客户集合
     */
    @GetMapping("/findAllCustomer/ByTypeOrCharge")
    public AjaxResponse findAllCustomerByTypeOrCharge(@Param("currentPage")Integer currentPage, @Param("pageSize") Integer pageSize, @Param("selcharge") String selcharge, @Param("selCustomerType") String selCustomerType){
        System.out.println(selCustomerType+"++++"+selcharge);
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        BaseCustomer baseCustomer = new BaseCustomer();
        if (!selCustomerType.equals("全部")){
            baseCustomer.setCustomerType(selCustomerType);
        };
        if (!selcharge.equals("全部")){
            baseCustomer.setChargeName(selcharge);
        };
        List<BaseCustomer> list=baseCustomerService.findAllCutomer(baseCustomer);
        System.out.println(list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    };

    /**
     * 根据客户编号或客户名称查询的客户
     * @return 客户集合
     */
    @GetMapping("/findAllCustomer/ByIdOrName")
    public AjaxResponse findAllProductByIdOrName(@Param("currentPage")Integer currentPage, @Param("pageSize") Integer pageSize, @Param("select") String select,@Param("SearchContent") String SearchContent){
        System.out.println(select+"++++"+SearchContent);
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        BaseCustomer baseCustomer = new BaseCustomer();
        if (select.equals("客户名称")){
            baseCustomer.setCustomerName(SearchContent);
        };
        if (select.equals("客户编号")){
            baseCustomer.setCustomerNumber(SearchContent);
        };
        List<BaseCustomer> list=baseCustomerService.findAllCutomer(baseCustomer);
        System.out.println(list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    };

    /**
     * 删除客户
     * @param id 客户编号
     * @return
     */
    @GetMapping("/delCustomer")
    public AjaxResponse delCustomer(String id){
        System.out.println("del:"+id);
        String recript=baseCustomerService.deleteById(id);
        return AjaxResponse.success(recript);
    };

    /**
     * 批量删除客户
     * @param ids 客户编号集合
     * @return
     */
    @DeleteMapping("/delCustomer/batch")
    public AjaxResponse bacthDelCustomer(@RequestBody List<String> ids){
        System.out.println("delList："+ids);
        List<String> retList= new ArrayList<String>();
        for(int i=0;i < ids.size();i++){
            String recript=baseCustomerService.deleteById(ids.get(i));
            retList.add(recript);
        }
        return AjaxResponse.success(retList);
    };

    /**
     * 判断客户Id是否重复
     * @param cid
     * @return
     */
    @GetMapping("/judgeCustomerId")
    public Boolean judgeId(String cid){
        System.out.println("cid:"+cid);
        BaseCustomer baseCustomer =baseCustomerService.queryById(cid);
        Boolean result=false;
        if (baseCustomer==null){
            result=true;
        };
        return result;
    };

    /**
     * 新增客户
     * @param add
     * @return
     */
    @RequestMapping("/addCustomer")
    public AjaxResponse addCustomer(@RequestBody String add){
        System.out.println(add);
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("customer");
        BaseCustomer customer = JSON.parseObject(one, BaseCustomer.class);
        BaseCustomer newc=baseCustomerService.insert(customer);
        return AjaxResponse.success(newc);
    };

    /**
     * 修改客户
     * @param add
     * @return
     */
    @RequestMapping("/updateCustomer")
    public AjaxResponse updateCustomer(@RequestBody String add){
        System.out.println(add);
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("customer");
        BaseCustomer customer = JSON.parseObject(one, BaseCustomer.class);
        //获取最初客户信息 如果新的客户信息和旧的不同则更新数据
        BaseCustomer afterCustomer= baseCustomerService.queryById(customer.getCustomerNumber());
        BaseCustomer newc=new BaseCustomer();
        if(afterCustomer.getCustomerName().equals(customer.getCustomerName()) && afterCustomer.getCustomerType().equals(customer.getCustomerType()) &&  afterCustomer.getChargeName().equals(customer.getChargeName()) &&  Double.doubleToLongBits(afterCustomer.getRatio())==Double.doubleToLongBits(customer.getRatio()) &&  afterCustomer.getRemarks().equals(customer.getRemarks()) &&  afterCustomer.getContact().equals(customer.getContact()) &&  afterCustomer.getContactNumber().equals(customer.getContactNumber()) &&  afterCustomer.getContactAddress().equals(customer.getContactAddress())
        ){
            newc = afterCustomer;
        }else{
            customer.setUpdateTime(new Date());
            newc = baseCustomerService.update(customer);
        };
        return AjaxResponse.success(newc);
    };
}
