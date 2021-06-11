package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.BaseProduct;
import com.xingji.frameproject.vo.BaseProductVo;
import com.xingji.frameproject.vo.InventoryProjectVo;
import com.xingji.frameproject.vo.PurchaseProductVo;
import com.xingji.frameproject.vo.SaleProductVo;

import java.util.List;

/**
 * (BaseProduct)表服务接口
 *
 * @author makejava
 * @since 2021-05-26 14:51:36
 */
public interface BaseProductService {

    /**
     * 通过ID查询单条数据
     *
     * @param productSpec 主键
     * @return 实例对象
     */
    BaseProduct queryById(String productSpec);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseProduct> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param baseProduct 实例对象
     * @return 实例对象
     */
    BaseProduct insert(BaseProduct baseProduct);

    /**
     * 修改数据
     *
     * @param baseProduct 实例对象
     * @return 实例对象
     */
    BaseProduct update(BaseProduct baseProduct);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseProduct 实例对象
     * @return 对象列表
     */
    List<BaseProduct> queryAll(BaseProduct baseProduct);

    /**
     * 通过主键删除产品数据
     *
     * @param productId 主键
     * @return 是否成功
     */
    String deleteById(String productId);

    /**
     * 查询所有类别的产品
     */
    List<BaseProductVo> findAllProduct(BaseProductVo baseProductVo);
    /**
     * 查询所有销售的产品
     */
    List<SaleProductVo> allsaleproduct();
    /**
     * 查询所有的采购产品
     * @return
     */
    List<PurchaseProductVo> allPurchaseProduct();

    /**
     * 查询所有的库存盘点产品信息
     * @return
     */
    List<InventoryProjectVo> allStockInventoryProduct(String depotName);
}
