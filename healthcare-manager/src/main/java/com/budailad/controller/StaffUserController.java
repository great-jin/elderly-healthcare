package com.budailad.controller;

import com.budailad.entity.StaffUser;
import com.budailad.service.StaffUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (StaffUser)表控制层
 *
 * @author makejava
 * @since 2022-03-07 16:27:51
 */
@RestController
@RequestMapping("staffUser")
public class StaffUserController {
    /**
     * 服务对象
     */
    @Resource
    private StaffUserService staffUserService;

    /**
     * 分页查询
     *
     * @param staffUser   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("page")
    public ResponseEntity<Page<StaffUser>> queryByPage(StaffUser staffUser, PageRequest pageRequest) {
        return ResponseEntity.ok(this.staffUserService.queryByPage(staffUser, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<StaffUser> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.staffUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param staffUser 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<StaffUser> add(@RequestBody StaffUser staffUser) {
        return ResponseEntity.ok(this.staffUserService.insert(staffUser));
    }

    /**
     * 编辑数据
     *
     * @param staffUser 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<StaffUser> edit(@RequestBody StaffUser staffUser) {
        return ResponseEntity.ok(this.staffUserService.update(staffUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(@Param("id") Integer id) {
        return ResponseEntity.ok(this.staffUserService.deleteById(id));
    }

}

