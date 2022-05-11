package com.budailad.controller;

import com.budailad.entity.PatientCostDetail;
import com.budailad.entity.PatientCostInfo;
import com.budailad.service.PatientCostDetailService;
import com.budailad.service.PatientCostInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * (PatientCostDetail)表控制层
 *
 * @author Budai
 * @since 2022-04-06 14:07:04
 */
@RestController
@RequestMapping("/api/healthcare/patientCostDetail")
public class PatientCostDetailController {

    @Resource
    private PatientCostInfoService patientCostInfoService;

    /**
     * 服务对象
     */
    @Resource
    private PatientCostDetailService patientCostDetailService;

    /**
     * 条件查询
     *
     * @param patientCostDetail 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<PatientCostDetail>> conditionQuery(PatientCostDetail patientCostDetail) {
        return ResponseEntity.ok(this.patientCostDetailService.conditionQuery(patientCostDetail));
    }

    @GetMapping("/getCost")
    public ResponseEntity<List<PatientCostDetail>> getPatientCost(String Id) {
        // 查询病人消费表信息编号
        PatientCostInfo costInfo = new PatientCostInfo();
        costInfo.setPatientId(Id);
        List<PatientCostInfo> infoList = patientCostInfoService.conditionQuery(costInfo);
        String costId = infoList.get(0).getCostId();

        // 根据编号查询所有消费记录
        PatientCostDetail patientCostDetail = new PatientCostDetail();
        patientCostDetail.setCostId(costId);
        return ResponseEntity.ok(this.patientCostDetailService.conditionQuery(patientCostDetail));
    }

    /**
     * 分页查询
     *
     * @param patientCostDetail 筛选条件
     * @param pageRequest       分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<PatientCostDetail>> queryByPage(PatientCostDetail patientCostDetail, PageRequest pageRequest) {
        return ResponseEntity.ok(this.patientCostDetailService.queryByPage(patientCostDetail, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<PatientCostDetail> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.patientCostDetailService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param patientCostDetail 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public boolean add(@RequestBody PatientCostDetail patientCostDetail) {
        // 根据病人Id查询消费记录编号
        PatientCostInfo costInfo = new PatientCostInfo();
        costInfo.setPatientId(patientCostDetail.getPatientId());
        costInfo = (patientCostInfoService.conditionQuery(costInfo)).get(0);
        String costID = costInfo.getCostId();
        // 新增消费记录
        patientCostDetail.setId(UUID.randomUUID().toString());
        patientCostDetail.setCostId(costID);
        int i = patientCostDetailService.insert(patientCostDetail);
        return i > 0;
    }

    /**
     * 编辑数据
     *
     * @param patientCostDetail 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<PatientCostDetail> edit(@RequestBody PatientCostDetail patientCostDetail) {
        return ResponseEntity.ok(this.patientCostDetailService.update(patientCostDetail));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @GetMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.patientCostDetailService.deleteById(id));
    }

}

