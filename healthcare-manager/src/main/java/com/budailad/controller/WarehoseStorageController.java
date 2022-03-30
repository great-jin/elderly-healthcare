package com.budailad.controller;

import com.budailad.entity.WarehoseStorage;
import com.budailad.service.WarehoseStorageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (WarehoseStorage)表控制层
 *
 * @author Budai
 * @since 2022-03-11 16:21:05
 */
@RestController
@RequestMapping(value = "/api/healthcare/warehoseStorage")
public class WarehoseStorageController {
    /**
     * 服务对象
     */
    @Resource
    private WarehoseStorageService warehoseStorageService;

    /**
     * 条件查询
     *
     * @param warehoseStorage 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<WarehoseStorage>> queryAll(WarehoseStorage warehoseStorage) {
        return ResponseEntity.ok(this.warehoseStorageService.queryAll(warehoseStorage));
    }

    /**
     * 分页查询
     *
     * @param warehoseStorage 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<WarehoseStorage>> queryByPage(WarehoseStorage warehoseStorage, PageRequest pageRequest) {
        return ResponseEntity.ok(this.warehoseStorageService.queryByPage(warehoseStorage, pageRequest));
    }

    /**
     * 查询非分页数据
     *
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<WarehoseStorage>> queryAll() {
        return ResponseEntity.ok(this.warehoseStorageService.queryAll());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<WarehoseStorage> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.warehoseStorageService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param warehoseStorage 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<WarehoseStorage> add(WarehoseStorage warehoseStorage) {
        return ResponseEntity.ok(this.warehoseStorageService.insert(warehoseStorage));
    }

    /**
     * 编辑数据
     *
     * @param warehoseStorage 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<WarehoseStorage> edit(WarehoseStorage warehoseStorage) {
        return ResponseEntity.ok(this.warehoseStorageService.update(warehoseStorage));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.warehoseStorageService.deleteById(id));
    }

}

