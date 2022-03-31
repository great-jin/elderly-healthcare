package com.budailad.service.impl;

import com.budailad.entity.PaitentCostDetail;
import com.budailad.dao.PaitentCostDetailDao;
import com.budailad.service.PaitentCostDetailService;
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
 * (PaitentCostDetail)表服务实现类
 *
 * @author Budai
 * @since 2022-03-11 16:21:06
 */
@Service("paitentCostDetailService")
@CacheConfig(cacheNames = "paitentCostDetail")
public class PaitentCostDetailServiceImpl implements PaitentCostDetailService {
    @Resource
    private PaitentCostDetailDao paitentCostDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param costId 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(key = "#costId")
    public PaitentCostDetail queryById(String costId) {
        return this.paitentCostDetailDao.queryById(costId);
    }

    /**
     * 条件查询
     *
     * @param paitentCostDetail 筛选条件
     * @return 查询结果
     */
    @Override
    @Cacheable(key = "'list'")
    public List<PaitentCostDetail> queryAll(PaitentCostDetail paitentCostDetail) {
        return this.paitentCostDetailDao.queryAll(paitentCostDetail);
    }

    /**
     * 分页查询
     *
     * @param paitentCostDetail 筛选条件
     * @param pageRequest       分页对象
     * @return 查询结果
     */
    @Override
    public Page<PaitentCostDetail> queryByPage(PaitentCostDetail paitentCostDetail, PageRequest pageRequest) {
        long total = this.paitentCostDetailDao.count(paitentCostDetail);
        return new PageImpl<>(this.paitentCostDetailDao.queryAllByLimit(paitentCostDetail, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param paitentCostDetail 实例对象
     * @return 实例对象
     */
    @Override
    @CacheEvict(key = "'list'")
    public PaitentCostDetail insert(PaitentCostDetail paitentCostDetail) {
        this.paitentCostDetailDao.insert(paitentCostDetail);
        return paitentCostDetail;
    }

    /**
     * 修改数据
     *
     * @param paitentCostDetail 实例对象
     * @return 实例对象
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "'list'"),
            @CacheEvict(key = "#paitentCostDetail.costId")
    })
    public PaitentCostDetail update(PaitentCostDetail paitentCostDetail) {
        this.paitentCostDetailDao.update(paitentCostDetail);
        return this.queryById(paitentCostDetail.getCostId());
    }

    /**
     * 通过主键删除数据
     *
     * @param costId 主键
     * @return 是否成功
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "'list'"),
            @CacheEvict(key = "#costId")
    })
    public boolean deleteById(String costId) {
        return this.paitentCostDetailDao.deleteById(costId) > 0;
    }
}
