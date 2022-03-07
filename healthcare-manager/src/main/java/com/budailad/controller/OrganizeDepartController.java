package com.budailad.controller;

import com.budailad.entity.OrganizeDepart;
import com.budailad.service.OrganizeDepartService;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (OrganizeDepart)表控制层
 *
 * @author makejava
 * @since 2022-03-07 16:25:34
 */
@RestController
@RequestMapping("organizeDepart")
public class OrganizeDepartController {
    /**
     * 服务对象
     */
    @Resource
    private OrganizeDepartService organizeDepartService;

    /**
     * 分页查询
     *
     * @param organizeDepart 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @GetMapping("page")
    public ResponseEntity<Page<OrganizeDepart>> queryByPage(OrganizeDepart organizeDepart, PageRequest pageRequest) {
        return ResponseEntity.ok(this.organizeDepartService.queryByPage(organizeDepart, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<OrganizeDepart> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.organizeDepartService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param organizeDepart 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<OrganizeDepart> add(@RequestBody OrganizeDepart organizeDepart) {
        return ResponseEntity.ok(this.organizeDepartService.insert(organizeDepart));
    }

    /**
     * 编辑数据
     *
     * @param organizeDepart 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<OrganizeDepart> edit(@RequestBody OrganizeDepart organizeDepart) {
        return ResponseEntity.ok(this.organizeDepartService.update(organizeDepart));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(@Param("id") String id) {
        return ResponseEntity.ok(this.organizeDepartService.deleteById(id));
    }

}

