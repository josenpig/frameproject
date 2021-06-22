package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.mybatis.entity.BaseProduct;
import com.xingji.frameproject.service.*;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.BaseProductVo;
import com.xingji.frameproject.vo.PurchaseProductVo;
import com.xingji.frameproject.vo.SaleProductVo;
import com.xingji.frameproject.vo.form.PurchaseOrderDetailsQueryForm;
import com.xingji.frameproject.vo.form.StockInventoryDetailsQueryForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * (BaseProduct)表控制层
 *
 * @author makejava
 * @since 2021-05-26 14:51:36
 */
@RestController
@RequestMapping("baseProduct")
public class BaseProductController {
    /**
     * 服务对象
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private BaseProductService baseProductService;
    @Resource
    private BaseOpeningService baseOpeningService;
    @Resource
    private BaseDepotService baseDepotService;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private PurchaseOrderDetailsService purchaseOrderDetailsService;
    @Resource
    private StockInventoryDetailsService stockInventoryDetailsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BaseProduct selectOne(String id) {
        return this.baseProductService.queryById(id);
    }

    /**
     * 查询所有销售产品
     * @return 产品集合
     */
    @GetMapping("/allsaleproduct")
    public AjaxResponse findAllsaleproduct(Integer currentPage, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<SaleProductVo> SaleProductVo=baseProductService.allsaleproduct();
        for(SaleProductVo product:SaleProductVo){
            product.setBaseOpenings(baseOpeningService.finddepot(product.getProductId()));
        }
        map.put("total",page.getTotal());
        map.put("rows",SaleProductVo);
        return AjaxResponse.success(map);
    };

    /**
     * 查询所有采购的产品
     * @return 产品集合
     */
    @GetMapping("/allpurchaseproduct")
    public AjaxResponse findAllPurchaseProduct(Integer currentPage, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        List<PurchaseProductVo> purchaseProductVos=baseProductService.allPurchaseProduct();
        for(PurchaseProductVo product:purchaseProductVos){
            product.setBaseDepots(baseDepotService.findAll());
            product.getBaseDepots();
        }
        map.put("total",page.getTotal());
        map.put("rows",purchaseProductVos);
        return AjaxResponse.success(map);
    };

    /**
     * 查询所有类别的产品
     * @return 产品集合
     */
    @GetMapping("/findAllProduct")
    public AjaxResponse findAllProduct(Integer currentPage, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        System.out.println(currentPage+","+pageSize);
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        BaseProductVo baseProductVo=new BaseProductVo();
        List<BaseProductVo> productShowList=baseProductService.findAllProduct(baseProductVo);
        System.out.println(productShowList);
        map.put("total",page.getTotal());
        map.put("rows",productShowList);
        return AjaxResponse.success(map);
    };

    /**
     * 根据产品id或产品名称查询的产品
     * @return 产品集合
     */
    @GetMapping("/findAllProduct/ByIdOrName")
    public AjaxResponse findAllProductByIdOrName(@Param("currentPage")Integer currentPage, @Param("pageSize") Integer pageSize, @Param("select") String select, @Param("SearchContent") String SearchContent){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        BaseProductVo baseProductVo = new BaseProductVo();
        System.out.println(select+",,,"+SearchContent);
        if (select.equals("产品名称")){
            baseProductVo.setProductName(SearchContent);
        };
        if (select.equals("产品编号")){
            baseProductVo.setProductId(SearchContent);
        };
        List<BaseProductVo> productShowList=baseProductService.findAllProduct(baseProductVo);
        System.out.println(productShowList);
        map.put("total",page.getTotal());
        map.put("rows",productShowList);
        return AjaxResponse.success(map);
    };

