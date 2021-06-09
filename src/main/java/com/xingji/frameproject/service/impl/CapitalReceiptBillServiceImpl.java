package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.CapitalReceiptBill;
import com.xingji.frameproject.mybatis.dao.CapitalReceiptBillDao;
import com.xingji.frameproject.service.CapitalReceiptBillService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CapitalReceiptBill)表服务实现类
 *
 * @author makejava
 * @since 2021-06-02 20:22:26
 */
@Service("capitalReceiptBillService")
public class CapitalReceiptBillServiceImpl implements CapitalReceiptBillService {
    @Resource
    private CapitalReceiptBillDao capitalReceiptBillDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public List<CapitalReceiptBill> queryById(String id) {
        return this.capitalReceiptBillDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CapitalReceiptBill> queryAllByLimit(int offset, int limit) {
        return this.capitalReceiptBillDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param capitalReceiptBill 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalReceiptBill insert(CapitalReceiptBill capitalReceiptBill) {
        this.capitalReceiptBillDao.insert(capitalReceiptBill);
        return capitalReceiptBill;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.capitalReceiptBillDao.deleteById(id) > 0;
    }
    /**
     * 新增多条数据
     *
     * @param capitalReceiptBill 实例对象
     * @return 实例对象
     */
    @Override
    public List<CapitalReceiptBill> insertBatch(List<CapitalReceiptBill> capitalReceiptBill) {
        this.capitalReceiptBillDao.insertBatch(capitalReceiptBill);
        return capitalReceiptBill;
    }
    @Override
    public boolean update(CapitalReceiptBill capitalReceiptBill) {
        return this.capitalReceiptBillDao.update(capitalReceiptBill)>0;
    }

}
