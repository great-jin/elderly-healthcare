package xyz.ibudai.controller;

import xyz.ibudai.entity.EmployeeSalary;
import xyz.ibudai.service.EmployeeSalaryService;
import xyz.ibudai.service.SalaryDetailFilesService;
import xyz.ibudai.utils.MinioUtil;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.awt.print.PrinterException;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

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
        String bucketName = "staffsalary";
        String minioPath = "salaryDetails.xlsx";
        ResponseEntity<byte[]> responseEntity = null;
        try (InputStream in = minioUtil.getObject(bucketName, minioPath);
             ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            if (in == null) {
                throw new PrinterException("文件不存在");
            }
            byte[] buffer = new byte[4096];
            int n = 0;
            while ((n = in.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }
            byte[] bytes = out.toByteArray();

            //设置header
            HttpHeaders httpHeaders = new HttpHeaders();
            String orginName = URLEncoder.encode(minioPath, "UTF-8");
            httpHeaders.add("Accept-Ranges", "bytes");
            httpHeaders.add("Content-Length", bytes.length + "");
            httpHeaders.add("Content-disposition", "attachment; filename=" + orginName);
            httpHeaders.add("Content-Type", "text/plain;charset=utf-8");
            responseEntity = new ResponseEntity<>(bytes, httpHeaders, HttpStatus.CREATED);
        } catch (MinioException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}

