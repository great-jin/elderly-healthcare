package com.budailad.controller;

import com.budailad.entity.AssetApplyGoods;
import com.budailad.service.AssetApplyGoodsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AssetApplyGoods)表控制层
 *
 * @author Budai
 * @since 2022-03-28 16:00:21
 */
@RestController
@RequestMapping("/api/healthcare/assetApplyGoods")
public class AssetApplyGoodsController {
    /**
     * 服务对象
     */
    @Resource
    private AssetApplyGoodsService assetApplyGoodsService;

    /**
     * 分页查询
     *
     * @param assetApplyGoods 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<AssetApplyGoods>> queryByPage(AssetApplyGoods assetApplyGoods, PageRequest pageRequest) {
        return ResponseEntity.ok(this.assetApplyGoodsService.queryByPage(assetApplyGoods, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<AssetApplyGoods> queryById(@Param("id") String id) {
        return ResponseEntity.ok(this.assetApplyGoodsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param assetApplyGoods 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<AssetApplyGoods> add(AssetApplyGoods assetApplyGoods) {
        return ResponseEntity.ok(this.assetApplyGoodsService.insert(assetApplyGoods));
    }

    /**
     * 编辑数据
     *
     * @param assetApplyGoods 实体
     * @return 编辑结果
     */
    @PutMapping("/update")
    public ResponseEntity<AssetApplyGoods> edit(AssetApplyGoods assetApplyGoods) {
        return ResponseEntity.ok(this.assetApplyGoodsService.update(assetApplyGoods));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.assetApplyGoodsService.deleteById(id));
    }

}

