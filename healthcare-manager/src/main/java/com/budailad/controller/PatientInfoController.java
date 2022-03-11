package com.budailad.controller;

import com.budailad.entity.PatientInfo;
import com.budailad.service.PatientInfoService;
import org.springframework.data.domain.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PatientInfo)表控制层
 *
 * @author Budai
 * @since 2022-03-11 16:21:07
 */
@RestController
@RequestMapping(value = "/api/healthcare/patientInfo")
public class PatientInfoController {
    /**
     * 服务对象
     */
    @Resource
    private PatientInfoService patientInfoService;

    /**
     * 分页查询
     *
     * @param patientInfo 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<PatientInfo>> queryByPage(PatientInfo patientInfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.patientInfoService.queryByPage(patientInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<PatientInfo> queryById(@Param("id") String id) {
        return ResponseEntity.ok(this.patientInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param patientInfo 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<PatientInfo> add(PatientInfo patientInfo) {
        return ResponseEntity.ok(this.patientInfoService.insert(patientInfo));
    }

    /**
     * 编辑数据
     *
     * @param patientInfo 实体
     * @return 编辑结果
     */
    @PutMapping("/update")
    public ResponseEntity<PatientInfo> edit(PatientInfo patientInfo) {
        return ResponseEntity.ok(this.patientInfoService.update(patientInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.patientInfoService.deleteById(id));
    }

}

