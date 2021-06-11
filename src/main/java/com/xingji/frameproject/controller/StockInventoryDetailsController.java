package com.xingji.frameproject.controller;

import com.github.pagehelper.PageInfo;
import com.xingji.frameproject.mybatis.entity.StockInventoryDetails;
import com.xingji.frameproject.service.StockInventoryDetailsService;
import com.xingji.frameproject.vo.form.StockInventoryDetailsQueryForm;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (StockInventoryDetails)表控制层
 *
 * @author makejava
 * @since 2021-06-10 19:09:15
 */
@RestController
public class StockInventoryDetailsController {
    /**
     * 服务对象
     */
    @Resource
    private StockInventoryDetailsService stockInventoryDetailsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/stockInventoryDetails/one")
    public StockInventoryDetails selectOne(Integer id) {
        return this.stockInventoryDetailsService.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @param stockInventoryDetailsQueryForm 实例对象
     * @return 实例对象
     */
    @GetMapping("/stockInventoryDetails")
    public PageInfo<StockInventoryDetails> queryAll(StockInventoryDetailsQueryForm stockInventoryDetailsQueryForm) {
        return this.stockInventoryDetailsService.queryAll(stockInventoryDetailsQueryForm);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param stockInventoryDetailsQueryForm
     * @return 对象列表
     */
    @GetMapping("/stockInventoryDetails/search")
    public PageInfo<StockInventoryDetails> queryBySearch(StockInventoryDetailsQueryForm stockInventoryDetailsQueryForm) {
        return this.stockInventoryDetailsService.queryBySearch(stockInventoryDetailsQueryForm);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param stockInventoryDetailsQueryForm
     * @return 对象列表
     */
    @GetMapping("/stockInventoryDetails/screen")
    public PageInfo<StockInventoryDetails> queryByScreen(StockInventoryDetailsQueryForm stockInventoryDetailsQueryForm) {
        return this.stockInventoryDetailsService.queryByScreen(stockInventoryDetailsQueryForm);
    }

    /**
     * 新增数据
     *
     * @param stockInventoryDetails 实例对象
     * @return 实例对象
     */
    @PostMapping("/stockInventoryDetails")
    public StockInventoryDetails insert(@RequestBody StockInventoryDetails stockInventoryDetails) {
        return this.stockInventoryDetailsService.insert(stockInventoryDetails);
    }

    /**
     * 批量新增数据
     *
     * @param StockInventoryDetailsList 实例对象列表
     * @return 影响行数
     */
    @PostMapping("/stockInventoryDetails/batch")
    public boolean insertBatch(@RequestBody List<StockInventoryDetails> StockInventoryDetailsList) {
        return this.stockInventoryDetailsService.insertBatch(StockInventoryDetailsList);
    }

    /**
     * 修改数据
     *
     * @param stockInventoryDetails 实例对象
     * @return 实例对象
     */
    @PutMapping("/stockInventoryDetails")
    public StockInventoryDetails update(@RequestBody StockInventoryDetails stockInventoryDetails) {
        return this.stockInventoryDetailsService.update(stockInventoryDetails);
    }

    /**
     * 批量修改数据
     *
     * @param stockInventoryDetailsList 实例对象列表
     * @return 影响行数
     */
    @PutMapping("/stockInventoryDetails/batch")
    public boolean updateBatch(@RequestBody List<StockInventoryDetails> stockInventoryDetailsList) {
        return this.stockInventoryDetailsService.updateBatch(stockInventoryDetailsList);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/stockInventoryDetails")
    public boolean deleteById(Integer id) {
        return this.stockInventoryDetailsService.deleteById(id);
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    @DeleteMapping("/stockInventoryDetails/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return this.stockInventoryDetailsService.deleteBatch(ids);
    }
}