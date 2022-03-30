package com.budailad.controller;

import com.budailad.entity.VacateInfo;
import com.budailad.service.VacateInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    public ResponseEntity<VacateInfo> add(VacateInfo vacateInfo) {
        return ResponseEntity.ok(this.vacateInfoService.insert(vacateInfo));
    }

    /**
     * 编辑数据
     *
     * @param vacateInfo 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<VacateInfo> edit(VacateInfo vacateInfo) {
        return ResponseEntity.ok(this.vacateInfoService.update(vacateInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.vacateInfoService.deleteById(id));
    }

}

