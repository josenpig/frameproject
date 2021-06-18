package com.xingji.frameproject.service.impl;


import com.xingji.frameproject.mybatis.dao.PurchaseReturnsDao;
import com.xingji.frameproject.mybatis.entity.PurchaseReturns;
import com.xingji.frameproject.service.PurchaseReturnsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PurchaseReturns)表服务实现类
 *
 * @author makejava
 * @since 2021-06-18 01:13:56
 */
@Service("purchaseReturnsService")
public class PurchaseReturnsServiceImpl implements PurchaseReturnsService {
    @Resource
    private PurchaseReturnsDao purchaseReturnsDao;


    @Override
    public PurchaseReturns queryById(String id) {
        return null;
    }

    @Override
    public List<PurchaseReturns> queryAllByLimit(int offset, int limit) {
        return null;
    }


    /**
     * 新增数据
     *
     * @param purchaseReturns 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseReturns insert(PurchaseReturns purchaseReturns) {
        this.purchaseReturnsDao.insert(purchaseReturns);
        return purchaseReturns;
    }

    /**
     * 修改数据
     *
     * @param purchaseReturns 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseReturns update(PurchaseReturns purchaseReturns) {
        this.purchaseReturnsDao.update(purchaseReturns);
        return this.queryById(purchaseReturns.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.purchaseReturnsDao.deleteById(id) > 0;
    }

    @Override
    public List<PurchaseReturns> findReturn() {
        return purchaseReturnsDao.selectAll();
    }
}
