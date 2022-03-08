package com.budailad.controller;

import com.budailad.entity.RegisterTemplate;
import com.budailad.service.RegisterTemplateService;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RegisterTemplate)表控制层
 *
 * @Author Budai
 * @Since 2022-03-07 16:26:22
 */
@RestController
@RequestMapping("/api/healthcare/registerTemplate")
public class RegisterTemplateController {
    /**
     * 服务对象
     */
    @Resource
    private RegisterTemplateService registerTemplateService;

    /**
     * 分页查询
     *
     * @param registerTemplate 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("page")
    public ResponseEntity<Page<RegisterTemplate>> queryByPage(RegisterTemplate registerTemplate, PageRequest pageRequest) {
        return ResponseEntity.ok(this.registerTemplateService.queryByPage(registerTemplate, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<RegisterTemplate> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.registerTemplateService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param registerTemplate 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<RegisterTemplate> add(@RequestBody RegisterTemplate registerTemplate) {
        return ResponseEntity.ok(this.registerTemplateService.insert(registerTemplate));
    }

    /**
     * 编辑数据
     *
     * @param registerTemplate 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<RegisterTemplate> edit(@RequestBody RegisterTemplate registerTemplate) {
        return ResponseEntity.ok(this.registerTemplateService.update(registerTemplate));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(@Param("id") String id) {
        return ResponseEntity.ok(this.registerTemplateService.deleteById(id));
    }

}

