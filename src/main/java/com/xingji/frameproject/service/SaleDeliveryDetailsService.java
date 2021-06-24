package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.SaleDeliveryDetails;

import java.util.List;

/**
 * (SaleDeliveryDetails)表服务接口
 *
 * @author makejava
 * @since 2021-05-24 11:48:41
 */
public interface SaleDeliveryDetailsService {

    /**
     * 通过ID查询数据
     *
     * @param deliveryId
     * @return 实例对象
     */
    List<SaleDeliveryDetails> queryById(String deliveryId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SaleDeliveryDetails> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param saleDeliveryDetails 实例对象
     * @return 实例对象
     */
    SaleDeliveryDetails insert(SaleDeliveryDetails saleDeliveryDetails);

    /**
     * 新增多条数据
     *
     * @param saleDeliveryDetails 实例对象
     * @return 实例对象
     */
    List<SaleDeliveryDetails> insertBatch(List<SaleDeliveryDetails> saleDeliveryDetails);


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
