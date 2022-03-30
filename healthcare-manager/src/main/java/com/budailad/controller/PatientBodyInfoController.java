package com.budailad.controller;

import com.budailad.entity.PatientBodyInfo;
import com.budailad.entity.PatientCaseInfo;
import com.budailad.service.PatientBodyInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * (PatientBodyInfo)表控制层
 *
 * @author Budai
 * @since 2022-03-30 09:20:20
 */
@RestController
@RequestMapping("/api/healthcare/patientBodyInfo")
public class PatientBodyInfoController {
    /**
     * 服务对象
     */
    @Resource
    private PatientBodyInfoService patientBodyInfoService;

    /**
     * 条件查询
     *
     * @param patientBodyInfo 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<PatientBodyInfo>> queryAll(PatientBodyInfo patientBodyInfo) {
        return ResponseEntity.ok(this.patientBodyInfoService.queryAll(patientBodyInfo));
    }

    /**
     * 分页查询
     *
     * @param patientBodyInfo 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<PatientBodyInfo>> queryByPage(PatientBodyInfo patientBodyInfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.patientBodyInfoService.queryByPage(patientBodyInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<PatientBodyInfo> queryById(@RequestParam("id") String id) {
        return ResponseEntity.ok(this.patientBodyInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param patientBodyInfo 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<PatientBodyInfo> add(PatientBodyInfo patientBodyInfo) {
        return ResponseEntity.ok(this.patientBodyInfoService.insert(patientBodyInfo));
    }

    @PostMapping("/addBatch")
    public ResponseEntity<Integer> addBatch(@RequestBody PatientCaseInfo patientCaseInfo) {
        List<PatientBodyInfo> infoList = new ArrayList<>();
        for (PatientBodyInfo info : patientCaseInfo.getPatientBodyInfoList()) {
            info.setId(UUID.randomUUID().toString());
            info.setPatientId(patientCaseInfo.getPatientId());
            infoList.add(info);
        }
        return ResponseEntity.ok(this.patientBodyInfoService.insertBatch(infoList));
    }

    /**
     * 编辑数据
     *
     * @param patientBodyInfo 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<PatientBodyInfo> edit(PatientBodyInfo patientBodyInfo) {
        return ResponseEntity.ok(this.patientBodyInfoService.update(patientBodyInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.patientBodyInfoService.deleteById(id));
    }

}

