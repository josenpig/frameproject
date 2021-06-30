package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.CapitalPaymentBill;
import com.xingji.frameproject.mybatis.dao.CapitalPaymentBillDao;
import com.xingji.frameproject.service.CapitalPaymentBillService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CapitalPaymentBill)表服务实现类
 *
 * @author makejava
 * @since 2021-06-16 19:13:55
 */
@Service("capitalPaymentBillService")
public class CapitalPaymentBillServiceImpl implements CapitalPaymentBillService {
    @Resource
    private CapitalPaymentBillDao capitalPaymentBillDao;

    /**
     * 通过ID查询多条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public List<CapitalPaymentBill> queryById(String id) {
        return this.capitalPaymentBillDao.queryById(id);
    }
    /**
     * 通过ID查询关联单据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public List<CapitalPaymentBill> relation(String id) {
        return this.capitalPaymentBillDao.relation(id);
    }
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CapitalPaymentBill> queryAllByLimit(int offset, int limit) {
        return this.capitalPaymentBillDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param capitalPaymentBill 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalPaymentBill insert(CapitalPaymentBill capitalPaymentBill) {
        this.capitalPaymentBillDao.insert(capitalPaymentBill);
        return capitalPaymentBill;
    }
    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param capitalPaymentBill List<CapitalPaymentBill> 实例对象列表
     * @return 影响行数
     */
    @Override
    public List<CapitalPaymentBill> insertBatch(List<CapitalPaymentBill> capitalPaymentBill) {
        this.capitalPaymentBillDao.insertBatch(capitalPaymentBill);
        return capitalPaymentBill;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.capitalPaymentBillDao.deleteById(id) > 0;
    }
}
