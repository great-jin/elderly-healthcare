package com.budailad.controller;

import com.budailad.entity.LoginUser;
import com.budailad.service.LoginUserService;
import org.springframework.data.domain.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (LoginUser)表控制层
 *
 * @author Budai
 * @since 2022-03-11 16:21:07
 */
@RestController
@RequestMapping(value = "/api/healthcare/loginUser")
public class LoginUserController {
    /**
     * 服务对象
     */
    @Resource
    private LoginUserService loginUserService;

    /**
     * 分页查询
     *
     * @param loginUser   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<LoginUser>> queryByPage(LoginUser loginUser, PageRequest pageRequest) {
        return ResponseEntity.ok(this.loginUserService.queryByPage(loginUser, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<LoginUser> queryById(@Param("id") String id) {
        return ResponseEntity.ok(this.loginUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param loginUser 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<LoginUser> add(LoginUser loginUser) {
        return ResponseEntity.ok(this.loginUserService.insert(loginUser));
    }

    /**
     * 编辑数据
     *
     * @param loginUser 实体
     * @return 编辑结果
     */
    @PutMapping("/update")
    public ResponseEntity<LoginUser> edit(LoginUser loginUser) {
        return ResponseEntity.ok(this.loginUserService.update(loginUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.loginUserService.deleteById(id));
    }

}

