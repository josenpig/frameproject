package com.xingji.frameproject.mybatis.dao;


import com.xingji.frameproject.mybatis.entity.PurchaseReturnsDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * (PurchaseReturnsDetails)表数据库访问层
 *
 * @author protagonist
 * @since 2021-06-18 00:47:00
 */
@Mapper
public interface PurchaseReturnsDetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseReturnsDetails selectById(Integer id);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<PurchaseReturnsDetails> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param purchaseReturnsDetails 实例对象
     * @return 对象列表
     */
    List<PurchaseReturnsDetails> selectList(PurchaseReturnsDetails purchaseReturnsDetails);

    /**
     * 新增数据
     *
     * @param purchaseReturnsDetails 实例对象
     * @return 影响行数
     */
    int insert(PurchaseReturnsDetails purchaseReturnsDetails);

    /**
     * 批量新增
     *
     * @param purchaseReturnsDetailss 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(@Param("entities")List<PurchaseReturnsDetails> purchaseReturnsDetailss);

    /**
     * 修改数据
     *
     * @param purchaseReturnsDetails 实例对象
     * @return 影响行数
     */
    int update(PurchaseReturnsDetails purchaseReturnsDetails);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}
