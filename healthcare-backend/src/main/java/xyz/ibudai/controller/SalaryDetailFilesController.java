package xyz.ibudai.controller;

import xyz.ibudai.entity.SalaryDetailFiles;
import xyz.ibudai.service.SalaryDetailFilesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SalaryDetailFiles)表控制层
 *
 * @author Budai
 * @since 2022-03-24 15:54:00
 */
@RestController
@RequestMapping("/api/healthcare/salaryDetailFiles")
public class SalaryDetailFilesController {
    /**
     * 服务对象
     */
    @Resource
    private SalaryDetailFilesService salaryDetailFilesService;

    /**
     * 条件查询
     *
     * @param salaryDetailFiles 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<SalaryDetailFiles>> conditionQuery(SalaryDetailFiles salaryDetailFiles) {
        return ResponseEntity.ok(this.salaryDetailFilesService.conditionQuery(salaryDetailFiles));
    }

    /**
     * 分页查询
     *
     * @param salaryDetailFiles 筛选条件
     * @param pageRequest       分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<SalaryDetailFiles>> queryByPage(SalaryDetailFiles salaryDetailFiles, PageRequest pageRequest) {
        return ResponseEntity.ok(this.salaryDetailFilesService.queryByPage(salaryDetailFiles, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<SalaryDetailFiles> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.salaryDetailFilesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param salaryDetailFiles 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<SalaryDetailFiles> add(@RequestBody SalaryDetailFiles salaryDetailFiles) {
        return ResponseEntity.ok(this.salaryDetailFilesService.insert(salaryDetailFiles));
    }

    /**
     * 编辑数据
     *
     * @param salaryDetailFiles 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<SalaryDetailFiles> edit(@RequestBody SalaryDetailFiles salaryDetailFiles) {
        return ResponseEntity.ok(this.salaryDetailFilesService.update(salaryDetailFiles));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.salaryDetailFilesService.deleteById(id));
    }

}

