package com.xingji.frameproject.service.impl;

import com.xingji.frameproject.mybatis.entity.BaseDepot;
import com.xingji.frameproject.mybatis.dao.BaseDepotDao;
import com.xingji.frameproject.service.BaseDepotService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BaseDepot)表服务实现类
 *
 * @author makejava
 * @since 2021-05-28 19:30:47
 */
@Service("baseDepotService")
public class BaseDepotServiceImpl implements BaseDepotService {
    @Resource
    private BaseDepotDao baseDepotDao;

    /**
     * 通过ID查询单条数据
     *
     * @param depotNumber 主键
     * @return 实例对象
     */
    @Override
    public BaseDepot queryById(String depotNumber) {
        return this.baseDepotDao.queryById(depotNumber);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BaseDepot> queryAllByLimit(int offset, int limit) {
        return this.baseDepotDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<BaseDepot> queryAll(BaseDepot baseDepot) {
        return this.baseDepotDao.queryAll(baseDepot);
    }

    /**
     * 新增数据
     *
     * @param baseDepot 实例对象
     * @return 实例对象
     */
    @Override
    public BaseDepot insert(BaseDepot baseDepot) {
        this.baseDepotDao.insert(baseDepot);
        return baseDepot;
    }

    /**
     * 修改数据
     *
     * @param baseDepot 实例对象
     * @return 实例对象
     */
    @Override
    public BaseDepot update(BaseDepot baseDepot) {
        this.baseDepotDao.update(baseDepot);
        return this.queryById(baseDepot.getDepotId());
    }

    /**
     * 通过主键删除数据
     *
     * @param depotNumber 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String depotNumber) {
        return this.baseDepotDao.deleteById(depotNumber) > 0;
    }

    /**
     * 查询所有仓库信息
     * @return
     */
    @Override
    public List<BaseDepot> findAllDepot() {
        return this.baseDepotDao.findAllDepot();
    }
    /**
     * 查询所有的仓库
     * @return
     */
    @Override
    public List<BaseDepot> findAll() {
        return this.baseDepotDao.findAll();
    }
}
