package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.BaseVendor;
import com.xingji.frameproject.service.BaseVendorService;
import com.xingji.frameproject.vo.AjaxResponse;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * (BaseVendor)表控制层
 *
 * @author makejava
 * @since 2021-06-04 15:11:47
 */
@RestController
@RequestMapping("baseVendor")
public class BaseVendorController {
    /**
     * 服务对象
     */
    @Resource
    private BaseVendorService baseVendorService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BaseVendor selectOne(String id) {
        return this.baseVendorService.queryById(id);
    }

    /**
     * 查询所有供应商信息
     * @return 产品集合
     */
    @GetMapping("/findAllVendor")
    public AjaxResponse findAllVendor(Integer currentPage, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        BaseVendor baseVendor=new BaseVendor();
        List<BaseVendor> list=baseVendorService.findAllVendor(baseVendor);
        System.out.println(list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    };

    /**
     * 查询所有供应商 返回list
     * @return 产品集合
     */
    @GetMapping("/findAllVendor/list")
    public AjaxResponse findAllVendorToList(){
        BaseVendor baseVendor=new BaseVendor();
        List<BaseVendor> list=baseVendorService.findAllVendor(baseVendor);
        System.out.println(list);
        return AjaxResponse.success(list);
    };
    
    /**
     * 根据供应商类型或负责人查询的供应商
     * @return 产品集合
     */
    @GetMapping("/findAllVendor/ByTypeOrCharge")
    public AjaxResponse findAllVendorByTypeOrCharge(@Param("currentPage")Integer currentPage, @Param("pageSize") Integer pageSize, @Param("selcharge") String selcharge, @Param("selVendorType") String selVendorType){
        System.out.println(selVendorType+"++++"+selcharge);
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        BaseVendor baseVendor = new BaseVendor();
        if (!selVendorType.equals("全部")){
            baseVendor.setVendorType(selVendorType);
        };
        if (!selcharge.equals("全部")){
            baseVendor.setCharge(selcharge);
        };
        List<BaseVendor> list=baseVendorService.findAllVendor(baseVendor);
        System.out.println(list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    };
    /**
     * 根据供应商编号或供应商名称查询的供应商
     * @return 产品集合
     */
    @GetMapping("/findAllVendor/ByIdOrName")
    public AjaxResponse findAllVendorByIdOrName(@Param("currentPage")Integer currentPage, @Param("pageSize") Integer pageSize, @Param("select") String select,@Param("SearchContent") String SearchContent){
        System.out.println(select+"++++"+SearchContent);
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        BaseVendor baseVendor = new BaseVendor();
        if (select.equals("供应商名称")){
            baseVendor.setVendorName(SearchContent);
        };
        if (select.equals("供应商编号")){
            baseVendor.setVendorId(SearchContent);
        };
        List<BaseVendor> list=baseVendorService.findAllVendor(baseVendor);
        System.out.println(list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    };
    /**
     * 删除供应商
     * @param id 供应商编号
     * @return
     */
    @GetMapping("/delVendor")
    public AjaxResponse delVendor(String id){
        System.out.println("del:"+id);
        boolean recript=baseVendorService.deleteById(id);
        return AjaxResponse.success(recript);
    };
    /**
     * 批量删除供应商
     * @param ids 供应商编号集合
     * @return
     */
    @DeleteMapping("/delVendor/batch")
    public AjaxResponse bacthDelVendor(@RequestBody List<String> ids){
        System.out.println("delList："+ids);
        List<Boolean> retList= new ArrayList<Boolean>();
        for(int i=0;i < ids.size();i++){
            Boolean recript=baseVendorService.deleteById(ids.get(i));
            retList.add(recript);
        }
        return AjaxResponse.success(retList);
    };
    /**
     * 判断供应商Id是否重复
     * @param id
     * @return
     */
    @GetMapping("/judgeVendorId")
    public Boolean judgeId(String id){
        System.out.println("id:"+id);
        BaseVendor baseCustomer =baseVendorService.queryById(id);
        Boolean result=false;
        if (baseCustomer==null){
            result=true;
        };
        return result;
    };
    /**
     * 新增供应商
     * @param add
     * @return
     */
    @RequestMapping("/addVendor")
    public AjaxResponse addVendor(@RequestBody String add){
        System.out.println(add);
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("vendor");
        BaseVendor vendor = JSON.parseObject(one, BaseVendor.class);
        BaseVendor newc=baseVendorService.insert(vendor);
        return AjaxResponse.success(newc);
    };
    /**
     * 修改供应商
     * @param add
     * @return
     */
    @RequestMapping("/updateVendor")
    public AjaxResponse updateVendor(@RequestBody String add){
        System.out.println(add);
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("vendor");
        BaseVendor vendor = JSON.parseObject(one, BaseVendor.class);
        //获取最初供应商信息 如果新的供应商信息和旧的不同则更新数据
        BaseVendor afterVendor= baseVendorService.queryById(vendor.getVendorId());
        BaseVendor newc=new BaseVendor();
        if(afterVendor.getVendorType().equals(vendor.getVendorType()) &&  afterVendor.getCharge().equals(vendor.getCharge()) &&  afterVendor.getAddress().equals(vendor.getAddress()) &&  afterVendor.getContactName().equals(vendor.getContactName()) &&  afterVendor.getContactNumber().equals(vendor.getContactNumber()) &&  afterVendor.getContactAddress().equals(vendor.getContactAddress())
        ){
            newc = afterVendor;
        }else{
            Date date = new Date();
            vendor.setUpdateTime(date);
            newc = baseVendorService.update(vendor);
        };
        return AjaxResponse.success(newc);
    };
}
