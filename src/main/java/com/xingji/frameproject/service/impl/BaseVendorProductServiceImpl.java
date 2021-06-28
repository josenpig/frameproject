package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.BaseVendorProduct;
import com.xingji.frameproject.mybatis.dao.BaseVendorProductDao;
import com.xingji.frameproject.service.BaseVendorProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BaseVendorProduct)表服务实现类
 *
 * @author makejava
 * @since 2021-06-25 15:26:11
 */
@Service("baseVendorProductService")
public class BaseVendorProductServiceImpl implements BaseVendorProductService {
    @Resource
    private BaseVendorProductDao baseVendorProductDao;

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    @Override
    public BaseVendorProduct queryById(String vendorId) {
        return this.baseVendorProductDao.queryById(vendorId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BaseVendorProduct> queryAllByLimit(int offset, int limit) {
        return this.baseVendorProductDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param baseVendorProduct 实例对象
     * @return 实例对象
     */
    @Override
    public BaseVendorProduct insert(BaseVendorProduct baseVendorProduct) {
        this.baseVendorProductDao.insert(baseVendorProduct);
        return baseVendorProduct;
    }

    /**
     * 修改数据
     *
     * @param baseVendorProduct 实例对象
     * @return 实例对象
     */
    @Override
    public BaseVendorProduct update(BaseVendorProduct baseVendorProduct) {
        this.baseVendorProductDao.update(baseVendorProduct);
        return this.queryById(baseVendorProduct.getVendorId());
    }

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String ProductId) {
        return this.baseVendorProductDao.deleteById(ProductId) > 0;
    }
}
