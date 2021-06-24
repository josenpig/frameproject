package com.xingji.frameproject.controller;

import com.xingji.frameproject.mybatis.entity.StockTransferDetails;
import com.xingji.frameproject.vo.form.StockTransferDetailsQueryForm;
import com.xingji.frameproject.service.StockTransferDetailsService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * (StockTransferDetails)表控制层
 *
 * @author hdr666
 * @since 2021-06-22 14:26:52
 */
@Slf4j
@RestController
@EnableSwagger2
@Api(description = "调拨详情单Api")
public class StockTransferDetailsController {
    /**
     * 服务对象
     */
    @Resource
    private StockTransferDetailsService stockTransferDetailsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/stockTransferDetails/one")
    public StockTransferDetails selectOne(Long id) {
        return this.stockTransferDetailsService.queryById(id);
    }


    /**
     * 批量新增数据
     *
     * @param StockTransferDetailsList 实例对象列表
     * @return 影响行数
     */
    @PostMapping("/stockTransferDetails/batch")
    public boolean insertBatch(@RequestBody List<StockTransferDetails> StockTransferDetailsList) {
        return this.stockTransferDetailsService.insertBatch(StockTransferDetailsList);
    }

    /**
     * 修改数据
     *
     * @param stockTransferDetails 实例对象
     * @return 实例对象
     */
    @PutMapping("/stockTransferDetails")
    public StockTransferDetails update(@RequestBody StockTransferDetails stockTransferDetails) {
        return this.stockTransferDetailsService.update(stockTransferDetails);
    }

    /**
     * 批量修改数据
     *
     * @param stockTransferDetailsList 实例对象列表
     * @return 影响行数
     */
    @PutMapping("/stockTransferDetails/batch")
    public boolean updateBatch(@RequestBody List<StockTransferDetails> stockTransferDetailsList) {
        return this.stockTransferDetailsService.updateBatch(stockTransferDetailsList);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/stockTransferDetails")
    public boolean deleteById(Long id) {
        return this.stockTransferDetailsService.deleteById(id);
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    @DeleteMapping("/stockTransferDetails/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return this.stockTransferDetailsService.deleteBatch(ids);
    }
}
