package com.budailad.controller;

import com.budailad.entity.TbUser;
import com.budailad.service.TbUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbUser)表控制层
 *
 * @Author Budai
 * @Since 2022-03-07 16:28:27
 */
@RestController
@RequestMapping("/api/healthcare/tbUser")
public class TbUserController {
    /**
     * 服务对象
     */
    @Resource
    private TbUserService tbUserService;

    /**
     * 分页查询
     *
     * @param tbUser      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("page")
    public ResponseEntity<Page<TbUser>> queryByPage(TbUser tbUser, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbUserService.queryByPage(tbUser, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbUser> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tbUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbUser 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<TbUser> add(@RequestBody TbUser tbUser) {
        return ResponseEntity.ok(this.tbUserService.insert(tbUser));
    }

    /**
     * 编辑数据
     *
     * @param tbUser 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<TbUser> edit(@RequestBody TbUser tbUser) {
        return ResponseEntity.ok(this.tbUserService.update(tbUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(@Param("id") Integer id) {
        return ResponseEntity.ok(this.tbUserService.deleteById(id));
    }

}

