package com.budailad.controller;

import com.budailad.entity.OrderGoods;
import com.budailad.service.OrderGoodsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * (OrderGoods)表控制层
 *
 * @author Budai
 * @since 2022-03-11 16:21:05
 */
@RestController
@RequestMapping(value = "/api/healthcare/orderGoods")
public class OrderGoodsController {
    /**
     * 服务对象
     */
    @Resource
    private OrderGoodsService orderGoodsService;

    /**
     * 条件查询
     *
     * @param orderGoods 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public ResponseEntity<List<OrderGoods>> conditionQuery(OrderGoods orderGoods) {
        return ResponseEntity.ok(this.orderGoodsService.conditionQuery(orderGoods));
    }

    /**
     * 分页查询
     *
     * @param orderGoods  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<OrderGoods>> queryByPage(OrderGoods orderGoods, PageRequest pageRequest) {
        return ResponseEntity.ok(this.orderGoodsService.queryByPage(orderGoods, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<OrderGoods> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.orderGoodsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param orderGoods 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<Boolean> add(@RequestBody OrderGoods orderGoods) {
        orderGoods.setOrderId(UUID.randomUUID().toString());
        return ResponseEntity.ok(this.orderGoodsService.insert(orderGoods) > 0);
    }

    /**
     * 编辑数据
     *
     * @param orderGoods 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<OrderGoods> edit(@RequestBody OrderGoods orderGoods) {
        return ResponseEntity.ok(this.orderGoodsService.update(orderGoods));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.orderGoodsService.deleteById(id));
    }

}

