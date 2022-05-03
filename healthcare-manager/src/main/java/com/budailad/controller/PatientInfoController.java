package com.budailad.controller;

import com.budailad.entity.PatientContact;
import com.budailad.entity.PatientInfo;
import com.budailad.entity.dto.JsonData;
import com.budailad.service.PatientContactService;
import com.budailad.service.PatientInfoService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * (PatientInfo)表控制层
 *
 * @author Budai
 * @since 2022-03-29 15:57:12
 */
@RestController
@RequestMapping("/api/healthcare/patientInfo")
public class PatientInfoController {
    /**
     * 服务对象
     */
    @Resource
    private PatientInfoService patientInfoService;

    @Resource
    private PatientContactService patientContactService;

    /**
     * 条件查询
     *
     * @param patientInfo 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<PatientInfo>> conditionQuery(PatientInfo patientInfo) {
        return ResponseEntity.ok(this.patientInfoService.conditionQuery(patientInfo));
    }

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
    public ResponseEntity<PatientInfo> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.patientInfoService.queryById(id));
    }

    @GetMapping("/getChar")
    public ResponseEntity<List<JsonData>> getChar() {
        List<PatientInfo> patientInfoList = patientInfoService.conditionQuery(new PatientInfo());
        List<Integer> ageList = new ArrayList<>();
        patientInfoList.forEach(item -> {
            ageList.add(item.getPatientAge());
        });
        // age < 40
        AtomicInteger age_40 = new AtomicInteger(0);
        // 40< age < 50
        AtomicInteger age_50 = new AtomicInteger(0);
        // 50< age < 60
        AtomicInteger age_60 = new AtomicInteger(0);
        // 60 < age
        AtomicInteger age_70 = new AtomicInteger(0);
        ageList.forEach(item -> {
            if (item <= 40) {
                age_40.getAndIncrement();
            } else if (item <= 50) {
                age_50.getAndIncrement();
            } else if (item <= 60) {
                age_60.getAndIncrement();
            } else {
                age_70.getAndIncrement();
            }
        });
        List<JsonData> charList = new ArrayList<>();
        charList.add(new JsonData("0~40",age_40));
        charList.add(new JsonData("40~55",age_50));
        charList.add(new JsonData("55~65",age_60));
        charList.add(new JsonData("65~100",age_70));
        return ResponseEntity.ok(charList);
    }

    /**
     * 新增数据
     *
     * @param patientInfo 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<Boolean> add(@RequestBody PatientInfo patientInfo) {
        patientInfo.setPatientId(UUID.randomUUID().toString());
        // 获取病人联系人信息
        List<PatientContact> contactList = new ArrayList<>();
        for (PatientContact contact : patientInfo.getContactList()) {
            contact.setId(UUID.randomUUID().toString());
            contact.setPatientId(patientInfo.getPatientId());
            contact.setIsDeleted(0);
            contactList.add(contact);
        }
        boolean tag = false;
        int i = this.patientContactService.insertBatch(contactList);
        if (i > 0) {
            PatientInfo patient = this.patientInfoService.insert(patientInfo);
            if (patient != null) {
                tag = true;
            }
        }
        return ResponseEntity.ok(tag);
    }

    /**
     * 编辑数据
     *
     * @param patientInfo 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public Boolean edit(@RequestBody PatientInfo patientInfo) {
        boolean tag = false;
        // 删除旧联系人数据重新添加
        PatientContact contact = new PatientContact();
        contact.setPatientId(patientInfo.getPatientId());
        List<PatientContact> contactAdd = patientContactService.conditionQuery(contact);
        for (PatientContact con : contactAdd) {
            patientContactService.deleteById(con.getId());
        }
        List<PatientContact> contactEdit = patientInfo.getContactList();
        contactEdit.forEach(co -> {
            co.setId(UUID.randomUUID().toString());
            co.setPatientId(patientInfo.getPatientId());
        });
        int i = patientContactService.insertBatch(contactEdit);

        if (i > 0) {
            // 更新信息
            PatientInfo patientInfo1 = patientInfoService.update(patientInfo);
            if (patientInfo1 != null) {
                tag = true;
            }
        }

        return tag;
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

