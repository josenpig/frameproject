package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.SaleOrder;
import com.xingji.frameproject.mybatis.dao.SaleOrderDao;
import com.xingji.frameproject.service.SaleOrderService;
import com.xingji.frameproject.vo.SaleConditionPageVo;
import com.xingji.frameproject.vo.SaleReceiptVo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SaleOrder)表服务实现类
 *
 * @author makejava
 * @since 2021-05-20 19:04:20
 */
@Service("saleOrderService")
public class SaleOrderServiceImpl implements SaleOrderService {
    @Resource
    private SaleOrderDao saleOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    @Override
    public SaleOrder queryById(String orderId) {
        return this.saleOrderDao.queryById(orderId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SaleOrder> queryAllByLimit(int offset, int limit) {
        return this.saleOrderDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<SaleOrder> queryAll(SaleOrder saleOrder) {
        return this.saleOrderDao.queryAll(saleOrder);
    }

    /**
     * 新增数据
     *
     * @param saleOrder 实例对象
     * @return 实例对象
     */
    @Override
    public SaleOrder insert(SaleOrder saleOrder) {
        this.saleOrderDao.insert(saleOrder);
        return saleOrder;
    }

    /**
     * 修改数据
     *
     * @param saleOrder 实例对象
     * @return 实例对象
     */
    @Override
    public SaleOrder update(SaleOrder saleOrder) {
        this.saleOrderDao.update(saleOrder);
        return this.queryById(saleOrder.getOrderId());
    }

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String orderId) {
        return this.saleOrderDao.deleteById(orderId) > 0;
    }
    @Override
    //@Cacheable(cacheNames = "allsaleorder")
    public List<SaleOrder> conditionpage(SaleConditionPageVo order) {
        return this.saleOrderDao.conditionpage(order);
    }
    @Override
    public List<SaleReceiptVo> queryReceipt(SaleReceiptVo vo) {
        return this.saleOrderDao.queryReceipt(vo);
    }
    @Override
    public SaleReceiptVo querythisReceipt(String saleId) {
        return this.saleOrderDao.querythisReceipt(saleId);
    }

    @Override
    public boolean advanceadd(SaleOrder saleOrder) {
        return this.saleOrderDao.advanceadd(saleOrder);
    }
}
