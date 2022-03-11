package com.budailad.controller;

import com.budailad.entity.MedicineCatalog;
import com.budailad.service.MedicineCatalogService;
import org.springframework.data.domain.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MedicineCatalog)表控制层
 *
 * @author Budai
 * @since 2022-03-11 16:21:04
 */
@RestController
@RequestMapping(value = "/api/healthcare/medicineCatalog")
public class MedicineCatalogController {
    /**
     * 服务对象
     */
    @Resource
    private MedicineCatalogService medicineCatalogService;

    /**
     * 分页查询
     *
     * @param medicineCatalog 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<MedicineCatalog>> queryByPage(MedicineCatalog medicineCatalog, PageRequest pageRequest) {
        return ResponseEntity.ok(this.medicineCatalogService.queryByPage(medicineCatalog, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<MedicineCatalog> queryById(@Param("id") String id) {
        return ResponseEntity.ok(this.medicineCatalogService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param medicineCatalog 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<MedicineCatalog> add(MedicineCatalog medicineCatalog) {
        return ResponseEntity.ok(this.medicineCatalogService.insert(medicineCatalog));
    }

    /**
     * 编辑数据
     *
     * @param medicineCatalog 实体
     * @return 编辑结果
     */
    @PutMapping("/update")
    public ResponseEntity<MedicineCatalog> edit(MedicineCatalog medicineCatalog) {
        return ResponseEntity.ok(this.medicineCatalogService.update(medicineCatalog));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.medicineCatalogService.deleteById(id));
    }

}

