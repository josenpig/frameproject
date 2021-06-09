package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.CapitalCavCiaCap;
import com.xingji.frameproject.mybatis.dao.CapitalCavCiaCapDao;
import com.xingji.frameproject.service.CapitalCavCiaCapService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CapitalCavCiaCap)表服务实现类
 *
 * @author makejava
 * @since 2021-06-08 20:55:55
 */
@Service("capitalCavCiaCapService")
public class CapitalCavCiaCapServiceImpl implements CapitalCavCiaCapService {
    @Resource
    private CapitalCavCiaCapDao capitalCavCiaCapDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cavId
     * @return 实例对象
     */
    @Override
    public List<CapitalCavCiaCap> queryById(String cavId) {
        return this.capitalCavCiaCapDao.queryById(cavId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CapitalCavCiaCap> queryAllByLimit(int offset, int limit) {
        return this.capitalCavCiaCapDao.queryAllByLimit(offset, limit);
    }
    /**
     * 修改数据
     *
     * @param capitalCavCiaCap 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(CapitalCavCiaCap capitalCavCiaCap) {
        return this.capitalCavCiaCapDao.update(capitalCavCiaCap)>0;
    }
    /**
     * 新增数据
     *
     * @param capitalCavCiaCap 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalCavCiaCap insert(CapitalCavCiaCap capitalCavCiaCap) {
        this.capitalCavCiaCapDao.insert(capitalCavCiaCap);
        return capitalCavCiaCap;
    }
    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalCavCiaBill> 实例对象列表
     * @return 影响行数
     */
    @Override
    public List<CapitalCavCiaCap> insertBatch(List<CapitalCavCiaCap> entities) {
        this.capitalCavCiaCapDao.insertBatch(entities);
        return entities;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.capitalCavCiaCapDao.deleteById(id) > 0;
    }
}
