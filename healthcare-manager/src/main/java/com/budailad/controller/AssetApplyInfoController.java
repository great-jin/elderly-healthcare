package com.budailad.controller;

import com.budailad.entity.AssetApplyInfo;
import com.budailad.service.AssetApplyInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AssetApplyInfo)表控制层
 *
 * @author Budai
 * @since 2022-03-28 16:00:21
 */
@RestController
@RequestMapping("/api/healthcare/assetApplyInfo")
public class AssetApplyInfoController {
    /**
     * 服务对象
     */
    @Resource
    private AssetApplyInfoService assetApplyInfoService;

    /**
     * 分页查询
     *
     * @param assetApplyInfo 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<AssetApplyInfo>> queryByPage(AssetApplyInfo assetApplyInfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.assetApplyInfoService.queryByPage(assetApplyInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<AssetApplyInfo> queryById(@Param("id") String id) {
        return ResponseEntity.ok(this.assetApplyInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param assetApplyInfo 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<AssetApplyInfo> add(AssetApplyInfo assetApplyInfo) {
        return ResponseEntity.ok(this.assetApplyInfoService.insert(assetApplyInfo));
    }

    /**
     * 编辑数据
     *
     * @param assetApplyInfo 实体
     * @return 编辑结果
     */
    @PutMapping("/update")
    public ResponseEntity<AssetApplyInfo> edit(AssetApplyInfo assetApplyInfo) {
        return ResponseEntity.ok(this.assetApplyInfoService.update(assetApplyInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.assetApplyInfoService.deleteById(id));
    }

}

