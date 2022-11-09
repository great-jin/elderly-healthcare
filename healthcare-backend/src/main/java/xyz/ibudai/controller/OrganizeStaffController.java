package xyz.ibudai.controller;

import xyz.ibudai.entity.OrganizeStaff;
import xyz.ibudai.service.OrganizeStaffService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OrganizeStaff)表控制层
 *
 * @author Budai
 * @since 2022-03-11 16:21:03
 */
@RestController
@RequestMapping(value = "/api/healthcare/organizeStaff")
public class OrganizeStaffController {
    /**
     * 服务对象
     */
    @Resource
    private OrganizeStaffService organizeStaffService;

    /**
     * 条件查询
     *
     * @param organizeStaff 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<OrganizeStaff>> conditionQuery(OrganizeStaff organizeStaff) {
        return ResponseEntity.ok(this.organizeStaffService.conditionQuery(organizeStaff));
    }

    @GetMapping("/allStaff")
    public ResponseEntity<List<OrganizeStaff>> allStaff() {
        return ResponseEntity.ok(this.organizeStaffService.getAllStaff());
    }

    /**
     * 分页查询
     *
     * @param organizeStaff 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<OrganizeStaff>> queryByPage(OrganizeStaff organizeStaff, PageRequest pageRequest) {
        return ResponseEntity.ok(this.organizeStaffService.queryByPage(organizeStaff, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<OrganizeStaff> queryById(@RequestParam(value = "id") Integer id) {
        return ResponseEntity.ok(this.organizeStaffService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param organizeStaff 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<Boolean> add(@RequestBody OrganizeStaff organizeStaff) {
        return ResponseEntity.ok(this.organizeStaffService.insert(organizeStaff) > 0);
    }

    /**
     * 编辑数据
     *
     * @param organizeStaff 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<Boolean> edit(@RequestBody OrganizeStaff organizeStaff) {
        return ResponseEntity.ok(this.organizeStaffService.update(organizeStaff) > 0);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.organizeStaffService.deleteById(id));
    }

}

