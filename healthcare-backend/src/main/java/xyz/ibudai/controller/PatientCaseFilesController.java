package xyz.ibudai.controller;

import xyz.ibudai.entity.PatientCaseFiles;
import xyz.ibudai.service.PatientCaseFilesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PatientCaseFiles)表控制层
 *
 * @author Budai
 * @since 2022-03-24 15:54:00
 */
@RestController
@RequestMapping("/api/healthcare/patientCaseFiles")
public class PatientCaseFilesController {
    /**
     * 服务对象
     */
    @Resource
    private PatientCaseFilesService patientCaseFilesService;

    /**
     * 条件查询
     *
     * @param patientCaseFiles 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<PatientCaseFiles>> conditionQuery(PatientCaseFiles patientCaseFiles) {
        return ResponseEntity.ok(this.patientCaseFilesService.conditionQuery(patientCaseFiles));
    }

    /**
     * 分页查询
     *
     * @param patientCaseFiles 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<PatientCaseFiles>> queryByPage(PatientCaseFiles patientCaseFiles, PageRequest pageRequest) {
        return ResponseEntity.ok(this.patientCaseFilesService.queryByPage(patientCaseFiles, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<PatientCaseFiles> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.patientCaseFilesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param patientCaseFiles 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<PatientCaseFiles> add(@RequestBody PatientCaseFiles patientCaseFiles) {
        return ResponseEntity.ok(this.patientCaseFilesService.insert(patientCaseFiles));
    }

    /**
     * 编辑数据
     *
     * @param patientCaseFiles 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<PatientCaseFiles> edit(@RequestBody PatientCaseFiles patientCaseFiles) {
        return ResponseEntity.ok(this.patientCaseFilesService.update(patientCaseFiles));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.patientCaseFilesService.deleteById(id));
    }

}

