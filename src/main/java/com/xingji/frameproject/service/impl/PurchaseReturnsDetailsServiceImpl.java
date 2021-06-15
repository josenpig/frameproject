package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.dao.PurchaseReturnsDetailsDao;
import com.xingji.frameproject.mybatis.entity.PurchaseReturnsDetails;
import com.xingji.frameproject.service.PurchaseReturnsDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PurchaseReturnsDetails)表服务实现类
 *
 * @author makejava
 * @since 2021-06-15 18:49:12
 */
@Service("purchaseReturnsDetailsService")
public class PurchaseReturnsDetailsServiceImpl implements PurchaseReturnsDetailsService {
    @Resource
    private PurchaseReturnsDetailsDao purchaseReturnsDetailsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PurchaseReturnsDetails queryById(Integer id) {
        return this.purchaseReturnsDetailsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<PurchaseReturnsDetails> queryAllByLimit(int offset, int limit) {
        return this.purchaseReturnsDetailsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param purchaseReturnsDetails 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseReturnsDetails insert(PurchaseReturnsDetails purchaseReturnsDetails) {
        this.purchaseReturnsDetailsDao.insert(purchaseReturnsDetails);
        return purchaseReturnsDetails;
    }

    /**
     * 修改数据
     *
     * @param purchaseReturnsDetails 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseReturnsDetails update(PurchaseReturnsDetails purchaseReturnsDetails) {
        this.purchaseReturnsDetailsDao.update(purchaseReturnsDetails);
        return this.queryById(purchaseReturnsDetails.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.purchaseReturnsDetailsDao.deleteById(id) > 0;
    }
}
