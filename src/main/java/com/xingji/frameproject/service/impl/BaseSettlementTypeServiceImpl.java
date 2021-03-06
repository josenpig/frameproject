package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.BaseSettlementType;
import com.xingji.frameproject.mybatis.dao.BaseSettlementTypeDao;
import com.xingji.frameproject.service.BaseSettlementTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BaseSettlementType)表服务实现类
 *
 * @author makejava
 * @since 2021-06-10 16:22:51
 */
@Service("baseSettlementTypeService")
public class BaseSettlementTypeServiceImpl implements BaseSettlementTypeService {
    @Resource
    private BaseSettlementTypeDao baseSettlementTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BaseSettlementType queryById(Integer id) {
        return this.baseSettlementTypeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BaseSettlementType> queryAllByLimit(int offset, int limit) {
        return this.baseSettlementTypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param baseSettlementType 实例对象
     * @return 实例对象
     */
    @Override
    public BaseSettlementType insert(BaseSettlementType baseSettlementType) {
        this.baseSettlementTypeDao.insert(baseSettlementType);
        return baseSettlementType;
    }

    /**
     * 修改数据
     *
     * @param baseSettlementType 实例对象
     * @return 实例对象
     */
    @Override
    public BaseSettlementType update(BaseSettlementType baseSettlementType) {
        this.baseSettlementTypeDao.update(baseSettlementType);
        return this.queryById(baseSettlementType.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.baseSettlementTypeDao.deleteById(id) > 0;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseSettlementType 实例对象
     * @return 对象列表
     */
    @Override
    public List<BaseSettlementType> queryAll(BaseSettlementType baseSettlementType) {
        return this.baseSettlementTypeDao.queryAll(baseSettlementType);
    }
}
