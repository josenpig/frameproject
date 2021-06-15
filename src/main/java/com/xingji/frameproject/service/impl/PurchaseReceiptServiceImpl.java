package com.xingji.frameproject.service.impl;

<<<<<<< HEAD
import com.xingji.frameproject.mybatis.entity.PurchaseReceipt;
import com.xingji.frameproject.mybatis.dao.PurchaseReceiptDao;
=======
;
import com.xingji.frameproject.mybatis.dao.PurchaseReceiptDao;
import com.xingji.frameproject.mybatis.entity.PurchaseReceipt;
>>>>>>> c482c7c0b5ef56e44cdda9c9d903455528076527
import com.xingji.frameproject.service.PurchaseReceiptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PurchaseReceipt)表服务实现类
 *
 * @author makejava
 * @since 2021-06-15 18:48:36
 */
@Service("purchaseReceiptService")
public class PurchaseReceiptServiceImpl implements PurchaseReceiptService {
    @Resource
    private PurchaseReceiptDao purchaseReceiptDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PurchaseReceipt queryById(String id) {
        return this.purchaseReceiptDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<PurchaseReceipt> queryAllByLimit(int offset, int limit) {
        return this.purchaseReceiptDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param purchaseReceipt 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseReceipt insert(PurchaseReceipt purchaseReceipt) {
        this.purchaseReceiptDao.insert(purchaseReceipt);
        return purchaseReceipt;
    }

    /**
     * 修改数据
     *
     * @param purchaseReceipt 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseReceipt update(PurchaseReceipt purchaseReceipt) {
        this.purchaseReceiptDao.update(purchaseReceipt);
        return this.queryById(purchaseReceipt.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.purchaseReceiptDao.deleteById(id) > 0;
    }
}
