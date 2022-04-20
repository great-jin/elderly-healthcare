package com.budailad.controller;

import com.budailad.entity.SysLogs;
import com.budailad.service.SysLogsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysLogs)表控制层
 *
 * @author Budai
 * @since 2022-03-11 16:21:08
 */
@RestController
@RequestMapping(value = "/api/healthcare/sysLogs")
public class SysLogsController {
    /**
     * 服务对象
     */
    @Resource
    private SysLogsService sysLogsService;

    /**
     * 条件查询
     *
     * @param sysLogs     筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<SysLogs>> queryAll(SysLogs sysLogs) {
        return ResponseEntity.ok(this.sysLogsService.queryAll(sysLogs));
    }

    /**
     * 分页查询
     *
     * @param sysLogs     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<SysLogs>> queryByPage(SysLogs sysLogs, PageRequest pageRequest) {
        return ResponseEntity.ok(this.sysLogsService.queryByPage(sysLogs, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<SysLogs> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.sysLogsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysLogs 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<SysLogs> add(@RequestBody SysLogs sysLogs) {
        return ResponseEntity.ok(this.sysLogsService.insert(sysLogs));
    }

    /**
     * 编辑数据
     *
     * @param sysLogs 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<SysLogs> edit(@RequestBody SysLogs sysLogs) {
        return ResponseEntity.ok(this.sysLogsService.update(sysLogs));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.sysLogsService.deleteById(id));
    }

}

