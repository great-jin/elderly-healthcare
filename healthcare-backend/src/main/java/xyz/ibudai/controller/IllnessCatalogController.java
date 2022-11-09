package xyz.ibudai.controller;

import xyz.ibudai.entity.IllnessCatalog;
import xyz.ibudai.service.IllnessCatalogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (IllnessCatalog)表控制层
 *
 * @author Budai
 * @since 2022-03-11 16:21:08
 */
@RestController
@RequestMapping(value = "/api/healthcare/illnessCatalog")
public class IllnessCatalogController {
    /**
     * 服务对象
     */
    @Resource
    private IllnessCatalogService illnessCatalogService;

    /**
     * 条件查询
     *
     * @param illnessCatalog 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<IllnessCatalog>> conditionQuery(IllnessCatalog illnessCatalog) {
        return ResponseEntity.ok(this.illnessCatalogService.conditionQuery(illnessCatalog));
    }

    /**
     * 分页查询
     *
     * @param illnessCatalog 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<IllnessCatalog>> queryByPage(IllnessCatalog illnessCatalog, PageRequest pageRequest) {
        return ResponseEntity.ok(this.illnessCatalogService.queryByPage(illnessCatalog, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<IllnessCatalog> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.illnessCatalogService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param illnessCatalog 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<IllnessCatalog> add(@RequestBody IllnessCatalog illnessCatalog) {
        return ResponseEntity.ok(this.illnessCatalogService.insert(illnessCatalog));
    }

    /**
     * 编辑数据
     *
     * @param illnessCatalog 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<IllnessCatalog> edit(@RequestBody IllnessCatalog illnessCatalog) {
        return ResponseEntity.ok(this.illnessCatalogService.update(illnessCatalog));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.illnessCatalogService.deleteById(id));
    }

}

