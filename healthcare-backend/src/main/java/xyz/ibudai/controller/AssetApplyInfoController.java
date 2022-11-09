package xyz.ibudai.controller;

import xyz.ibudai.entity.AssetApplyGoods;
import xyz.ibudai.entity.AssetApplyInfo;
import xyz.ibudai.service.AssetApplyGoodsService;
import xyz.ibudai.service.AssetApplyInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

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
     * 服务对象
     */
    @Resource
    private AssetApplyGoodsService assetApplyGoodsService;

    /**
     * 条件查询
     *
     * @param assetApplyInfo 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<AssetApplyInfo>> conditionQuery(AssetApplyInfo assetApplyInfo) {
        return ResponseEntity.ok(this.assetApplyInfoService.conditionQuery(assetApplyInfo));
    }

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
    public ResponseEntity<AssetApplyInfo> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.assetApplyInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param assetApplyInfo 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<Boolean> add(@RequestBody AssetApplyInfo assetApplyInfo) {
        assetApplyInfo.setApplyId(UUID.randomUUID().toString());
        assetApplyInfo.setCurrentState(0);
        assetApplyInfo.setIsFinished(0);
        List<AssetApplyGoods> applyGoodsList = assetApplyInfo.getApplyGoodsList();
        // 申请货物关联申请表
        applyGoodsList.forEach(item -> {
            item.setId(UUID.randomUUID().toString());
            item.setApplyId(assetApplyInfo.getApplyId());
        });
        int i = assetApplyGoodsService.insertBatch(applyGoodsList);
        boolean tag = false;
        if (i > 0) {
            if (assetApplyInfoService.insert(assetApplyInfo) != null) {
                tag = true;
            }
        }
        return ResponseEntity.ok(tag);
    }

    /**
     * 编辑数据
     *
     * @param assetApplyInfo 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<Boolean> edit(@RequestBody AssetApplyInfo assetApplyInfo) {
        return ResponseEntity.ok(this.assetApplyInfoService.update(assetApplyInfo) > 0);
    }

    /**
     * 删除数据
     *
     * @param applyId
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String applyId) {
        int i = assetApplyGoodsService.deleteByApplyId(applyId);
        int j = this.assetApplyInfoService.deleteById(applyId);
        return ResponseEntity.ok(i > 0 & j > 0);
    }

}

