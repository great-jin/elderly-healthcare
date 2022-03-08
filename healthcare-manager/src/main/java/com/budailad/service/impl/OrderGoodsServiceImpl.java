package com.budailad.service.impl;

import com.budailad.entity.OrderGoods;
import com.budailad.dao.OrderGoodsDao;
import com.budailad.service.OrderGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (OrderGoods)表服务实现类
 *
 * @Author Budai
 * @Since 2022-03-07 16:25:24
 */
@Service("orderGoodsService")
public class OrderGoodsServiceImpl implements OrderGoodsService {
    @Resource
    private OrderGoodsDao orderGoodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    @Override
    public OrderGoods queryById(String orderId) {
        return this.orderGoodsDao.queryById(orderId);
    }

    /**
     * 分页查询
     *
     * @param orderGoods  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<OrderGoods> queryByPage(OrderGoods orderGoods, PageRequest pageRequest) {
        long total = this.orderGoodsDao.count(orderGoods);
        return new PageImpl<>(this.orderGoodsDao.queryAllByLimit(orderGoods, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param orderGoods 实例对象
     * @return 实例对象
     */
    @Override
    public OrderGoods insert(OrderGoods orderGoods) {
        this.orderGoodsDao.insert(orderGoods);
        return orderGoods;
    }

    /**
     * 修改数据
     *
     * @param orderGoods 实例对象
     * @return 实例对象
     */
    @Override
    public OrderGoods update(OrderGoods orderGoods) {
        this.orderGoodsDao.update(orderGoods);
        return this.queryById(orderGoods.getOrderId());
    }

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String orderId) {
        return this.orderGoodsDao.deleteById(orderId) > 0;
    }
}
