package com.budailad.controller;

import com.budailad.entity.PatientCostInfo;
import com.budailad.entity.SysFileConfig;
import com.budailad.service.SysFileConfigService;
import com.budailad.utils.MinioUtil;
import io.minio.messages.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (SysFileConfig)表控制层
 *
 * @author makejava
 * @since 2022-04-06 14:11:13
 */
@RestController
@RequestMapping("/api/healthcare/sysFileConfig")
public class SysFileConfigController {
    /**
     * 服务对象
     */
    @Resource
    private SysFileConfigService sysFileConfigService;

    @Autowired
    private MinioUtil minioUtil;

    @GetMapping("/getBuckets")
    public List<String> getBuckets() throws Exception {
        List<Bucket> buckets = minioUtil.getAllBuckets();
        List<String> bucketList = new ArrayList<>();
        for (Bucket bucket : buckets) {
            bucketList.add(bucket.name());
        }
        return bucketList;
    }

    @GetMapping("/createBucket")
    public void createBuckets(String bucketName) throws Exception {
        minioUtil.createBucket(bucketName);
    }

    @GetMapping("/deleteBucket")
    public void deleteBuckets(String bucketName) throws Exception {
        minioUtil.removeBucket(bucketName);
    }

    /**
     * 条件查询
     *
     * @param sysFileConfig 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<SysFileConfig>> queryAll(SysFileConfig sysFileConfig) {
        return ResponseEntity.ok(this.sysFileConfigService.queryAll(sysFileConfig));
    }

    /**
     * 分页查询
     *
     * @param sysFileConfig 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<SysFileConfig>> queryByPage(SysFileConfig sysFileConfig, PageRequest pageRequest) {
        return ResponseEntity.ok(this.sysFileConfigService.queryByPage(sysFileConfig, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<SysFileConfig> queryById(@RequestParam(value = "id") Integer id) {
        return ResponseEntity.ok(this.sysFileConfigService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysFileConfig 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<SysFileConfig> add(SysFileConfig sysFileConfig) {
        return ResponseEntity.ok(this.sysFileConfigService.insert(sysFileConfig));
    }

    /**
     * 编辑数据
     *
     * @param sysFileConfig 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<SysFileConfig> edit(SysFileConfig sysFileConfig) {
        return ResponseEntity.ok(this.sysFileConfigService.update(sysFileConfig));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.sysFileConfigService.deleteById(id));
    }

}

