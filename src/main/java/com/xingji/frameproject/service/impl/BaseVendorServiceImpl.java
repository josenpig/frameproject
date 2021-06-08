package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.dao.BaseVendorDao;
import com.xingji.frameproject.mybatis.entity.BaseVendor;
import com.xingji.frameproject.service.BaseVendorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BaseVendor)表服务实现类
 *
 * @author makejava
 * @since 2021-06-04 15:11:46
 */
@Service("baseVendorService")
public class BaseVendorServiceImpl implements BaseVendorService {
    @Resource
    private BaseVendorDao baseVendorDao;

    /**
     * 通过ID查询单条数据
     *
     * @param vendorId 主键
     * @return 实例对象
     */
    @Override
    public BaseVendor queryById(String vendorId) {
        return this.baseVendorDao.queryById(vendorId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BaseVendor> queryAllByLimit(int offset, int limit) {
        return this.baseVendorDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param baseVendor 实例对象
     * @return 实例对象
     */
    @Override
    public BaseVendor insert(BaseVendor baseVendor) {
        this.baseVendorDao.insert(baseVendor);
        return baseVendor;
    }

    /**
     * 修改数据
     *
     * @param baseVendor 实例对象
     * @return 实例对象
     */
    @Override
    public BaseVendor update(BaseVendor baseVendor) {
        this.baseVendorDao.update(baseVendor);
        return this.queryById(baseVendor.getVendorId());
    }

    /**
     * 通过主键删除数据
     *
     * @param vendorId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String vendorId) {
        return this.baseVendorDao.deleteById(vendorId) > 0;
    }

    @Override
    public List<BaseVendor> findAllVendor(BaseVendor baseVendor) {
        return this.baseVendorDao.findAllVendor(baseVendor);
    }
}
