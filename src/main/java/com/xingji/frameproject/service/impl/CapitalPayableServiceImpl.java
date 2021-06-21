package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.CapitalPayable;
import com.xingji.frameproject.mybatis.dao.CapitalPayableDao;
import com.xingji.frameproject.service.CapitalPayableService;
import com.xingji.frameproject.vo.CapitalConditionPageVo;
import com.xingji.frameproject.vo.CiaBillVo;
import com.xingji.frameproject.vo.PurchaseCapitalVo;
import com.xingji.frameproject.vo.SaleReceiptVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CapitalPayable)表服务实现类
 *
 * @author makejava
 * @since 2021-06-17 15:23:44
 */
@Service("capitalPayableService")
public class CapitalPayableServiceImpl implements CapitalPayableService {
    @Resource
    private CapitalPayableDao capitalPayableDao;

    /**
     * 通过ID查询单条数据
     *
     * @param deliveryId 主键
     * @return 实例对象
     */
    @Override
    public CapitalPayable queryById(String deliveryId) {
        return this.capitalPayableDao.queryById(deliveryId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CapitalPayable> queryAllByLimit(int offset, int limit) {
        return this.capitalPayableDao.queryAllByLimit(offset, limit);
    }
    /**
     * 通过实体类条件查询
     *
     * @param vo 实例对象
     * @return 对象列表
     */
    @Override
    public List<CapitalPayable> queryAllByPage(CapitalConditionPageVo vo) {
        return this.capitalPayableDao.queryAllByPage(vo);
    }

    /**
     * 新增数据
     *
     * @param capitalPayable 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalPayable insert(CapitalPayable capitalPayable) {
        this.capitalPayableDao.insert(capitalPayable);
        return capitalPayable;
    }

    /**
     * 修改数据
     *
     * @param capitalPayable 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalPayable update(CapitalPayable capitalPayable) {
        this.capitalPayableDao.update(capitalPayable);
        return this.queryById(capitalPayable.getDeliveryId());
    }

    /**
     * 通过主键删除数据
     *
     * @param deliveryId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String deliveryId) {
        return this.capitalPayableDao.deleteById(deliveryId) > 0;
    }
    /**
     * 本次销售出库单收款--应收
     * @return 数据
     */
    @Override
    public PurchaseCapitalVo querythisPayment(String purchaseId) {
        return this.capitalPayableDao.querythisPayment(purchaseId);
    }
    /**
     * 通过实体类条件查询应付款单
     * @param vo 实体类
     * @return 影响行数
     */
    @Override
    public List<PurchaseCapitalVo> queryPayment(PurchaseCapitalVo vo) {
        return this.capitalPayableDao.queryPayment(vo);
    }
    /**
     * 修改已付金额数据
     *
     * @param capitalPayable 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalPayable receivedadd(CapitalPayable capitalPayable) {
        this.capitalPayableDao.paidadd(capitalPayable);
        return this.queryById(capitalPayable.getDeliveryId());
    }
    /**
     * 通过实体类条件查询核销单中的应收款单
     * @param vo 实体类
     * @return 影响行数
     */
    @Override
    public List<CiaBillVo> querycavPayment(CiaBillVo vo) {
        return this.capitalPayableDao.querycavPayment(vo);
    }
}
