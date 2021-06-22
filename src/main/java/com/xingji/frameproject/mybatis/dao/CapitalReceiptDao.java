package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.CapitalReceipt;
import com.xingji.frameproject.vo.CapitalConditionPageVo;
import com.xingji.frameproject.vo.CiaCapVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (CapitalReceipt)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-02 20:17:18
 */
@Mapper
public interface CapitalReceiptDao {

    /**
     * 通过ID查询单条数据
     *
     * @param receiptId 主键
     * @return 实例对象
     */
    CapitalReceipt queryById(String receiptId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CapitalReceipt> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param capitalReceipt 实例对象
     * @return 对象列表
     */
    List<CapitalReceipt> queryAll(CapitalConditionPageVo capitalReceipt);

    /**
     * 新增数据
     *
     * @param capitalReceipt 实例对象
     * @return 影响行数
     */
    int insert(CapitalReceipt capitalReceipt);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalReceipt> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CapitalReceipt> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CapitalReceipt> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<CapitalReceipt> entities);

    /**
     * 修改数据
     *
     * @param capitalReceipt 实例对象
     * @return 影响行数
     */
    int update(CapitalReceipt capitalReceipt);

    /**
     * 通过主键删除数据
     *
     * @param receiptId 主键
     * @return 影响行数
     */
    int deleteById(String receiptId);
    /**
     * 通过实体类条件查询核销单中的收款单
     * @param vo 实体类
     * @return 影响行数
     */
    List<CiaCapVo> querycavReceipt(CiaCapVo vo);
}

