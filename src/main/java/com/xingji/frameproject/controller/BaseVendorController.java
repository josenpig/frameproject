package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.annotation.Log;
import com.xingji.frameproject.mybatis.entity.BaseVendor;
import com.xingji.frameproject.mybatis.entity.CapitalPayable;
import com.xingji.frameproject.mybatis.entity.CapitalPayment;
import com.xingji.frameproject.mybatis.entity.PurchaseOrder;
import com.xingji.frameproject.service.BaseVendorService;
import com.xingji.frameproject.service.CapitalPayableService;
import com.xingji.frameproject.service.CapitalPaymentService;
import com.xingji.frameproject.service.PurchaseOrderService;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.CapitalConditionPageVo;
import com.xingji.frameproject.vo.form.PurchaseOrderQueryForm;
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
    @Resource
    private CapitalPayableService capitalPayableService;//采购应付单
    @Resource
    private CapitalPaymentService capitalPaymentService;//采购应付单
    @Resource
    private PurchaseOrderService purchaseOrderService;//采购单

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Log("查询单个供应商")
    @GetMapping("selectOne")
    public BaseVendor selectOne(String id) {
        return this.baseVendorService.queryById(id);
    }

    /**
     * 查询所有供应商信息
     * @return 产品集合
     */
    @Log("查询所有供应商信息")
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
    @Log("查询所有供应商 返回list")
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
    @Log("根据供应商类型或负责人查询的供应商")
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
    @Log("根据供应商编号或供应商名称查询的供应商")
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
     * 批量删除供应商
     * @param ids 供应商编号集合
     * @return
     */
    @Log("批量删除供应商")
    @DeleteMapping("/delVendor/batch")
    public AjaxResponse bacthDelVendor(@RequestBody List<String> ids){
        System.out.println("delList："+ids);
        String ret=null;
        Boolean del=false;
        List<String> retList= new ArrayList<String>();
        for(int i=0;i < ids.size();i++){
            //采购应付单
            CapitalConditionPageVo capitalPayable=new CapitalConditionPageVo();
            capitalPayable.setVendor(ids.get(i));
            List<CapitalPayable> list1=capitalPayableService.queryAllByPage(capitalPayable);
            System.out.println("list1"+list1);

            //采购应付单
            CapitalConditionPageVo capitalPayment=new CapitalConditionPageVo();
            capitalPayment.setVendor(ids.get(i));
            List<CapitalPayment> list2=capitalPaymentService.queryAll(capitalPayment);
            System.out.println("list2"+list2);

            //采购单
            PurchaseOrder purchaseOrder=new PurchaseOrder();
            purchaseOrder.setVendorName(ids.get(i));
            List<PurchaseOrder> list3=purchaseOrderService.queryOfPurchaseOrder(purchaseOrder);
            System.out.println("list3"+list3);

            if(list1.size()==0 && list2.size()==0 && list3.size()==0){
                retList.add(ids.get(i));
                del=true;
            }else{
                del=false;
                ret = "供应商编号为："+ids.get(i)+"已存在相关单据记录，无法删除";
                break;
            }
        }
        if(del==true) {
            for (int i = 0; i < retList.size(); i++) {
                baseVendorService.deleteById(retList.get(i));
            }
        }
        return AjaxResponse.success(ret);
    };

    /**
     * 判断供应商Id是否重复
     * @param id
     * @return
     */
    @Log("判断供应商Id是否重复")
    @GetMapping("/judgeVendorId")
    public AjaxResponse judgeId(String id){
        System.out.println("id:"+id);
        BaseVendor baseCustomer =baseVendorService.queryById(id);
        Boolean result=false;
        if (baseCustomer==null){
            result=true;
        };
        return AjaxResponse.success(result);
    };
    /**
     * 新增供应商
     * @param add
     * @return
     */
    @Log("新增供应商")
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
    @Log("修改供应商")
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
