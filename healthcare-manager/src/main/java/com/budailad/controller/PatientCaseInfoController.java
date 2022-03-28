package com.budailad.controller;

import com.budailad.entity.PatientCaseInfo;
import com.budailad.service.PatientCaseInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PatientCaseInfo)表控制层
 *
 * @author Budai
 * @since 2022-03-24 15:54:01
 */
@RestController
@RequestMapping("/api/healthcare/patientCaseInfo")
public class PatientCaseInfoController {
    /**
     * 服务对象
     */
    @Resource
    private PatientCaseInfoService patientCaseInfoService;

    /**
     * 分页查询
     *
     * @param patientCaseInfo 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<PatientCaseInfo>> queryByPage(PatientCaseInfo patientCaseInfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.patientCaseInfoService.queryByPage(patientCaseInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<PatientCaseInfo> queryById(@RequestParam("id") String id) {
        return ResponseEntity.ok(this.patientCaseInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param patientCaseInfo 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<PatientCaseInfo> add(PatientCaseInfo patientCaseInfo) {
        return ResponseEntity.ok(this.patientCaseInfoService.insert(patientCaseInfo));
    }

    /**
     * 编辑数据
     *
     * @param patientCaseInfo 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<PatientCaseInfo> edit(PatientCaseInfo patientCaseInfo) {
        return ResponseEntity.ok(this.patientCaseInfoService.update(patientCaseInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.patientCaseInfoService.deleteById(id));
    }

}

