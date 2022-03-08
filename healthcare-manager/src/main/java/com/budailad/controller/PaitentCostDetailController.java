package com.budailad.controller;

import com.budailad.entity.PaitentCostDetail;
import com.budailad.service.PaitentCostDetailService;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PaitentCostDetail)表控制层
 *
 * @Author Budai
 * @Since 2022-03-07 16:25:58
 */
@RestController
@RequestMapping("/api/healthcare/paitentCostDetail")
public class PaitentCostDetailController {
    /**
     * 服务对象
     */
    @Resource
    private PaitentCostDetailService paitentCostDetailService;

    /**
     * 分页查询
     *
     * @param paitentCostDetail 筛选条件
     * @param pageRequest       分页对象
     * @return 查询结果
     */
    @GetMapping("page")
    public ResponseEntity<Page<PaitentCostDetail>> queryByPage(PaitentCostDetail paitentCostDetail, PageRequest pageRequest) {
        return ResponseEntity.ok(this.paitentCostDetailService.queryByPage(paitentCostDetail, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<PaitentCostDetail> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.paitentCostDetailService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param paitentCostDetail 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<PaitentCostDetail> add(@RequestBody PaitentCostDetail paitentCostDetail) {
        return ResponseEntity.ok(this.paitentCostDetailService.insert(paitentCostDetail));
    }

    /**
     * 编辑数据
     *
     * @param paitentCostDetail 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<PaitentCostDetail> edit(@RequestBody PaitentCostDetail paitentCostDetail) {
        return ResponseEntity.ok(this.paitentCostDetailService.update(paitentCostDetail));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(@Param("id") Integer id) {
        return ResponseEntity.ok(this.paitentCostDetailService.deleteById(id));
    }

}

