package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.CapitalPayment;
import com.xingji.frameproject.mybatis.dao.CapitalPaymentDao;
import com.xingji.frameproject.service.CapitalPaymentService;
import com.xingji.frameproject.vo.CiaCapVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CapitalPayment)表服务实现类
 *
 * @author makejava
 * @since 2021-06-16 19:14:13
 */
@Service("capitalPaymentService")
public class CapitalPaymentServiceImpl implements CapitalPaymentService {
    @Resource
    private CapitalPaymentDao capitalPaymentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param paymentId 主键
     * @return 实例对象
     */
    @Override
    public CapitalPayment queryById(String paymentId) {
        return this.capitalPaymentDao.queryById(paymentId);
    }
    /**
     * 通过实体作为筛选条件查询
     *
     * @param capitalPayment 实例对象
     * @return 对象列表
     */
    @Override
    public List<CapitalPayment> queryAll(CapitalPayment capitalPayment) {
        return this.capitalPaymentDao.queryAll(capitalPayment);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CapitalPayment> queryAllByLimit(int offset, int limit) {
        return this.capitalPaymentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param capitalPayment 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalPayment insert(CapitalPayment capitalPayment) {
        this.capitalPaymentDao.insert(capitalPayment);
        return capitalPayment;
    }

    /**
     * 修改数据
     *
     * @param capitalPayment 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalPayment update(CapitalPayment capitalPayment) {
        this.capitalPaymentDao.update(capitalPayment);
        return this.queryById(capitalPayment.getPaymentId());
    }

    /**
     * 通过主键删除数据
     *
     * @param paymentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String paymentId) {
        return this.capitalPaymentDao.deleteById(paymentId) > 0;
    }
    /**
     * 通过实体类条件查询核销单中的付款单
     * @param vo 实体类
     * @return 影响行数
     */
    @Override
    public List<CiaCapVo> querycavPayment(CiaCapVo vo) {
        return this.capitalPaymentDao.querycavPayment(vo);
    }
}
