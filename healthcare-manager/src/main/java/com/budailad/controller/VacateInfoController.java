package com.budailad.controller;

import com.budailad.entity.VacateInfo;
import com.budailad.service.VacateInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * (VacateInfo)表控制层
 *
 * @author Budai
 * @since 2022-03-29 15:38:01
 */
@RestController
@RequestMapping("/api/healthcare/vacateInfo")
public class VacateInfoController {
    /**
     * 服务对象
     */
    @Resource
    private VacateInfoService vacateInfoService;

    /**
     * 条件查询
     *
     * @param vacateInfo 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<VacateInfo>> conditionQuery(VacateInfo vacateInfo) {
        return ResponseEntity.ok(this.vacateInfoService.conditionQuery(vacateInfo));
    }

    /**
     * 分页查询
     *
     * @param vacateInfo  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<VacateInfo>> queryByPage(VacateInfo vacateInfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.vacateInfoService.queryByPage(vacateInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<VacateInfo> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.vacateInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param vacateInfo 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<Boolean> add(@RequestBody VacateInfo vacateInfo) {
        boolean tag = false;
        vacateInfo.setId(UUID.randomUUID().toString());
        if (vacateInfoService.insert(vacateInfo) != null) {
            tag = true;
        }
        return ResponseEntity.ok(tag);
    }

    /**
     * 编辑数据
     *
     * @param vacateInfo 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<Boolean> edit(@RequestBody VacateInfo vacateInfo) {
        return ResponseEntity.ok(this.vacateInfoService.update(vacateInfo) > 0);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.vacateInfoService.deleteById(id));
    }

}

