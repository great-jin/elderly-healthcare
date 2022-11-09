package xyz.ibudai.controller;

import xyz.ibudai.entity.PatientCostInfo;
import xyz.ibudai.service.PatientCostInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PatientCostInfo)表控制层
 *
 * @author Budai
 * @since 2022-04-06 14:07:04
 */
@RestController
@RequestMapping("/api/healthcare/patientCostInfo")
public class PatientCostInfoController {
    /**
     * 服务对象
     */
    @Resource
    private PatientCostInfoService patientCostInfoService;

    /**
     * 条件查询
     *
     * @param patientCostInfo 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<PatientCostInfo>> conditionQuery(PatientCostInfo patientCostInfo) {
        return ResponseEntity.ok(this.patientCostInfoService.conditionQuery(patientCostInfo));
    }

    /**
     * 分页查询
     *
     * @param patientCostInfo 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<PatientCostInfo>> queryByPage(PatientCostInfo patientCostInfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.patientCostInfoService.queryByPage(patientCostInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<PatientCostInfo> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.patientCostInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param patientCostInfo 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<Boolean> add(@RequestBody PatientCostInfo patientCostInfo) {
        return ResponseEntity.ok(this.patientCostInfoService.insert(patientCostInfo)>0);
    }

    /**
     * 编辑数据
     *
     * @param patientCostInfo 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<PatientCostInfo> edit(@RequestBody PatientCostInfo patientCostInfo) {
        return ResponseEntity.ok(this.patientCostInfoService.update(patientCostInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.patientCostInfoService.deleteById(id));
    }

}

