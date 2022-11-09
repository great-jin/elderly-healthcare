package xyz.ibudai.controller;

import xyz.ibudai.entity.PatientContact;
import xyz.ibudai.service.PatientContactService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PatientContact)表控制层
 *
 * @author Budai
 * @since 2022-03-28 16:00:20
 */
@RestController
@RequestMapping("/api/healthcare/patientContact")
public class PatientContactController {
    /**
     * 服务对象
     */
    @Resource
    private PatientContactService patientContactService;

    /**
     * 条件查询
     *
     * @param patientContact 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<PatientContact>> conditionQuery(PatientContact patientContact) {
        return ResponseEntity.ok(this.patientContactService.conditionQuery(patientContact));
    }

    /**
     * 分页查询
     *
     * @param patientContact 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<PatientContact>> queryByPage(PatientContact patientContact, PageRequest pageRequest) {
        return ResponseEntity.ok(this.patientContactService.queryByPage(patientContact, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<PatientContact> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.patientContactService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param patientContact 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<PatientContact> add(@RequestBody PatientContact patientContact) {
        return ResponseEntity.ok(this.patientContactService.insert(patientContact));
    }

    /**
     * 编辑数据
     *
     * @param patientContact 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<PatientContact> edit(@RequestBody PatientContact patientContact) {
        return ResponseEntity.ok(this.patientContactService.update(patientContact));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.patientContactService.deleteById(id));
    }

}

