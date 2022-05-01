package com.budailad.controller;

import com.budailad.entity.MailInfo;
import com.budailad.service.MailInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MailInfo)表控制层
 *
 * @author Budai
 * @since 2022-03-11 16:21:06
 */
@RestController
@RequestMapping(value = "/api/healthcare/mailInfo")
public class MailInfoController {
    /**
     * 服务对象
     */
    @Resource
    private MailInfoService mailInfoService;

    /**
     * 条件查询
     *
     * @param mailInfo    筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<MailInfo>> conditionQuery(MailInfo mailInfo) {
        return ResponseEntity.ok(this.mailInfoService.conditionQuery(mailInfo));
    }

    /**
     * 分页查询
     *
     * @param mailInfo    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<MailInfo>> queryByPage(MailInfo mailInfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.mailInfoService.queryByPage(mailInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<MailInfo> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.mailInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param mailInfo 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<MailInfo> add(@RequestBody MailInfo mailInfo) {
        return ResponseEntity.ok(this.mailInfoService.insert(mailInfo));
    }

    /**
     * 编辑数据
     *
     * @param mailInfo 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<MailInfo> edit(@RequestBody MailInfo mailInfo) {
        return ResponseEntity.ok(this.mailInfoService.update(mailInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.mailInfoService.deleteById(id));
    }

}

