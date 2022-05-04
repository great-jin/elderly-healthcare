package com.budailad.controller;

import com.alibaba.excel.write.metadata.WriteSheet;
import com.budailad.entity.EmployeeSalary;
import com.budailad.service.EmployeeSalaryService;
import com.budailad.service.SalaryDetailFilesService;
import com.budailad.utils.MinioUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * (EmployeeSalary)表控制层
 *
 * @author Budai
 * @since 2022-03-11 16:21:07
 */
@RestController
@RequestMapping(value = "/api/healthcare/employeeSalary")
public class EmployeeSalaryController {

    @Autowired
    private MinioUtil minioUtil;

    /**
     * 服务对象
     */
    @Resource
    private EmployeeSalaryService employeeSalaryService;

    @Resource
    private SalaryDetailFilesService salaryDetailFilesService;


    /**
     * 条件查询
     *
     * @param employeeSalary 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<EmployeeSalary>> conditionQuery(EmployeeSalary employeeSalary) {
        return ResponseEntity.ok(this.employeeSalaryService.conditionQuery(employeeSalary));
    }

    /**
     * 分页查询
     *
     * @param employeeSalary 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<EmployeeSalary>> queryByPage(EmployeeSalary employeeSalary, PageRequest pageRequest) {
        return ResponseEntity.ok(this.employeeSalaryService.queryByPage(employeeSalary, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<EmployeeSalary> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.employeeSalaryService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param employeeSalary 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<Boolean> add(@RequestBody EmployeeSalary employeeSalary) throws Exception {
        employeeSalary.setSalaryId(UUID.randomUUID().toString());
        employeeSalary.setWorkDate(employeeSalary.getWorkDate().substring(0, 7));
        int i = employeeSalaryService.insert(employeeSalary);
        return ResponseEntity.ok(i > 0);
    }

    /**
     * 编辑数据
     *
     * @param employeeSalary 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<EmployeeSalary> edit(@RequestBody EmployeeSalary employeeSalary) {
        return ResponseEntity.ok(this.employeeSalaryService.update(employeeSalary));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.employeeSalaryService.deleteById(id));
    }

    /**
     * 工资文件下载
     *
     * @param staffId
     * @return
     */
    @PostMapping("/download")
    public ResponseEntity<byte[]> Download(@RequestParam(name = "staffId") String staffId) {
        ResponseEntity<byte[]> responseEntity = null;
        // 获取信息
        EmployeeSalary employeeSalary = new EmployeeSalary();
        employeeSalary.setStaffId(staffId);
        List<EmployeeSalary> salaryList = employeeSalaryService.conditionQuery(employeeSalary);
        if (salaryList.size() > 0) {
            try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                // 设置文件名
                employeeSalary = salaryList.get(0);
                String fileName = employeeSalary.getSalaryId() + ".xlsx";
                String orginName = URLEncoder.encode(fileName, "UTF-8");

                List<Map> mapList = new ArrayList<>();
                Map map = new LinkedHashMap();
                map.put("薪资编号", employeeSalary.getSalaryId());
                map.put("员工编号", employeeSalary.getStaffId());
                map.put("员工姓名", employeeSalary.getStaffName());
                map.put("部门编号", employeeSalary.getOrganizeId());
                map.put("部门名称", employeeSalary.getOrganizeName());
                map.put("工作月份", employeeSalary.getWorkDate());
                map.put("工作天数", employeeSalary.getWorkDays());
                map.put("请假天数", employeeSalary.getOffDays());
                map.put("罚款金额", employeeSalary.getDeductCount());
                map.put("保险金额", employeeSalary.getInsuranceCount());
                map.put("补贴金额", employeeSalary.getAllowanceCount());
                map.put("薪资总额", employeeSalary.getSalaryCount());
                mapList.add(map);
                ExcelWriter excelWriter = EasyExcel.write().withTemplate(fileName).file(out).build();
                WriteSheet writeSheet = EasyExcel.writerSheet().build();
                excelWriter.fill(mapList, writeSheet);
                excelWriter.finish();
                byte[] bytes = out.toByteArray();
                //设置header
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.add("Accept-Ranges", "bytes");
                httpHeaders.add("Content-Length", bytes.length + "");
                httpHeaders.add("Content-disposition", "attachment; filename=" + orginName);
                httpHeaders.add("Content-Type", "text/plain;charset=utf-8");
                responseEntity = new ResponseEntity<>(bytes, httpHeaders, HttpStatus.CREATED);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return responseEntity;
    }
}

