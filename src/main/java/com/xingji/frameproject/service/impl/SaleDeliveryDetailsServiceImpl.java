package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.SaleDeliveryDetails;
import com.xingji.frameproject.mybatis.dao.SaleDeliveryDetailsDao;
import com.xingji.frameproject.service.SaleDeliveryDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SaleDeliveryDetails)表服务实现类
 *
 * @author makejava
 * @since 2021-05-24 11:48:41
 */
@Service("saleDeliveryDetailsService")
public class SaleDeliveryDetailsServiceImpl implements SaleDeliveryDetailsService {
    @Resource
    private SaleDeliveryDetailsDao saleDeliveryDetailsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param deliveryId
     * @return 实例对象
     */
    @Override
    public List<SaleDeliveryDetails> queryById(String deliveryId) {
        return this.saleDeliveryDetailsDao.queryById(deliveryId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SaleDeliveryDetails> queryAllByLimit(int offset, int limit) {
        return this.saleDeliveryDetailsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param saleDeliveryDetails 实例对象
     * @return 实例对象
     */
    @Override
    public SaleDeliveryDetails insert(SaleDeliveryDetails saleDeliveryDetails) {
        this.saleDeliveryDetailsDao.insert(saleDeliveryDetails);
        return saleDeliveryDetails;
    }

    @Override
    public List<SaleDeliveryDetails> insertBatch(List<SaleDeliveryDetails> saleDeliveryDetails) {
        this.saleDeliveryDetailsDao.insertBatch(saleDeliveryDetails);
        return saleDeliveryDetails;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.saleDeliveryDetailsDao.deleteById(id) > 0;
    }
}
