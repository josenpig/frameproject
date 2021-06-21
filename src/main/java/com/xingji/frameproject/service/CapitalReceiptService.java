package com.xingji.frameproject.service;

import com.xingji.frameproject.mybatis.entity.CapitalReceipt;
import com.xingji.frameproject.vo.CapitalConditionPageVo;
import com.xingji.frameproject.vo.CiaCapVo;

import java.util.List;

/**
 * (CapitalReceipt)表服务接口
 *
 * @author makejava
 * @since 2021-06-02 20:20:48
 */
public interface CapitalReceiptService {

    /**
     * 通过ID查询单条数据
     *
     * @param receiptId 主键
     * @return 实例对象
     */
    CapitalReceipt queryById(String receiptId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalReceipt> queryAllByLimit(int offset, int limit);

    List<CapitalReceipt> queryAll(CapitalConditionPageVo vo);

    /**
     * 新增数据
     *
     * @param capitalReceipt 实例对象
     * @return 实例对象
     */
    CapitalReceipt insert(CapitalReceipt capitalReceipt);

    /**
     * 修改数据
     *
     * @param capitalReceipt 实例对象
     * @return 实例对象
     */
    CapitalReceipt update(CapitalReceipt capitalReceipt);

    /**
     * 通过主键删除数据
     *
     * @param receiptId 主键
     * @return 是否成功
     */
    boolean deleteById(String receiptId);
    /**
     * 通过实体类条件查询核销单中的收款单
     * @param vo 实体类
     * @return 影响行数
     */
    List<CiaCapVo> querycavReceipt(CiaCapVo vo);
}
