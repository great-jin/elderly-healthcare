package com.budailad.service.impl;

import com.budailad.entity.OrderGoods;
import com.budailad.dao.OrderGoodsDao;
import com.budailad.service.OrderGoodsService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OrderGoods)表服务实现类
 *
 * @author Budai
 * @since 2022-03-11 16:21:05
 */
@Service("orderGoodsService")
@CacheConfig(cacheNames = "orderGoods")
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
    @Cacheable(key = "#orderId")
    public OrderGoods queryById(String orderId) {
        return this.orderGoodsDao.queryById(orderId);
    }

    /**
     * 条件查询
     *
     * @param orderGoods 筛选条件
     * @return 查询结果
     */
    @Override
    public List<OrderGoods> queryAll(OrderGoods orderGoods) {
        return this.orderGoodsDao.queryAll(orderGoods);
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
    @Caching(evict = {
            @CacheEvict(key = "#orderGoods.orderId")
    })
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
    @Caching(evict = {
            @CacheEvict(key = "#orderId")
    })
    public boolean deleteById(String orderId) {
        return this.orderGoodsDao.deleteById(orderId) > 0;
    }
}
