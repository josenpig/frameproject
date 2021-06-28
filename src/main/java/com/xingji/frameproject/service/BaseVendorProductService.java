package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.BaseVendorProduct;
import com.xingji.frameproject.vo.BaseVendorProductVo;

import java.util.List;

/**
 * (BaseVendorProduct)表服务接口
 *
 * @author makejava
 * @since 2021-06-25 15:26:10
 */
public interface BaseVendorProductService {

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    BaseVendorProduct queryById(String vendorId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseVendorProduct> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param baseVendorProduct 实例对象
     * @return 实例对象
     */
    BaseVendorProduct insert(BaseVendorProduct baseVendorProduct);

    /**
     * 修改数据
     *
     * @param baseVendorProduct 实例对象
     * @return 实例对象
     */
    BaseVendorProduct update(BaseVendorProduct baseVendorProduct);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    boolean deleteById(String ProductId);

    /**
     * 通过BaseVendorProductVo作为筛选条件查询
     *
     * @param baseVendorProductVo 实例对象
     * @return 对象列表
     */
    List<BaseVendorProductVo> queryAllBaseVendorProductVo(BaseVendorProductVo baseVendorProductVo);


}
