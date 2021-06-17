package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.SaleReturn;
import com.xingji.frameproject.vo.SaleConditionPageVo;

import java.util.List;

/**
 * (SaleReturn)表服务接口
 *
 * @author makejava
 * @since 2021-05-30 19:06:41
 */
public interface SaleReturnService {

    /**
     * 通过ID查询单条数据
     *
     * @param returnId 主键
     * @return 实例对象
     */
    SaleReturn queryById(String returnId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SaleReturn> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param saleReturn 实例对象
     * @return 实例对象
     */
    SaleReturn insert(SaleReturn saleReturn);

    /**
     * 修改数据
     *
     * @param saleReturn 实例对象
     * @return 实例对象
     */
    SaleReturn update(SaleReturn saleReturn);

    /**
     * 通过主键删除数据
     *
     * @param returnId 主键
     * @return 是否成功
     */
    boolean deleteById(String returnId);

    //@Cacheable(cacheNames = "allsaleorder")
    List<SaleReturn> conditionpage(SaleConditionPageVo order);
}
