package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.CapitalReceipt;
import com.xingji.frameproject.mybatis.dao.CapitalReceiptDao;
import com.xingji.frameproject.service.CapitalReceiptService;
import com.xingji.frameproject.vo.CiaCapVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CapitalReceipt)表服务实现类
 *
 * @author makejava
 * @since 2021-06-02 20:20:48
 */
@Service("capitalReceiptService")
public class CapitalReceiptServiceImpl implements CapitalReceiptService {
    @Resource
    private CapitalReceiptDao capitalReceiptDao;

    /**
     * 通过ID查询单条数据
     *
     * @param receiptId 主键
     * @return 实例对象
     */
    @Override
    public CapitalReceipt queryById(String receiptId) {
        return this.capitalReceiptDao.queryById(receiptId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CapitalReceipt> queryAllByLimit(int offset, int limit) {
        return this.capitalReceiptDao.queryAllByLimit(offset, limit);
    }
    /**
     * 通过实体类条件查询多条数据
     *
     * @param capitalReceipt 实体类
     * @return 实例对象
     */
    @Override
    public List<CapitalReceipt> queryAll(CapitalReceipt capitalReceipt) {
        return this.capitalReceiptDao.queryAll(capitalReceipt);
    }

    /**
     * 新增数据
     *
     * @param capitalReceipt 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalReceipt insert(CapitalReceipt capitalReceipt) {
        this.capitalReceiptDao.insert(capitalReceipt);
        return capitalReceipt;
    }

    /**
     * 修改数据
     *
     * @param capitalReceipt 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalReceipt update(CapitalReceipt capitalReceipt) {
        this.capitalReceiptDao.update(capitalReceipt);
        return this.queryById(capitalReceipt.getReceiptId());
    }

    /**
     * 通过主键删除数据
     *
     * @param receiptId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String receiptId) {
        return this.capitalReceiptDao.deleteById(receiptId) > 0;
    }
    /**
     * 通过实体类条件查询核销单中的收款单
     * @param vo 实体类
     * @return 影响行数
     */
    @Override
    public List<CiaCapVo> querycavReceipt(CiaCapVo vo) {
        return this.capitalReceiptDao.querycavReceipt(vo);
    }
}
