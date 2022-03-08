package com.budailad.controller;

import com.budailad.entity.InfoMail;
import com.budailad.service.InfoMailService;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (InfoMail)表控制层
 *
 * @Author Budai
 * @Since 2022-03-07 16:25:00
 */
@RestController
@RequestMapping("/api/healthcare/infoMail")
public class InfoMailController {
    /**
     * 服务对象
     */
    @Resource
    private InfoMailService infoMailService;

    /**
     * 分页查询
     *
     * @param infoMail    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("page")
    public ResponseEntity<Page<InfoMail>> queryByPage(InfoMail infoMail, PageRequest pageRequest) {
        return ResponseEntity.ok(this.infoMailService.queryByPage(infoMail, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<InfoMail> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.infoMailService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param infoMail 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<InfoMail> add(@RequestBody InfoMail infoMail) {
        return ResponseEntity.ok(this.infoMailService.insert(infoMail));
    }

    /**
     * 编辑数据
     *
     * @param infoMail 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<InfoMail> edit(@RequestBody InfoMail infoMail) {
        return ResponseEntity.ok(this.infoMailService.update(infoMail));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(@Param("id") String id) {
        return ResponseEntity.ok(this.infoMailService.deleteById(id));
    }

}

