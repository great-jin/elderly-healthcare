package xyz.ibudai.controller;

import xyz.ibudai.entity.SysFileConfig;
import xyz.ibudai.service.SysFileConfigService;
import xyz.ibudai.utils.MinioUtil;
import xyz.ibudai.utils.RedisUtils;
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
 * @author Budai
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
    private RedisUtils redisUtils;

    @Autowired
    private MinioUtil minioUtil;

    @GetMapping("/getBuckets")
    public List<String> getBuckets() throws Exception {
        List<Bucket> buckets;
        List<String> bucketList = new ArrayList<>();
        Object object = redisUtils.get("healthcare:sysFileConfig:allbucket");
        if (object == null) {
            buckets = minioUtil.getAllBuckets();
            for (Bucket bucket : buckets) {
                bucketList.add(bucket.name());
            }
            redisUtils.set("healthcare:sysFileConfig:allbucket", bucketList, 1);
        } else {
            bucketList = (List<String>) object;
        }

        return bucketList;
    }

    @GetMapping("/createBucket")
    public boolean createBuckets(String bucketName) throws Exception {
        Object object = redisUtils.get("healthcare:sysFileConfig:allbucket");
        if (object != null) {
            redisUtils.delete("healthcare:sysFileConfig:allbucket");
        }
        if(!minioUtil.bucketExist(bucketName)){
            minioUtil.createBucket(bucketName);
        }else {
            return false;
        }
        return minioUtil.bucketExist(bucketName);
    }

    @GetMapping("/deleteBucket")
    public boolean deleteBuckets(String bucketName) throws Exception {
        Object object = redisUtils.get("healthcare:sysFileConfig:allbucket");
        if (object != null) {
            redisUtils.delete("healthcare:sysFileConfig:allbucket");
        }
        if(!minioUtil.bucketExist(bucketName)){
            minioUtil.removeBucket(bucketName);
        }else {
            return false;
        }
        return !minioUtil.bucketExist(bucketName);
    }

    /**
     * 条件查询
     *
     * @param sysFileConfig 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<SysFileConfig>> conditionQuery(SysFileConfig sysFileConfig) {
        return ResponseEntity.ok(this.sysFileConfigService.conditionQuery(sysFileConfig));
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
    public ResponseEntity<SysFileConfig> add(@RequestBody SysFileConfig sysFileConfig) {
        return ResponseEntity.ok(this.sysFileConfigService.insert(sysFileConfig));
    }

    /**
     * 编辑数据
     *
     * @param sysFileConfig 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<SysFileConfig> edit(@RequestBody SysFileConfig sysFileConfig) {
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

