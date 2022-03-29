package com.budailad.controller;

import com.budailad.entity.MinioFiles;
import com.budailad.service.MinioFilesService;
import org.springframework.data.domain.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MinioFiles)表控制层
 *
 * @author Budai
 * @since 2022-03-11 16:21:08
 */
@RestController
@RequestMapping(value = "/api/healthcare/minioFiles")
public class MinioFilesController {
    /**
     * 服务对象
     */
    @Resource
    private MinioFilesService minioFilesService;

    /**
     * 分页查询
     *
     * @param minioFiles  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<MinioFiles>> queryByPage(MinioFiles minioFiles, PageRequest pageRequest) {
        return ResponseEntity.ok(this.minioFilesService.queryByPage(minioFiles, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<MinioFiles> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.minioFilesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param minioFiles 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<MinioFiles> add(MinioFiles minioFiles) {
        return ResponseEntity.ok(this.minioFilesService.insert(minioFiles));
    }

    /**
     * 编辑数据
     *
     * @param minioFiles 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<MinioFiles> edit(MinioFiles minioFiles) {
        return ResponseEntity.ok(this.minioFilesService.update(minioFiles));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.minioFilesService.deleteById(id));
    }

}

