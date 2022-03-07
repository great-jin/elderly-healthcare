package com.budailad.controller;

import com.budailad.entity.PatientDetails;
import com.budailad.service.PatientDetailsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PatientDetails)表控制层
 *
 * @author makejava
 * @since 2022-03-07 16:26:11
 */
@RestController
@RequestMapping("patientDetails")
public class PatientDetailsController {
    /**
     * 服务对象
     */
    @Resource
    private PatientDetailsService patientDetailsService;

    /**
     * 分页查询
     *
     * @param patientDetails 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @GetMapping("page")
    public ResponseEntity<Page<PatientDetails>> queryByPage(PatientDetails patientDetails, PageRequest pageRequest) {
        return ResponseEntity.ok(this.patientDetailsService.queryByPage(patientDetails, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<PatientDetails> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.patientDetailsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param patientDetails 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<PatientDetails> add(@RequestBody PatientDetails patientDetails) {
        return ResponseEntity.ok(this.patientDetailsService.insert(patientDetails));
    }

    /**
     * 编辑数据
     *
     * @param patientDetails 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<PatientDetails> edit(@RequestBody PatientDetails patientDetails) {
        return ResponseEntity.ok(this.patientDetailsService.update(patientDetails));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(@Param("id") Integer id) {
        return ResponseEntity.ok(this.patientDetailsService.deleteById(id));
    }

}

