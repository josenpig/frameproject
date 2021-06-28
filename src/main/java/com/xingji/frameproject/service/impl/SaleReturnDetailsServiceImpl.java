package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.SaleReturnDetails;
import com.xingji.frameproject.mybatis.dao.SaleReturnDetailsDao;
import com.xingji.frameproject.service.SaleReturnDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SaleReturnDetails)表服务实现类
 *
 * @author makejava
 * @since 2021-05-30 21:20:19
 */
@Service("saleReturnDetailsService")
public class SaleReturnDetailsServiceImpl implements SaleReturnDetailsService {
    @Resource
    private SaleReturnDetailsDao saleReturnDetailsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param returnId 主键
     * @return 实例对象
     */
    @Override
    public List<SaleReturnDetails> queryById(String returnId) {
        return this.saleReturnDetailsDao.queryById(returnId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SaleReturnDetails> queryAllByLimit(int offset, int limit) {
        return this.saleReturnDetailsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param saleReturnDetails 实例对象
     * @return 实例对象
     */
    @Override
    public SaleReturnDetails insert(SaleReturnDetails saleReturnDetails) {
        this.saleReturnDetailsDao.insert(saleReturnDetails);
        return saleReturnDetails;
    }
    /**
     * 新增多条数据
     *
     * @param saleReturnDetails 实例对象
     * @return 实例对象
     */
    @Override
    public List<SaleReturnDetails> insertBatch(List<SaleReturnDetails> saleReturnDetails) {
        this.saleReturnDetailsDao.insertBatch(saleReturnDetails);
        return saleReturnDetails;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.saleReturnDetailsDao.deleteById(id) > 0;
    }
}
