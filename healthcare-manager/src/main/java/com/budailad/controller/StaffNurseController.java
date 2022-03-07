package com.budailad.controller;

import com.budailad.entity.StaffNurse;
import com.budailad.service.StaffNurseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (StaffNurse)表控制层
 *
 * @author makejava
 * @since 2022-03-07 16:26:47
 */
@RestController
@RequestMapping("staffNurse")
public class StaffNurseController {
    /**
     * 服务对象
     */
    @Resource
    private StaffNurseService staffNurseService;

    /**
     * 分页查询
     *
     * @param staffNurse  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("page")
    public ResponseEntity<Page<StaffNurse>> queryByPage(StaffNurse staffNurse, PageRequest pageRequest) {
        return ResponseEntity.ok(this.staffNurseService.queryByPage(staffNurse, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<StaffNurse> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.staffNurseService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param staffNurse 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<StaffNurse> add(@RequestBody StaffNurse staffNurse) {
        return ResponseEntity.ok(this.staffNurseService.insert(staffNurse));
    }

    /**
     * 编辑数据
     *
     * @param staffNurse 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<StaffNurse> edit(@RequestBody StaffNurse staffNurse) {
        return ResponseEntity.ok(this.staffNurseService.update(staffNurse));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(@Param("id") Integer id) {
        return ResponseEntity.ok(this.staffNurseService.deleteById(id));
    }

}