    /**
     * 删除产品
     * @param id 产品编号
     * @return
     */
    @GetMapping("/delProduct")
    public AjaxResponse delProduct(String id){
        System.out.println("del:"+id);
        //根据产品Id查询采购单
        PurchaseOrderDetailsQueryForm purchaseOrderDetailsQueryForm=new PurchaseOrderDetailsQueryForm();
        purchaseOrderDetailsQueryForm.setProductId(id);
        List<PurchaseOrderDetails> list =purchaseOrderDetailsService.queryAndByPojo(purchaseOrderDetailsQueryForm);
        System.out.println(list);
        //根据产品id查询盘点单
        StockInventoryDetailsQueryForm stockInventoryDetails=new StockInventoryDetailsQueryForm();
        stockInventoryDetails.setProductId(id);
        List<StockInventoryDetails> list2=stockInventoryDetailsService.queryAndByPojo(stockInventoryDetails);
        System.out.println(list2);
        Boolean del=false;
        if(list.size()==0 && list2.size()==0){
            del=baseProductService.deleteById(id);
        }
        System.out.println("删除是否成功："+del);
        return AjaxResponse.success(del);
    };

    /**
     * 批量删除产品
     * @param ids 产品编号集合
     * @return
     */
    @DeleteMapping("/delProduct/batch")
    public AjaxResponse bacthDelProduct(@RequestBody List<String> ids){
        System.out.println("delList："+ids);
        String ret=null;
        for(int i=0;i < ids.size();i++){
            //根据产品Id查询采购单
            PurchaseOrderDetailsQueryForm purchaseOrderDetailsQueryForm=new PurchaseOrderDetailsQueryForm();
            purchaseOrderDetailsQueryForm.setProductId(ids.get(i));
            List<PurchaseOrderDetails> list =purchaseOrderDetailsService.queryAndByPojo(purchaseOrderDetailsQueryForm);
            System.out.println(list);
            //根据产品id查询盘点单
            StockInventoryDetailsQueryForm stockInventoryDetails=new StockInventoryDetailsQueryForm();
            stockInventoryDetails.setProductId(ids.get(i));
            List<StockInventoryDetails> list2=stockInventoryDetailsService.queryAndByPojo(stockInventoryDetails);
            System.out.println(list2);
            Boolean del=false;
            if(list.size()==0 && list2.size()==0){
                del=baseProductService.deleteById(ids.get(i));
            }
            System.out.println("删除是否成功："+del);
            if(del==false){
                ret = "产品编号为："+ids.get(i)+"已存在相关单据记录，无法删除";
                break;
            }
        }
        return AjaxResponse.success(ret);
    };

    /**
     * 禁用或启用
     * @param Did,Dstate
     * @return
     */
    @GetMapping("/disableOrEnable")
    public AjaxResponse disableOrEnable(String Did,int Dstate){
        System.out.println(Did+"+Dsate:"+Dstate);
        BaseProduct baseProduct=new BaseProduct();
        baseProduct.setProductId(Did);
        if(Dstate==0){
            baseProduct.setState(1);
        }
        if(Dstate==1){
            baseProduct.setState(0);
        }
        BaseProduct baseProduct1 =baseProductService.update(baseProduct);
        return  AjaxResponse.success(baseProduct1);
    };

    /**
     * 根据产品分类的产品
     * @return 产品集合
     */
    @GetMapping("/findAllProduct/ByTpye")
    public AjaxResponse findAllProductByTpye(@Param("currentPage")Integer currentPage, @Param("pageSize") Integer pageSize, @Param("id") Integer id){
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pageSize);
        BaseProductVo baseProductVo = new BaseProductVo();
        System.out.println("typeID:"+id);
        baseProductVo.setProductTypeId(id);

