package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.CapitalCavCia;
import com.xingji.frameproject.mybatis.dao.CapitalCavCiaDao;
import com.xingji.frameproject.service.CapitalCavCiaService;
import com.xingji.frameproject.vo.CavConditionPageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CapitalCavCia)表服务实现类
 *
 * @author makejava
 * @since 2021-06-08 20:42:07
 */
@Service("capitalCavCiaService")
public class CapitalCavCiaServiceImpl implements CapitalCavCiaService {
    @Resource
    private CapitalCavCiaDao capitalCavCiaDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cavId 主键
     * @return 实例对象
     */
    @Override
    public CapitalCavCia queryById(String cavId) {
        return this.capitalCavCiaDao.queryById(cavId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CapitalCavCia> queryAllByLimit(int offset, int limit) {
        return this.capitalCavCiaDao.queryAllByLimit(offset, limit);
    }
    /**
     * 通过实体作为筛选条件查询
     *
     * @param capitalCavCia 实例对象
     * @return 对象列表
     */
    @Override
    public List<CapitalCavCia> queryAll(CapitalCavCia capitalCavCia) {
        return this.capitalCavCiaDao.queryAll(capitalCavCia);
    }
    /**
     * 通过实体作为筛选条件查询   预收冲应收
     *
     * @param vo 实例对象
     * @return 对象列表
     */
    @Override
    public List<CapitalCavCia> queryonePage(CavConditionPageVo vo) {
        return this.capitalCavCiaDao.queryonePage(vo);
    }
    /**
     * 通过实体作为筛选条件查询   预付冲应付
     *
     * @param vo 实例对象
     * @return 对象列表
     */
    @Override
    public List<CapitalCavCia> querytwoPage(CavConditionPageVo vo) {
        return this.capitalCavCiaDao.querytwoPage(vo);
    }
    /**
     * 新增数据
     *
     * @param capitalCavCia 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalCavCia insert(CapitalCavCia capitalCavCia) {
        this.capitalCavCiaDao.insert(capitalCavCia);
        return capitalCavCia;
    }

    /**
     * 修改数据
     *
     * @param capitalCavCia 实例对象
     * @return 实例对象
     */
    @Override
    public CapitalCavCia update(CapitalCavCia capitalCavCia) {
        this.capitalCavCiaDao.update(capitalCavCia);
        return this.queryById(capitalCavCia.getCavId());
    }

    /**
     * 通过主键删除数据
     *
     * @param cavId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String cavId) {
        return this.capitalCavCiaDao.deleteById(cavId) > 0;
    }

}
