package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.*;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (CapitalCavCia)表控制层
 *
 * @author makejava
 * @since 2021-06-08 20:42:07
 */
@RestController
@RequestMapping("/capitalCavCia")
public class CapitalCavCiaController {
    /**
     * 服务对象
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private CapitalCavCiaService cccs;
    @Resource
    private CapitalCavCiaBillService cccbs;
    @Resource
    private CapitalCavCiaCapService ccccs;
    @Resource
    private CapitalReceivableService crbs;
    @Resource
    private CapitalReceiptService crs;

    /**
     * 通过主键查询核销单及核销单详情
     * @param id 主键
     * @return 数据
     */
    @GetMapping("/find/{id}")
    public AjaxResponse selectOne(@PathVariable("id") String id) {
        CapitalCavCia order=cccs.queryById(id);
        List<CapitalCavCiaBill> bills=cccbs.queryById(id);
        List<CapitalCavCiaCap> caps=ccccs.queryById(id);
        CiaVo vo=new CiaVo();
        vo.setOrder(order);
        vo.setBills(bills);
        vo.setCaps(caps);
        return AjaxResponse.success(vo);
    }
    /**
     * 核销单应收款分页条件查询
     * @param conditionpage 条件查询信息
     * @return map数据
     */
    @PostMapping("/receivablepage")
    public AjaxResponse receivablepage(@RequestBody String conditionpage){
        JSONObject jsonObject = JSONObject.parseObject(conditionpage);
        String condition = jsonObject.getString("condition");//查询条件--实体类
        CiaBillVo vo= JSON.parseObject(condition, CiaBillVo.class);
        int currentPage = Integer.parseInt(jsonObject.getString("currentPage"));
        int pageSize = Integer.parseInt(jsonObject.getString("pageSize"));
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<CiaBillVo> list=crbs.querycavReceipt(vo);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    /**
     * 核销单收款单据分页条件查询
     * @param conditionpage 条件查询信息
     * @return map数据
     */
    @PostMapping("/receiptpage")
    public AjaxResponse receiptpage(@RequestBody String conditionpage){
        JSONObject jsonObject = JSONObject.parseObject(conditionpage);
        String condition = jsonObject.getString("condition");//查询条件--实体类
        CiaCapVo vo= JSON.parseObject(condition, CiaCapVo.class);
        int currentPage = Integer.parseInt(jsonObject.getString("currentPage"));
        int pageSize = Integer.parseInt(jsonObject.getString("pageSize"));
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<CiaCapVo> list=crs.querycavReceipt(vo);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    @PostMapping("/add/{type}")
    public AjaxResponse addreceipt(@PathVariable("type") int type,@RequestBody String add) {
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("order");
        CapitalCavCia cia = JSON.parseObject(one, CapitalCavCia.class);
        String two = jsonObject.getString("bill");
        List<CapitalCavCiaBill> bills= JSONArray.parseArray(two, CapitalCavCiaBill.class);
        String three = jsonObject.getString("cap");
        List<CapitalCavCiaCap> caps= JSONArray.parseArray(three, CapitalCavCiaCap.class);
        cia.setApprovalState(type);
        cia.setFoundTime(new Date());
        cia.setUpdateTime(new Date());
        //添加核销单应收单据列表信息
        for(int i=0;i<bills.size();i++){
            bills.get(i).setCavId(cia.getCavId());
        }
        //添加核销单收单据列表信息
        for(int i=0;i<caps.size();i++){
            caps.get(i).setCavId(cia.getCavId());
        }
        cccs.insert(cia);
        cccbs.insertBatch(bills);
        ccccs.insertBatch(caps);
        return AjaxResponse.success(cia.getCavId());
    }
    /**
     * 分页条件查询
     * @param conditionpage 条件查询信息
     * @return map数据
     */
    @PostMapping("/conditionpage")
    public AjaxResponse conditionpage(@RequestBody String conditionpage) {
        JSONObject jsonObject = JSONObject.parseObject(conditionpage);
        String condition = jsonObject.getString("condition");//查询条件
        CapitalCavCia order =JSON.parseObject(condition, CapitalCavCia.class);
        int currentPage = Integer.parseInt(jsonObject.getString("currentPage"));
        int pageSize = Integer.parseInt(jsonObject.getString("pageSize"));
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<CapitalCavCia> list=cccs.queryAll(order);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    /**
     * 修改订单审批状态
     * @param orderid 主键
     * @return 数据
     */
    @GetMapping("/approval")
    public AjaxResponse approvalorder(String orderid,int type,String user,String approvalremarks){
        CapitalCavCia tf=cccs.queryById(orderid);
        if(type==1 && tf.getCavType().equals("预收冲应收")){
            List<CapitalCavCiaBill> bills=cccbs.queryById(orderid);
            for (int i=0;i<bills.size();i++) {
                CapitalReceivable receivable = crbs.queryById(bills.get(i).getSaleId());
                if (receivable.getCaseState()==1){
                    return AjaxResponse.success("订单："+receivable.getDeliveryId()+"已结案");
                }
            }
            List<CapitalCavCiaCap> caps=ccccs.queryById(orderid);
            for (int i=0;i<bills.size();i++) {
                CapitalReceipt receipt = crs.queryById(caps.get(i).getCapitalId());
                if (receipt.getCiaBalance()==0){
                    return AjaxResponse.success("订单："+receipt.getReceiptId()+"预收余额不足");
                }
            }
        }
        //修改收款单信息
        CapitalCavCia cia=new CapitalCavCia();
        cia.setCavId(orderid);
        cia.setApprovalState(type);
        cia.setApprover(user);
        cia.setApprovalRemarks(approvalremarks);
        cia.setLastApprovalTime(new Date());
        cia.setUpdateTime(new Date());
        CapitalCavCia cianew=cccs.update(cia);
        if(type == 1 && cianew.getCavType().equals("预收冲应收")){
            //订单通过修改单据已收款
            List<CapitalCavCiaBill> bills=cccbs.queryById(cianew.getCavId());
            for (int i=0;i<bills.size();i++) {
                //修改应收款单据的已收款金额
                CapitalReceivable receivable=crbs.queryById(bills.get(i).getSaleId());
                receivable.setReceived(receivable.getReceived()+bills.get(i).getThisMoney());
                receivable.setUncollected(receivable.getUncollected()-bills.get(i).getThisMoney());
                CapitalReceivable receivablenew=crbs.update(receivable);
                if (receivablenew.getUncollected()==0){
                    receivablenew.setCaseState(1);
                    crbs.update(receivablenew);
                }
            }
            //订单通过增加账户资金
            List<CapitalCavCiaCap> caps=ccccs.queryById(cianew.getCavId());
            for (int j=0;j<caps.size();j++) {
                //修改收款单据的预收余额
                CapitalReceipt receipt=crs.queryById(caps.get(j).getCapitalId());
                receipt.setCiaBalance(receipt.getCiaBalance()-caps.get(j).getThisMoney());
                crs.update(receipt);
            }
        }
        return AjaxResponse.success(true);
    }
}
