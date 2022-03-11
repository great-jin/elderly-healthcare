package com.budailad.service;

import com.budailad.entity.OrderGoods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (OrderGoods)表服务接口
 *
 * @author Budai
 * @since 2022-03-11 16:21:05
 */
public interface OrderGoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    OrderGoods queryById(String orderId);

    /**
     * 分页查询
     *
     * @param orderGoods  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<OrderGoods> queryByPage(OrderGoods orderGoods, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param orderGoods 实例对象
     * @return 实例对象
     */
    OrderGoods insert(OrderGoods orderGoods);

    /**
     * 修改数据
     *
     * @param orderGoods 实例对象
     * @return 实例对象
     */
    OrderGoods update(OrderGoods orderGoods);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    boolean deleteById(String orderId);

}
