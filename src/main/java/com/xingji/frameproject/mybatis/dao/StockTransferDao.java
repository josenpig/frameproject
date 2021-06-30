package com.xingji.frameproject.mybatis.dao;

import com.xingji.frameproject.mybatis.entity.StockTransfer;
import com.xingji.frameproject.vo.PurchaseReceiptConditionVo;
import com.xingji.frameproject.vo.form.StockTransferQueryForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (StockTransfer)表数据库访问层
 *
 * @author hdr666
 * @since 2021-06-22 14:17:27
 */
@Mapper
public interface StockTransferDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StockTransfer queryById(String id);

    /**
     * 查询所有数据
     *
     * @param stockTransferQueryForm 实例对象
     * @return 实例对象
     */
    List<StockTransfer> queryAll(StockTransferQueryForm stockTransferQueryForm);

    /**
     * 通过实体作为或者条件查询
     *
     * @param stockTransferQueryForm 实例对象
     * @return 对象列表
     */
    List<StockTransfer> queryOrByPojo(StockTransferQueryForm stockTransferQueryForm);

    /**
     * 通过实体作为并且条件查询
     *
     * @param stockTransferQueryForm 实例对象
     * @return 对象列表
     */
    List<StockTransfer> queryAndByPojo(StockTransferQueryForm stockTransferQueryForm);

    /**
     * 新增数据
     *
     * @param stockTransfer 实例对象
     * @return 影响行数
     */
    int insert(StockTransfer stockTransfer);

    /**
     * 批量新增数据
     *
     * @param stockTransferList 实例对象列表
     * @return 影响行数
     */
    int insertBatch(List<StockTransfer> stockTransferList);

    /**
     * 修改数据
     *
     * @param stockTransfer 实例对象
     * @return 影响行数
     */
    int update(StockTransfer stockTransfer);

    /**
     * 批量修改数据
     *
     * @param stockTransferList 实例对象列表
     * @return 影响行数
     */
    int updateBatch(List<StockTransfer> stockTransferList);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 影响行数
     */
    int deleteBatch(List<Integer> ids);

    /**
     * 批量对象列表删除数据
     *
     * @param stockTransferList 实例对象列表
     * @return 影响行数
     */
    int deleteBatchByEntities(List<StockTransfer> stockTransferList);

    List<StockTransfer> conditionpage(PurchaseReceiptConditionVo order);
}

