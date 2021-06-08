package com.xingji.frameproject.controller;

import com.github.pagehelper.PageInfo;
import com.xingji.frameproject.mybatis.entity.StockInventory;
import com.xingji.frameproject.service.StockInventoryService;
import com.xingji.frameproject.vo.form.StockInventoryQueryForm;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (StockInventory)表控制层
 *
 * @author makejava
 * @since 2021-06-08 21:08:23
 */
@RestController
public class StockInventoryController {
    /**
     * 服务对象
     */
    @Resource
    private StockInventoryService stockInventoryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/stockInventory/one")
    public StockInventory selectOne(String id) {
        return this.stockInventoryService.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @param stockInventoryQueryForm 实例对象
     * @return 实例对象
     */
    @GetMapping("/stockInventory")
    public PageInfo<StockInventory> queryAll(StockInventoryQueryForm stockInventoryQueryForm) {
        return this.stockInventoryService.queryAll(stockInventoryQueryForm);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param stockInventoryQueryForm
     * @return 对象列表
     */
    @GetMapping("/stockInventory/search")
    public PageInfo<StockInventory> queryBySearch(StockInventoryQueryForm stockInventoryQueryForm) {
        return this.stockInventoryService.queryBySearch(stockInventoryQueryForm);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param stockInventoryQueryForm
     * @return 对象列表
     */
    @GetMapping("/stockInventory/screen")
    public PageInfo<StockInventory> queryByScreen(StockInventoryQueryForm stockInventoryQueryForm) {
        return this.stockInventoryService.queryByScreen(stockInventoryQueryForm);
    }

    /**
     * 新增数据
     *
     * @param stockInventory 实例对象
     * @return 实例对象
     */
    @PostMapping("/stockInventory")
    public StockInventory insert(@RequestBody StockInventory stockInventory) {
        return this.stockInventoryService.insert(stockInventory);
    }

    /**
     * 批量新增数据
     *
     * @param StockInventoryList 实例对象列表
     * @return 影响行数
     */
    @PostMapping("/stockInventory/batch")
    public boolean insertBatch(@RequestBody List<StockInventory> StockInventoryList) {
        return this.stockInventoryService.insertBatch(StockInventoryList);
    }

    /**
     * 修改数据
     *
     * @param stockInventory 实例对象
     * @return 实例对象
     */
    @PutMapping("/stockInventory")
    public StockInventory update(@RequestBody StockInventory stockInventory) {
        return this.stockInventoryService.update(stockInventory);
    }

    /**
     * 批量修改数据
     *
     * @param stockInventoryList 实例对象列表
     * @return 影响行数
     */
    @PutMapping("/stockInventory/batch")
    public boolean updateBatch(@RequestBody List<StockInventory> stockInventoryList) {
        return this.stockInventoryService.updateBatch(stockInventoryList);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/stockInventory")
    public boolean deleteById(String id) {
        return this.stockInventoryService.deleteById(id);
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    @DeleteMapping("/stockInventory/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return this.stockInventoryService.deleteBatch(ids);
    }
}