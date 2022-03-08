package com.budailad.controller;

import com.budailad.entity.OrganizeStaff;
import com.budailad.service.OrganizeStaffService;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (OrganizeStaff)表控制层
 *
 * @Author Budai
 * @Since 2022-03-07 16:25:46
 */
@RestController
@RequestMapping("/api/healthcare/organizeStaff")
public class OrganizeStaffController {
    /**
     * 服务对象
     */
    @Resource
    private OrganizeStaffService organizeStaffService;

    /**
     * 分页查询
     *
     * @param organizeStaff 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    @GetMapping("page")
    public ResponseEntity<Page<OrganizeStaff>> queryByPage(OrganizeStaff organizeStaff, PageRequest pageRequest) {
        return ResponseEntity.ok(this.organizeStaffService.queryByPage(organizeStaff, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<OrganizeStaff> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.organizeStaffService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param organizeStaff 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<OrganizeStaff> add(@RequestBody OrganizeStaff organizeStaff) {
        return ResponseEntity.ok(this.organizeStaffService.insert(organizeStaff));
    }

    /**
     * 编辑数据
     *
     * @param organizeStaff 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<OrganizeStaff> edit(@RequestBody OrganizeStaff organizeStaff) {
        return ResponseEntity.ok(this.organizeStaffService.update(organizeStaff));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(@Param("id") Integer id) {
        return ResponseEntity.ok(this.organizeStaffService.deleteById(id));
    }

}
