package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.BaseProduct;
import com.xingji.frameproject.vo.BaseProductVo;
import com.xingji.frameproject.vo.InventoryProjectVo;
import com.xingji.frameproject.vo.PurchaseProductVo;
import com.xingji.frameproject.vo.SaleProductVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BaseProduct)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-26 14:51:01
 */
@Mapper
public interface BaseProductDao {

    /**
     * 通过ID查询单条数据
     *
     * @param productSpec 主键
     * @return 实例对象
     */
    BaseProduct queryById(String productSpec);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseProduct> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseProduct 实例对象
     * @return 对象列表
     */
    List<BaseProduct> queryAll(BaseProduct baseProduct);

    /**
     * 新增数据
     *
     * @param baseProduct 实例对象
     * @return 影响行数
     */
    int insert(BaseProduct baseProduct);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseProduct> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BaseProduct> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseProduct> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<BaseProduct> entities);

    /**
     * 修改数据
     *
     * @param baseProduct 实例对象
     * @return 影响行数
     */
    int update(BaseProduct baseProduct);

    /**
     * 通过主键删除数据
     *
     * @param productSpec 主键
     * @return 影响行数
     */
    int deleteById(String productSpec);
    /**
     * 通过主键删除该产品库存数据
     *
     * @param productId 主键
     * @return 影响行数
     */
    int deleteOpingById(String productId);
    /**
     * 查询所有类别的产品
     */
    List<BaseProductVo> findAllProduct(BaseProductVo baseProductVo);
    /**
     * 查询所有销售的产品
     */
    List<SaleProductVo> allsaleproduct(SaleProductVo vo);
    /**
     * 查询所有采购的产品
     */
    List<PurchaseProductVo> allPurchaseProduct(@Param("vendorName")String vendorName,@Param("type") String type);

    /**
     * 查询所有的库存盘点商品
     * @return
     */
    List<InventoryProjectVo> allInventoryProject(@Param("depotName") String depotName,@Param("type") String type);
}

