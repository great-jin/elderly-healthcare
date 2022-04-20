package com.budailad.controller;

import com.budailad.entity.SysFileConfig;
import com.budailad.entity.WarehouseStorage;
import com.budailad.service.WarehouseStorageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (WarehouseStorage)表控制层
 *
 * @author Budai
 * @since 2022-04-06 14:07:04
 */
@RestController
@RequestMapping("/api/healthcare/warehouseStorage")
public class WarehouseStorageController {
    /**
     * 服务对象
     */
    @Resource
    private WarehouseStorageService warehouseStorageService;

    /**
     * 条件查询
     *
     * @param warehouseStorage 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<WarehouseStorage>> queryAll(WarehouseStorage warehouseStorage) {
        return ResponseEntity.ok(this.warehouseStorageService.queryAll(warehouseStorage));
    }

    /**
     * 分页查询
     *
     * @param warehouseStorage 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<WarehouseStorage>> queryByPage(WarehouseStorage warehouseStorage, PageRequest pageRequest) {
        return ResponseEntity.ok(this.warehouseStorageService.queryByPage(warehouseStorage, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<WarehouseStorage> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.warehouseStorageService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param warehouseStorage 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<WarehouseStorage> add(@RequestBody WarehouseStorage warehouseStorage) {
        return ResponseEntity.ok(this.warehouseStorageService.insert(warehouseStorage));
    }

    /**
     * 编辑数据
     *
     * @param warehouseStorage 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<WarehouseStorage> edit(@RequestBody WarehouseStorage warehouseStorage) {
        return ResponseEntity.ok(this.warehouseStorageService.update(warehouseStorage));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.warehouseStorageService.deleteById(id));
    }

}

