package com.budailad.controller;

import com.budailad.entity.StaffDoctor;
import com.budailad.service.StaffDoctorService;
import org.springframework.data.domain.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (StaffDoctor)表控制层
 *
 * @author Budai
 * @since 2022-03-11 16:21:08
 */
@RestController
@RequestMapping(value = "/api/healthcare/staffDoctor")
public class StaffDoctorController {
    /**
     * 服务对象
     */
    @Resource
    private StaffDoctorService staffDoctorService;

    /**
     * 分页查询
     *
     * @param staffDoctor 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<StaffDoctor>> queryByPage(StaffDoctor staffDoctor, PageRequest pageRequest) {
        return ResponseEntity.ok(this.staffDoctorService.queryByPage(staffDoctor, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<StaffDoctor> queryById(@Param("id") Integer id) {
        return ResponseEntity.ok(this.staffDoctorService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param staffDoctor 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<StaffDoctor> add(StaffDoctor staffDoctor) {
        return ResponseEntity.ok(this.staffDoctorService.insert(staffDoctor));
    }

    /**
     * 编辑数据
     *
     * @param staffDoctor 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<StaffDoctor> edit(StaffDoctor staffDoctor) {
        return ResponseEntity.ok(this.staffDoctorService.update(staffDoctor));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.staffDoctorService.deleteById(id));
    }

}

