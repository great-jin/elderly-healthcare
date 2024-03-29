package xyz.ibudai.controller;

import xyz.ibudai.entity.PatientBodyInfo;
import xyz.ibudai.entity.PatientCaseInfo;
import xyz.ibudai.service.PatientBodyInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

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
    public ResponseEntity<List<PatientBodyInfo>> conditionQuery(PatientBodyInfo patientBodyInfo) {
        return ResponseEntity.ok(this.patientBodyInfoService.conditionQuery(patientBodyInfo));
    }

    /**
     * 获取图标数据
     *
     * @param patientId
     * @return
     */
    @GetMapping("/getChar")
    public List<PatientBodyInfo> getCharData(@RequestParam(value = "patientId") String patientId) {
        PatientBodyInfo patient = new PatientBodyInfo();
        patient.setPatientId(patientId);
        List<PatientBodyInfo> infoList = patientBodyInfoService.conditionQuery(patient);
        // 获取当前时间前第七天时间
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 8);
        Date sevenDay = calendar.getTime();
        // 获取最新七天身体数据
        List<PatientBodyInfo> resultList = new ArrayList<>();
        infoList.forEach(item -> {
            if ((item.getInTime()).after(sevenDay)) {
                resultList.add(item);
            }
        });
        // 按照登记时间升序排列
        resultList.sort(Comparator.comparing(PatientBodyInfo::getInTime));
        return resultList;
    }


    /**
     * 获取近 n 天的病人身体信息
     *
     * @return
     */
    @GetMapping("/getWarning")
    public List<PatientBodyInfo> getWarning(int day) {
        // 获取当天用户身体信息
        List<PatientBodyInfo> infoList = patientBodyInfoService.conditionQuery(new PatientBodyInfo());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - day);
        Date yesterday = calendar.getTime();
        List<PatientBodyInfo> resultList = new ArrayList<>();
        infoList.forEach(item -> {
            if ((item.getInTime()).after(yesterday)) {
                resultList.add(item);
            }
        });
        return resultList;
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
    public ResponseEntity<PatientBodyInfo> add(@RequestBody PatientBodyInfo patientBodyInfo) {
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
    public ResponseEntity<PatientBodyInfo> edit(@RequestBody PatientBodyInfo patientBodyInfo) {
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

