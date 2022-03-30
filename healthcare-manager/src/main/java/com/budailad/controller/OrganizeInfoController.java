package com.budailad.controller;

import com.budailad.entity.OrganizeInfo;
import com.budailad.service.OrganizeInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OrganizeInfo)表控制层
 *
 * @author Budai
 * @since 2022-03-11 16:21:04
 */
@RestController
@RequestMapping(value = "/api/healthcare/organizeInfo")
public class OrganizeInfoController {
    /**
     * 服务对象
     */
    @Resource
    private OrganizeInfoService organizeInfoService;

    /**
     * 条件查询
     *
     * @param organizeInfo 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<OrganizeInfo>> queryAll(OrganizeInfo organizeInfo) {
        return ResponseEntity.ok(this.organizeInfoService.queryAll(organizeInfo));
    }

    /**
     * 分页查询
     *
     * @param organizeInfo 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<OrganizeInfo>> queryByPage(OrganizeInfo organizeInfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.organizeInfoService.queryByPage(organizeInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<OrganizeInfo> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.organizeInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param organizeInfo 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<OrganizeInfo> add(OrganizeInfo organizeInfo) {
        return ResponseEntity.ok(this.organizeInfoService.insert(organizeInfo));
    }

    /**
     * 编辑数据
     *
     * @param organizeInfo 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<OrganizeInfo> edit(OrganizeInfo organizeInfo) {
        return ResponseEntity.ok(this.organizeInfoService.update(organizeInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.organizeInfoService.deleteById(id));
    }

}

