package com.xingji.frameproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.mybatis.entity.*;
import com.xingji.frameproject.mybatis.entity.BaseProduct;
import com.xingji.frameproject.service.BaseDepotService;
import com.xingji.frameproject.service.BaseOpeningService;
import com.xingji.frameproject.service.BaseProductService;
import com.xingji.frameproject.service.SysUserService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import com.xingji.frameproject.vo.BaseProductVo;
import com.xingji.frameproject.vo.PurchaseProductVo;
import com.xingji.frameproject.vo.SaleProductVo;
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
        String recript=baseProductService.deleteById(id);
        return AjaxResponse.success(recript);
    };

    /**
     * 批量删除产品
     * @param ids 产品编号集合
     * @return
     */
    @DeleteMapping("/delProduct/batch")
    public AjaxResponse bacthDelProduct(@RequestBody List<String> ids){
        System.out.println("delList："+ids);
        List<String> retList= new ArrayList<String>();
        for(int i=0;i < ids.size();i++){
            String recript=baseProductService.deleteById(ids.get(i));
            retList.add(recript);
        }
        return AjaxResponse.success(retList);
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

    @PostMapping("/addProduct")
    public AjaxResponse addProduct(@RequestBody String add) {
        JSONObject jsonObject = JSONObject.parseObject(add);
        //添加产品
        String one = jsonObject.getString("Product");
        BaseProduct baseProduct = JSON.parseObject(one, BaseProduct.class);
        String user =jsonObject.getString("User");
        System.out.println(user);
        String user1=trimFirstAndLastChar(user,'"');
        System.out.println(user1);
        System.out.println(sysUserService.queryUserIdByUserName(user1));
        Integer userid=sysUserService.queryUserIdByUserName(user1);
        System.out.println("userID:"+userid);
        baseProduct.setUserId(userid);
        System.out.println("BaseProduct:"+baseProduct);
        BaseProduct baseProduct1 =baseProductService.insert(baseProduct);
        //添加库存
        String two = jsonObject.getString("Stock");
        List<BaseOpening> baseOpenings= JSONArray.parseArray(two, BaseOpening.class);
        System.out.println("BaseOpening:"+baseOpenings+",,,"+baseOpenings.size());
        for(int i=0;i<baseOpenings.size();i++){
            if(baseOpenings.get(i).getDepotName()!="" && baseOpenings.get(i).getOpeningNumber()!=null){
            Integer pon= baseOpenings.get(i).getOpeningNumber();
            baseOpenings.get(i).setExpectNumber(pon);
            baseOpenings.get(i).setProductNumber(pon);
            baseOpenings.get(i).setProductId(baseProduct.getProductId());
            BaseOpening baseOpening=baseOpeningService.insert(baseOpenings.get(i));
            }
        }
        System.out.println("BaseOpening++:"+baseOpenings);

        return  AjaxResponse.success(baseProduct1);
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
