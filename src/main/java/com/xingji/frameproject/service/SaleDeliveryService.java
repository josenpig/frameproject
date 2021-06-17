package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.SaleDelivery;
import com.xingji.frameproject.vo.SaleConditionPageVo;

import java.util.List;

/**
 * (SaleDelivery)表服务接口
 *
 * @author makejava
 * @since 2021-05-24 11:46:18
 */
public interface SaleDeliveryService {

    /**
     * 通过ID查询单条数据
     *
     * @param deliveryId 主键
     * @return 实例对象
     */
    SaleDelivery queryById(String deliveryId);
    /**
     * 通过ID查询单条数据
     *
     * @param deliveryId 主键
     * @return 实例对象vo
     */
    SaleDelivery queryByIdVo(String deliveryId);
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SaleDelivery> queryAllByLimit(int offset, int limit);
    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<SaleDelivery> queryAll(SaleDelivery saleDelivery);

    /**
     * 新增数据
     *
     * @param saleDelivery 实例对象
     * @return 实例对象
     */
    SaleDelivery insert(SaleDelivery saleDelivery);

    /**
     * 修改数据
     *
     * @param saleDelivery 实例对象
     * @return 实例对象
     */
    SaleDelivery update(SaleDelivery saleDelivery);

    /**
     * 通过主键删除数据
     *
     * @param deliveryId 主键
     * @return 是否成功
     */
    boolean deleteById(String deliveryId);

    List<SaleDelivery> canreturn();

    //@Cacheable(cacheNames = "allsaleorder")
    List<SaleDelivery> conditionpage(SaleConditionPageVo order);
}
