package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.SaleReturnDetails;

import java.util.List;

/**
 * (SaleReturnDetails)表服务接口
 *
 * @author makejava
 * @since 2021-05-30 21:20:19
 */
public interface SaleReturnDetailsService {

    /**
     * 通过ID查询单条数据
     *
     * @param returnId 主键
     * @return 实例对象
     */
    List<SaleReturnDetails> queryById(String returnId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SaleReturnDetails> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param saleReturnDetails 实例对象
     * @return 实例对象
     */
    SaleReturnDetails insert(SaleReturnDetails saleReturnDetails);

    List<SaleReturnDetails> insertBatch(List<SaleReturnDetails> saleReturnDetails);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
