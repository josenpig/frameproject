package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.dao.BaseUnitDao;
import com.xingji.frameproject.mybatis.entity.BaseUnit;
import com.xingji.frameproject.service.BaseUnitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BaseUnit)表服务实现类
 *
 * @author makejava
 * @since 2021-06-09 14:36:37
 */
@Service("baseUnitService")
public class BaseUnitServiceImpl implements BaseUnitService {
    @Resource
    private BaseUnitDao baseUnitDao;

    /**
     * 通过ID查询单条数据
     *
     * @param unitId 主键
     * @return 实例对象
     */
    @Override
    public BaseUnit queryById(Integer unitId) {
        return this.baseUnitDao.queryById(unitId);
    }

    /**
     * 新增数据
     *
     * @param baseUnit 实例对象
     * @return 实例对象
     */
    @Override
    public BaseUnit insert(BaseUnit baseUnit) {
        this.baseUnitDao.insert(baseUnit);
        return baseUnit;
    }

    /**
     * 修改数据
     *
     * @param baseUnit 实例对象
     * @return 实例对象
     */
    @Override
    public BaseUnit update(BaseUnit baseUnit) {
        this.baseUnitDao.update(baseUnit);
        return this.queryById(baseUnit.getUnitId());
    }

    /**
     * 通过主键删除数据
     *
     * @param unitId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer unitId) {
        return this.baseUnitDao.deleteById(unitId) > 0;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseUnit 实例对象
     * @return 对象列表
     */
    @Override
    public List<BaseUnit> queryAll(BaseUnit baseUnit) {
        return this.baseUnitDao.queryAll(baseUnit);
    }
}
