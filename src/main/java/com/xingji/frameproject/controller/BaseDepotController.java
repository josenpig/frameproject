package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.mybatis.entity.BaseDepot;
import com.xingji.frameproject.mybatis.entity.BaseDepot;
import com.xingji.frameproject.service.BaseDepotService;
import com.xingji.frameproject.service.BaseOpeningService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (BaseDepot)表控制层
 *
 * @author makejava
 * @since 2021-05-28 19:30:48
 */
@RestController
@RequestMapping("baseDepot")
public class BaseDepotController {
    /**
     * 服务对象
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private BaseDepotService baseDepotService;
    @Resource
    private BaseOpeningService baseOpeningService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BaseDepot selectOne(String id) {
        return this.baseDepotService.queryById(id);
    }

    /**
     * 查询所有仓库信息
     * @return 仓库集合
     */
    @GetMapping("/findAllDepot")
    public AjaxResponse findAllProduct(Integer currentPage, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<BaseDepot> baseDepotVoList=baseDepotService.findAllDepot();
        System.out.println(baseDepotVoList);
        map.put("total",page.getTotal());
        map.put("rows",baseDepotVoList);
        return AjaxResponse.success(map);
    };
    /**
     * 根据仓库编号或仓库名称查询的仓库
     * @return 产品集合
     */
    @GetMapping("/findAllDepot/ByIdOrName")
    public AjaxResponse findAllDepotByIdOrName(@Param("currentPage")Integer currentPage, @Param("pageSize") Integer pageSize, @Param("select") String select, @Param("SearchContent") String SearchContent){
        System.out.println(select+"++++"+SearchContent);
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        BaseDepot baseDepot = new BaseDepot();
        if (select.equals("仓库名称")){
            baseDepot.setDepotName(SearchContent);
        };
        if (select.equals("仓库编号")){
            baseDepot.setDepotId(SearchContent);
        };
        List<BaseDepot> list=baseDepotService.queryAll(baseDepot);
        System.out.println(list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    };
    /**
     * 删除仓库
     * @param depotId 仓库编号
     * @return
     */
    @GetMapping("/delDepot")
    public AjaxResponse delDepot(String depotId){
        System.out.println("del:"+depotId);
        BaseDepot baseDepot=baseDepotService.queryById(depotId);
        BaseOpening baseOpening=new BaseOpening();
        baseOpening.setDepotName(baseDepot.getDepotName());
        List<BaseOpening> list=baseOpeningService.queryAll(baseOpening);
        boolean recript=false;
        if(list.size()==0){
            recript=baseDepotService.deleteById(depotId);
        }
        return AjaxResponse.success(recript);
    };
    /**
     * 判断仓库Id是否重复
     * @param id
     * @return
     */
    @GetMapping("/judgeDepotId")
    public Boolean judgeId(String id){
        System.out.println("id:"+id);
        BaseDepot baseCustomer =baseDepotService.queryById(id);
        Boolean result=false;
        if (baseCustomer==null){
            result=true;
        };
        return result;
    };
    /**
     * 新增仓库
     * @param add
     * @return
     */
    @RequestMapping("/addDepot")
    public AjaxResponse addDepot(@RequestBody String add){
        System.out.println(add);
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("Depot");
        BaseDepot Depot = JSON.parseObject(one, BaseDepot.class);
        BaseDepot newc=baseDepotService.insert(Depot);
        return AjaxResponse.success(newc);
    };
    /**
     * 修改仓库
     * @param add
     * @return
     */
    @RequestMapping("/updateDepot")
    public AjaxResponse updateDepot(@RequestBody String add){
        System.out.println(add);
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("Depot");
        BaseDepot Depot = JSON.parseObject(one, BaseDepot.class);
        BaseDepot baseDepot=baseDepotService.update(Depot);
        return AjaxResponse.success(baseDepot);
    };
    /**
     * 禁用或启用
     * @param Did,Dstate
     * @return
     */
    @GetMapping("/disableOrEnable")
    public AjaxResponse disableOrEnable(String Did,int Dstate){
        System.out.println(Did+"+Dsate:"+Dstate);
        BaseDepot baseDepot=new BaseDepot();
        baseDepot.setDepotId(Did);
        if(Dstate==0){
            baseDepot.setState(1);
        }
        if(Dstate==1){
            baseDepot.setState(0);
        }
        BaseDepot baseCustomer =baseDepotService.update(baseDepot);
        return  AjaxResponse.success(baseCustomer);
    };
}
