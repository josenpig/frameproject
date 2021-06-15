package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.BaseProductType;
import com.xingji.frameproject.mybatis.dao.BaseProductTypeDao;
import com.xingji.frameproject.service.BaseProductTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BaseProductType)表服务实现类
 *
 * @author makejava
 * @since 2021-06-15 10:00:16
 */
@Service("baseProductTypeService")
public class BaseProductTypeServiceImpl implements BaseProductTypeService {
    @Resource
    private BaseProductTypeDao baseProductTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param productTypeId 主键
     * @return 实例对象
     */
    @Override
    public BaseProductType queryById(Integer productTypeId) {
        return this.baseProductTypeDao.queryById(productTypeId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BaseProductType> queryAllByLimit(int offset, int limit) {
        return this.baseProductTypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param baseProductType 实例对象
     * @return 实例对象
     */
    @Override
    public BaseProductType insert(BaseProductType baseProductType) {
        this.baseProductTypeDao.insert(baseProductType);
        return baseProductType;
    }

    /**
     * 修改数据
     *
     * @param baseProductType 实例对象
     * @return 实例对象
     */
    @Override
    public BaseProductType update(BaseProductType baseProductType) {
        this.baseProductTypeDao.update(baseProductType);
        return this.queryById(baseProductType.getId());
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseProductType 实例对象
     * @return 对象列表
     */
    @Override
    public List<BaseProductType> queryAll(BaseProductType baseProductType) {
        return this.baseProductTypeDao.queryAll(baseProductType);
    }

    /**
     * 通过主键删除数据
     *
     * @param productTypeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer productTypeId) {
        return this.baseProductTypeDao.deleteById(productTypeId) > 0;
    }
}
