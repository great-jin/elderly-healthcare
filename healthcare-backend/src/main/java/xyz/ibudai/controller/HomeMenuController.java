package xyz.ibudai.controller;

import xyz.ibudai.entity.HomeMenu;
import xyz.ibudai.service.HomeMenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (HomeMenu)表控制层
 *
 * @author Budai
 * @since 2022-04-04 11:39:32
 */
@RestController
@RequestMapping("/api/healthcare/homeMenu")
public class HomeMenuController {
    /**
     * 服务对象
     */
    @Resource
    private HomeMenuService homeMenuService;

    /**
     * 分页查询
     *
     * @param homeMenu    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<HomeMenu>> queryByPage(HomeMenu homeMenu, PageRequest pageRequest) {
        return ResponseEntity.ok(this.homeMenuService.queryByPage(homeMenu, pageRequest));
    }

    @GetMapping("/list")
    public ResponseEntity<List<HomeMenu>> conditionQuery(HomeMenu homeMenu) {
        return ResponseEntity.ok(this.homeMenuService.conditionQuery(homeMenu));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<HomeMenu> queryById(@RequestParam(value = "id") Integer id) {
        return ResponseEntity.ok(this.homeMenuService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param homeMenu 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<HomeMenu> add(@RequestBody HomeMenu homeMenu) {
        return ResponseEntity.ok(this.homeMenuService.insert(homeMenu));
    }

    /**
     * 编辑数据
     *
     * @param homeMenu 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<HomeMenu> edit(@RequestBody HomeMenu homeMenu) {
        return ResponseEntity.ok(this.homeMenuService.update(homeMenu));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.homeMenuService.deleteById(id));
    }

}

