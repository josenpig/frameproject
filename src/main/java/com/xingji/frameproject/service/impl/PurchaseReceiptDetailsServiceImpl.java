package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.PurchaseReceiptDetails;
import com.xingji.frameproject.mybatis.dao.PurchaseReceiptDetailsDao;
import com.xingji.frameproject.service.PurchaseReceiptDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PurchaseReceiptDetails)表服务实现类
 *
 * @author makejava
 * @since 2021-06-15 18:48:49
 */
@Service("purchaseReceiptDetailsService")
public class PurchaseReceiptDetailsServiceImpl implements PurchaseReceiptDetailsService {
    @Resource
    private PurchaseReceiptDetailsDao purchaseReceiptDetailsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PurchaseReceiptDetails queryById(Integer id) {
        return this.purchaseReceiptDetailsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<PurchaseReceiptDetails> queryAllByLimit(int offset, int limit) {
        return this.purchaseReceiptDetailsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param purchaseReceiptDetails 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseReceiptDetails insert(PurchaseReceiptDetails purchaseReceiptDetails) {
        this.purchaseReceiptDetailsDao.insert(purchaseReceiptDetails);
        return purchaseReceiptDetails;
    }

    /**
     * 修改数据
     *
     * @param purchaseReceiptDetails 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseReceiptDetails update(PurchaseReceiptDetails purchaseReceiptDetails) {
        this.purchaseReceiptDetailsDao.update(purchaseReceiptDetails);
        return this.queryById(purchaseReceiptDetails.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.purchaseReceiptDetailsDao.deleteById(id) > 0;
    }
}
