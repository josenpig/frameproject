package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.CapitalReceivable;
import com.xingji.frameproject.mybatis.dao.CapitalReceivableDao;
import com.xingji.frameproject.service.CapitalReceivableService;
import com.xingji.frameproject.vo.SaleReceiptVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CapitalReceivable)表服务实现类
 *
 * @author makejava
 * @since 2021-06-01 11:26:58
 */
@Service("capitalReceivableService")
public class CapitalReceivableServiceImpl implements CapitalReceivableService {
    @Resource
    private CapitalReceivableDao capitalReceivableDao;

    /**
     * 通过ID查询单条数据
     *
     * @param deliveryId 主键
     * @return 实例对象
     */
    @Override
    public CapitalReceivable queryById(String deliveryId) {
        return this.capitalReceivableDao.queryById(deliveryId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CapitalReceivable> queryAllByLimit(int offset, int limit) {
        return this.capitalReceivableDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param capitalReceivable 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalReceivable insert(CapitalReceivable capitalReceivable) {
        this.capitalReceivableDao.insert(capitalReceivable);
        return capitalReceivable;
    }

    /**
     * 修改数据
     *
     * @param capitalReceivable 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalReceivable update(CapitalReceivable capitalReceivable) {
        this.capitalReceivableDao.update(capitalReceivable);
        return this.queryById(capitalReceivable.getDeliveryId());
    }

    /**
     * 通过主键删除数据
     *
     * @param deliveryId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String deliveryId) {
        return this.capitalReceivableDao.deleteById(deliveryId) > 0;
    }

    @Override
    public List<CapitalReceivable> queryAllByPage() {
        return this.capitalReceivableDao.queryAllByPage();
    }
    @Override
    public List<SaleReceiptVo> queryReceipt(SaleReceiptVo vo) {
        return this.capitalReceivableDao.queryReceipt(vo);
    }
    @Override
    public SaleReceiptVo querythisReceipt(String saleId) {
        return this.capitalReceivableDao.querythisReceipt(saleId);
    }

    @Override
    public CapitalReceivable receivedadd(CapitalReceivable capitalReceivable) {
        this.capitalReceivableDao.receivedadd(capitalReceivable);
        return this.queryById(capitalReceivable.getDeliveryId());
    }

}
