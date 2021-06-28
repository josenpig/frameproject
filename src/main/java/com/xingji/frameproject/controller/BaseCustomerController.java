package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.service.*;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.CapitalConditionPageVo;
import io.lettuce.core.dynamic.annotation.Param;
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

    @Resource
    private SaleReturnService saleReturnService;//退货单
    @Resource
    private SaleOrderService saleOrderService;//收货单
    @Resource
    private SaleDeliveryService saleDeliveryService;//销售单
    @Resource
    private CapitalReceiptService capitalReceiptService;//收款单
    @Resource
    private CapitalCavCiaService capitalCavCiaService;//核销单

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
        List<BaseCustomer> list=baseCustomerService.findAllCustomer(baseCustomer);
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
        List<BaseCustomer> list=baseCustomerService.findAllCustomer(baseCustomer);
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
        List<BaseCustomer> list=baseCustomerService.findAllCustomer(baseCustomer);
        System.out.println(list);
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    };

    /**
     * 批量删除客户
     * @param ids 客户编号集合
     * @return
     */
    @DeleteMapping("/delCustomer/batch")
    public AjaxResponse bacthDelCustomer(@RequestBody List<String> ids){
        System.out.println("delList："+ids);
        String ret=null;
        Boolean del=false;
        List<String> retList= new ArrayList<String>();
        for(int i=0;i < ids.size();i++){
            //退货单
            SaleReturn saleReturn=new SaleReturn();
            saleReturn.setCustomer(ids.get(i));
            List<SaleReturn> list1=saleReturnService.queryAll(saleReturn);
            System.out.println("list1"+list1);

            //收货单
            SaleOrder saleOrder=new SaleOrder();
            saleOrder.setCustomer(ids.get(i));
            List<SaleOrder> list2=saleOrderService.queryAll(saleOrder);
            System.out.println("list2"+list2);

            //销售单
            SaleDelivery saleDelivery=new SaleDelivery();
            saleDelivery.setCustomer(ids.get(i));
            List<SaleDelivery> list3=saleDeliveryService.queryAll(saleDelivery);
            System.out.println("list3"+list3);

            //收款单
            CapitalConditionPageVo capitalReceipt=new CapitalConditionPageVo();
            capitalReceipt.setCustomer(ids.get(i));
            List<CapitalReceipt> list4=capitalReceiptService.queryAll(capitalReceipt);
            System.out.println("list4"+list4);

            //核销单
            CapitalCavCia capitalCavCia=new CapitalCavCia();
            capitalCavCia.setOtherParty(ids.get(i));
            List<CapitalCavCia> list5=capitalCavCiaService.queryAll(capitalCavCia);
            System.out.println("list5"+list5);

            if(list1.size()==0 && list2.size()==0 && list3.size()==0 && list4.size()==0 && list5.size()==0){
                retList.add(ids.get(i));
                del=true;
            }else{
                del=false;
                ret = "客户编号为："+ids.get(i)+"已存在相关单据记录，无法删除";
                break;
            }
            System.out.println("批量删除产品是否成功："+del);
        }
        if(del==true) {
            for (int i = 0; i < retList.size(); i++) {
                baseCustomerService.deleteById(retList.get(i));
            }
        }
        return AjaxResponse.success(ret);
    };

    /**
     * 判断客户Id是否重复
     * @param cid
     * @return
     */
    @GetMapping("/judgeCustomerId")
    public AjaxResponse judgeId(String cid){
        System.out.println("cid:"+cid);
        BaseCustomer baseCustomer =baseCustomerService.queryById(cid);
        Boolean result=false;
        if (baseCustomer==null){
            result=true;
        };
        return AjaxResponse.success(result);
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