        List<BaseProductVo> productShowList=baseProductService.findAllProduct(baseProductVo);
        System.out.println(productShowList);
        map.put("total",page.getTotal());
        map.put("rows",productShowList);
        return AjaxResponse.success(map);
    };

    /**
     * 判断产品Id是否重复
     * @param id
     * @return
     */
    @GetMapping("/judgeProductId")
    public Boolean judgeId(String id){
        System.out.println("id:"+id);
        BaseProduct baseProduct =baseProductService.queryById(id);
        Boolean result=false;
        if (baseProduct==null){
            result=true;
        };
        return result;
    };

    /**
     * 添加产品
     * @param add
     * @return
     */
    @PostMapping("/addProduct")
    public AjaxResponse addProduct(@RequestBody String add) {
        JSONObject jsonObject = JSONObject.parseObject(add);
        //添加产品
        String one = jsonObject.getString("Product");
        BaseProduct baseProduct = JSON.parseObject(one, BaseProduct.class);
        String user =jsonObject.getString("User");
        String user1=trimFirstAndLastChar(user,'"');
        System.out.println(sysUserService.queryUserIdByUserName(user1));
        Integer userid=sysUserService.queryUserIdByUserName(user1);
        baseProduct.setUserId(userid);
        System.out.println("BaseProduct:"+baseProduct);
        BaseProduct baseProduct1 =baseProductService.insert(baseProduct);
        //添加库存
        String two = jsonObject.getString("Stock");
        List<BaseOpening> baseOpenings= JSONArray.parseArray(two, BaseOpening.class);
        String n=null;
        for(int i=0;i<baseOpenings.size();i++){
            if(baseOpenings.get(i).getDepotName()!=null && baseOpenings.get(i).getDepotName()!="" && !baseOpenings.get(i).getDepotName().equals(n) && !baseOpenings.get(i).getDepotName().equals("")){
            Integer pon= baseOpenings.get(i).getOpeningNumber();
            baseOpenings.get(i).setExpectNumber(pon);
            baseOpenings.get(i).setProductNumber(pon);
            baseOpenings.get(i).setProductId(baseProduct.getProductId());
            BaseOpening baseOpening=baseOpeningService.insert(baseOpenings.get(i));
            }
        }
        System.out.println("BaseOpening++:"+baseOpenings+",,,"+baseOpenings.size());

        return  AjaxResponse.success(baseProduct1);
    };

    /**
     * 修改产品
     * @param add
     * @return
     */
    @RequestMapping("/updateProduct")
    public AjaxResponse updateProduct(@RequestBody String add){
        System.out.println(add);
        JSONObject jsonObject = JSONObject.parseObject(add);
        String one = jsonObject.getString("Product");
        BaseProduct product = JSON.parseObject(one, BaseProduct.class);
        //获取最初产品信息 如果新的产品信息和旧的不同则更新数据
        BaseProduct after= baseProductService.queryById(product.getProductId());
        BaseProduct newc=new BaseProduct();
        if(after.getProductName().equals(product.getProductName()) && after.getIngredient().equals(product.getIngredient()) &&  after.getProductSpec().equals(product.getProductSpec()) &&  Double.doubleToLongBits(after.getPurchaseMoney())==Double.doubleToLongBits(product.getPurchaseMoney()) &&  Double.doubleToLongBits(after.getPurchaseUnitPrice())==Double.doubleToLongBits(product.getPurchaseUnitPrice()) &&  after.getRemarks().equals(product.getRemarks()) &&  after.getProductDescribe().equals(product.getProductDescribe())
        ){
            newc = after;
        }else{
            product.setUpdateTime(new Date());
            newc = baseProductService.update(product);
        };
        return AjaxResponse.success(newc);
    };
    
    /**
     * 去除指定字符
     * @param source
     * @param element
     * @return
     */
    public static String trimFirstAndLastChar(String source,char element){
                boolean beginIndexFlag = true;
                boolean endIndexFlag = true;
           do{ int beginIndex = source.indexOf(element) == 0 ? 1 : 0;
                        int endIndex = source.lastIndexOf(element) + 1 == source.length() ? source.lastIndexOf(element) : source.length();
                        source = source.substring(beginIndex, endIndex);
                        beginIndexFlag = (source.indexOf(element) == 0);
                        endIndexFlag = (source.lastIndexOf(element) + 1 == source.length());
                    } while (beginIndexFlag || endIndexFlag);
                return source;
            }
}
