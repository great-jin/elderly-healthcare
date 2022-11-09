package xyz.ibudai.controller;

import xyz.ibudai.entity.PatientCaseInfo;
import xyz.ibudai.entity.PatientCostInfo;
import xyz.ibudai.service.PatientCaseInfoService;
import xyz.ibudai.service.PatientCostInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

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


    @Resource
    private PatientCostInfoService patientCostInfoService;

    /**
     * 条件查询
     *
     * @param patientCaseInfo
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<PatientCaseInfo>> conditionQuery(PatientCaseInfo patientCaseInfo) {
        return ResponseEntity.ok(this.patientCaseInfoService.conditionQuery(patientCaseInfo));
    }

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
    public ResponseEntity<PatientCaseInfo> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.patientCaseInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param patientCaseInfo 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<Boolean> add(@RequestBody PatientCaseInfo patientCaseInfo) {
        // 生成消费记录
        PatientCostInfo costInfo = new PatientCostInfo();
        costInfo.setCostId(UUID.randomUUID().toString());
        costInfo.setPatientId(patientCaseInfo.getPatientId());
        costInfo.setPatientName(patientCaseInfo.getPatientName());
        costInfo.setDoctorId(patientCaseInfo.getDoctorId());
        costInfo.setDoctorName(patientCaseInfo.getDoctorName());
        costInfo.setInTime(patientCaseInfo.getInTime());
        costInfo.setIsPay(0);
        int i = patientCostInfoService.insert(costInfo);
        // 分配医师护士
        patientCaseInfo.setCaseId(UUID.randomUUID().toString());
        int j = patientCaseInfoService.insert(patientCaseInfo);
        return ResponseEntity.ok(i > 0 && j > 0);
    }

    /**
     * 编辑数据
     *
     * @param patientCaseInfo 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<Boolean> edit(@RequestBody PatientCaseInfo patientCaseInfo) {
        int i = patientCaseInfoService.update(patientCaseInfo);
        return ResponseEntity.ok(i > 0);
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

