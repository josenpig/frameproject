package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.SaleDelivery;
import com.xingji.frameproject.mybatis.dao.SaleDeliveryDao;
import com.xingji.frameproject.service.SaleDeliveryService;
import com.xingji.frameproject.vo.SaleConditionPageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SaleDelivery)表服务实现类
 *
 * @author makejava
 * @since 2021-05-24 11:46:18
 */
@Service("saleDeliveryService")
public class SaleDeliveryServiceImpl implements SaleDeliveryService {
    @Resource
    private SaleDeliveryDao saleDeliveryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param deliveryId 主键
     * @return 实例对象vo
     */
    @Override
    public SaleDelivery queryByIdVo(String deliveryId) {
        return this.saleDeliveryDao.queryByIdVo(deliveryId);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param deliveryId 主键
     * @return 实例对象
     */
    @Override
    public SaleDelivery queryById(String deliveryId) {
        return this.saleDeliveryDao.queryById(deliveryId);
    }
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SaleDelivery> queryAllByLimit(int offset, int limit) {
        return this.saleDeliveryDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<SaleDelivery> queryAll(SaleDelivery saleDelivery) {
        return this.saleDeliveryDao.queryAll(saleDelivery);
    }

    /**
     * 新增数据
     *
     * @param saleDelivery 实例对象
     * @return 实例对象
     */
    @Override
    public SaleDelivery insert(SaleDelivery saleDelivery) {
        this.saleDeliveryDao.insert(saleDelivery);
        return saleDelivery;
    }

    /**
     * 修改数据
     *
     * @param saleDelivery 实例对象
     * @return 实例对象
     */
    @Override
    public SaleDelivery update(SaleDelivery saleDelivery) {
        this.saleDeliveryDao.update(saleDelivery);
        return this.queryById(saleDelivery.getDeliveryId());
    }

    /**
     * 通过主键删除数据
     *
     * @param deliveryId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String deliveryId) {
        return this.saleDeliveryDao.deleteById(deliveryId) > 0;
    }
    /**
     * 查询可退换单据
     * @return 影响行数
     */
    @Override
    public List<SaleDelivery> canreturn() {
        return this.saleDeliveryDao.canreturn();
    }
    @Override
    //@Cacheable(cacheNames = "allsaleorder")
    public List<SaleDelivery> conditionpage(SaleConditionPageVo order) {
        return this.saleDeliveryDao.conditionpage(order);
    }
}
