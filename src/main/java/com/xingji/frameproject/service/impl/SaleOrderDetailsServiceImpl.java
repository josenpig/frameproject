package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.SaleOrderDetails;
import com.xingji.frameproject.mybatis.dao.SaleOrderDetailsDao;
import com.xingji.frameproject.service.SaleOrderDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SaleOrderDetails)表服务实现类
 *
 * @author makejava
 * @since 2021-05-20 19:12:22
 */
@Service("saleOrderDetailsService")
public class SaleOrderDetailsServiceImpl implements SaleOrderDetailsService {
    @Resource
    private SaleOrderDetailsDao saleOrderDetailsDao;

    /**
     * 通过订单ID查询数据
     *
     * @param orderid
     * @return 实例对象
     */
    @Override
    public List<SaleOrderDetails> queryById(String orderid) {
        return this.saleOrderDetailsDao.queryById(orderid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SaleOrderDetails> queryAllByLimit(int offset, int limit) {
        return this.saleOrderDetailsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param saleOrderDetails 实例对象
     * @return 实例对象
     */
    @Override
    public SaleOrderDetails insert(SaleOrderDetails saleOrderDetails) {
        this.saleOrderDetailsDao.insert(saleOrderDetails);
        return saleOrderDetails;
    }
    /**
     * 新增多条数据
     *
     * @param saleOrderDetails 实例对象
     * @return 实例对象
     */
    @Override
    public List<SaleOrderDetails> insertBatch(List<SaleOrderDetails> saleOrderDetails){
        this.saleOrderDetailsDao.insertBatch(saleOrderDetails);
        return saleOrderDetails;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.saleOrderDetailsDao.deleteById(id) > 0;
    }
}
