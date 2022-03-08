package com.budailad.controller;

import com.budailad.entity.EmployeeSalary;
import com.budailad.service.EmployeeSalaryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (EmployeeSalary)表控制层
 *
 * @Author Budai
 * @Since 2022-03-07 16:24:02
 */
@RestController
@RequestMapping("/api/healthcare/employeeSalary")
public class EmployeeSalaryController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeSalaryService employeeSalaryService;

    /**
     * 分页查询
     *
     * @param employeeSalary 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @GetMapping("page")
    public ResponseEntity<Page<EmployeeSalary>> queryByPage(EmployeeSalary employeeSalary, PageRequest pageRequest) {
        return ResponseEntity.ok(this.employeeSalaryService.queryByPage(employeeSalary, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<EmployeeSalary> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.employeeSalaryService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param employeeSalary 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<EmployeeSalary> add(@RequestBody EmployeeSalary employeeSalary) {
        return ResponseEntity.ok(this.employeeSalaryService.insert(employeeSalary));
    }

    /**
     * 编辑数据
     *
     * @param employeeSalary 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<EmployeeSalary> edit(@RequestBody EmployeeSalary employeeSalary) {
        return ResponseEntity.ok(this.employeeSalaryService.update(employeeSalary));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(@Param("id") String id) {
        return ResponseEntity.ok(this.employeeSalaryService.deleteById(id));
    }

}
