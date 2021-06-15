package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.BaseDepot;
import com.xingji.frameproject.mybatis.entity.StockInventoryDetails;

import java.util.List;

/**
 * (BaseDepot)表服务接口
 *
 * @author makejava
 * @since 2021-05-28 19:30:47
 */
public interface BaseDepotService {

    /**
     * 通过ID查询单条数据
     *
     * @param depotNumber 主键
     * @return 实例对象
     */
    BaseDepot queryById(String depotNumber);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseDepot> queryAllByLimit(int offset, int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseDepot 实例对象
     * @return 对象列表
     */
    List<BaseDepot> queryAll(BaseDepot baseDepot);

    /**
     * 新增数据
     *
     * @param baseDepot 实例对象
     * @return 实例对象
     */
    BaseDepot insert(BaseDepot baseDepot);

    /**
     * 修改数据
     *
     * @param baseDepot 实例对象
     * @return 实例对象
     */
    BaseDepot update(BaseDepot baseDepot);

    /**
     * 通过主键删除数据
     *
     * @param depotNumber 主键
     * @return 是否成功
     */
    boolean deleteById(String depotNumber);

    /**
     * 查询所有仓库
     * @return
     */
    List<BaseDepot> findAllDepot();

    List<BaseDepot> findAll();


}
