package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.BaseProduct;
import com.xingji.frameproject.mybatis.dao.BaseProductDao;
import com.xingji.frameproject.vo.BaseProductVo;
import com.xingji.frameproject.service.BaseProductService;
import com.xingji.frameproject.vo.InventoryProjectVo;
import com.xingji.frameproject.vo.PurchaseProductVo;
import com.xingji.frameproject.vo.SaleProductVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BaseProduct)表服务实现类
 *
 * @author makejava
 * @since 2021-05-26 14:51:36
 */
@Service("baseProductService")
public class BaseProductServiceImpl implements BaseProductService {
    @Resource
    private BaseProductDao baseProductDao;

    /**
     * 通过ID查询单条数据
     *
     * @param productSpec 主键
     * @return 实例对象
     */
    @Override
    public BaseProduct queryById(String productSpec) {
        return this.baseProductDao.queryById(productSpec);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BaseProduct> queryAllByLimit(int offset, int limit) {
        return this.baseProductDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param baseProduct 实例对象
     * @return 实例对象
     */
    @Override
    public BaseProduct insert(BaseProduct baseProduct) {
        this.baseProductDao.insert(baseProduct);
        return baseProduct;
    }

    /**
     * 修改数据
     *
     * @param baseProduct 实例对象
     * @return 实例对象
     */
    @Override
    public BaseProduct update(BaseProduct baseProduct) {
        this.baseProductDao.update(baseProduct);
        return this.queryById(baseProduct.getProductSpec());
    }

    @Override
    public List<BaseProduct> queryAll(BaseProduct baseProduct) {
        return this.baseProductDao.queryAll(baseProduct);
    }

    /**
     * 通过主键删除数据
     *
     * @param productId  主键
     * @return 是否成功
     */
    @Override
    public String deleteById(String productId) {
        boolean pro=this.baseProductDao.deleteById(productId)>0?true:false;
        boolean open=this.baseProductDao.deleteOpingById(productId)>0?true:false;
        String receipt;
        if(pro==true && open==true){
            receipt="删除成功";
        }else{
            receipt="删除失败";
        }
        return receipt;
    }

    /**
     * 查询所有类别的产品
     */
    @Override
    public List<BaseProductVo> findAllProduct(BaseProductVo baseProductVo) {
        return this.baseProductDao.findAllProduct(baseProductVo);
    }
    /**
     * 查询所有销售的产品
     */
    @Override
    public List<SaleProductVo> allsaleproduct() {
        return this.baseProductDao.allsaleproduct();
    }
    /**
     * 查询所有的采购产品
     * @return
     */
    @Override
    public List<PurchaseProductVo> allPurchaseProduct() {
        return this.baseProductDao.allPurchaseProduct();
    }


    /**
     * 查询所有的库存盘点商品
     * @return
     */
    @Override
    public List<InventoryProjectVo> allStockInventoryProduct(String depotName) {
        return this.baseProductDao.allInventoryProject(depotName);
    }
}
