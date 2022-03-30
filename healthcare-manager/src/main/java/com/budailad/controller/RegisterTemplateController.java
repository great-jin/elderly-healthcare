package com.budailad.controller;

import com.budailad.entity.RegisterTemplate;
import com.budailad.service.RegisterTemplateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RegisterTemplate)表控制层
 *
 * @author Budai
 * @since 2022-03-11 16:21:05
 */
@RestController
@RequestMapping(value = "/api/healthcare/registerTemplate")
public class RegisterTemplateController {
    /**
     * 服务对象
     */
    @Resource
    private RegisterTemplateService registerTemplateService;

    /**
     * 条件查询
     *
     * @param registerTemplate 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<RegisterTemplate>> queryAll(RegisterTemplate registerTemplate) {
        return ResponseEntity.ok(this.registerTemplateService.queryAll(registerTemplate));
    }

    /**
     * 分页查询
     *
     * @param registerTemplate 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<RegisterTemplate>> queryByPage(RegisterTemplate registerTemplate, PageRequest pageRequest) {
        return ResponseEntity.ok(this.registerTemplateService.queryByPage(registerTemplate, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<RegisterTemplate> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.registerTemplateService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param registerTemplate 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<RegisterTemplate> add(RegisterTemplate registerTemplate) {
        return ResponseEntity.ok(this.registerTemplateService.insert(registerTemplate));
    }

    /**
     * 编辑数据
     *
     * @param registerTemplate 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<RegisterTemplate> edit(RegisterTemplate registerTemplate) {
        return ResponseEntity.ok(this.registerTemplateService.update(registerTemplate));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.registerTemplateService.deleteById(id));
    }

}

