package com.budailad.controller;

import com.budailad.entity.PatientContact;
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

/**
 * (PatientCostDetail)表控制层
 *
 * @author Budai
 * @since 2022-04-06 14:07:04
 */
@RestController
@RequestMapping("/api/healthcare/patientCostDetail")
public class PatientCostDetailController {
    /**
     * 服务对象
     */
    @Resource
    private PatientCostDetailService patientCostDetailService;

    @Resource
    private PatientCostInfoService patientCostInfoService;

    /**
     * 条件查询
     *
     * @param patientCostDetail 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<PatientCostDetail>> queryAll(PatientCostDetail patientCostDetail) {
        return ResponseEntity.ok(this.patientCostDetailService.queryAll(patientCostDetail));
    }

    @GetMapping("/getCost")
    public ResponseEntity<List<PatientCostDetail>> getPatientCost(String Id) {
        // 查询病人消费表信息编号
        PatientCostInfo costInfo = new PatientCostInfo();
        costInfo.setPatientId(Id);
        List<PatientCostInfo> infoList = patientCostInfoService.queryAll(costInfo);
        String costId = infoList.get(0).getCostId();

        // 根据编号查询所有消费记录
        PatientCostDetail patientCostDetail = new PatientCostDetail();
        patientCostDetail.setCostId(costId);
        return ResponseEntity.ok(this.patientCostDetailService.queryAll(patientCostDetail));
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
    public ResponseEntity<PatientCostDetail> add(@RequestBody PatientCostDetail patientCostDetail) {
        return ResponseEntity.ok(this.patientCostDetailService.insert(patientCostDetail));
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
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.patientCostDetailService.deleteById(id));
    }

}

