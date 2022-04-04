package com.budailad.controller;

import com.budailad.entity.HomeMenu;
import com.budailad.service.HomeMenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (HomeMenu)表控制层
 *
 * @author makejava
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
    public ResponseEntity<List<HomeMenu>> queryAll(HomeMenu homeMenu) {
        return ResponseEntity.ok(this.homeMenuService.queryAll(homeMenu));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<HomeMenu> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.homeMenuService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param homeMenu 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<HomeMenu> add(HomeMenu homeMenu) {
        return ResponseEntity.ok(this.homeMenuService.insert(homeMenu));
    }

    /**
     * 编辑数据
     *
     * @param homeMenu 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<HomeMenu> edit(HomeMenu homeMenu) {
        return ResponseEntity.ok(this.homeMenuService.update(homeMenu));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.homeMenuService.deleteById(id));
    }

}

