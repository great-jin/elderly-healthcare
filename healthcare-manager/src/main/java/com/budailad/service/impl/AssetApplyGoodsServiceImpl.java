package com.budailad.service.impl;

import com.budailad.entity.AssetApplyGoods;
import com.budailad.dao.AssetApplyGoodsDao;
import com.budailad.service.AssetApplyGoodsService;
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
 * (AssetApplyGoods)表服务实现类
 *
 * @author Budai
 * @since 2022-03-28 16:00:22
 */
@Service("assetApplyGoodsService")
@CacheConfig(cacheNames = "applyGoods")
public class AssetApplyGoodsServiceImpl implements AssetApplyGoodsService {
    @Resource
    private AssetApplyGoodsDao assetApplyGoodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(key = "#id")
    public AssetApplyGoods queryById(String id) {
        return this.assetApplyGoodsDao.queryById(id);
    }

    /**
     * 条件查询
     *
     * @param assetApplyGoods 筛选条件
     * @return 查询结果
     */
    @Override
    @Cacheable(key = "'list'")
    public List<AssetApplyGoods> queryAll(AssetApplyGoods assetApplyGoods) {
        return this.assetApplyGoodsDao.queryAll(assetApplyGoods);
    }

    /**
     * 分页查询
     *
     * @param assetApplyGoods 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @Override
    public Page<AssetApplyGoods> queryByPage(AssetApplyGoods assetApplyGoods, PageRequest pageRequest) {
        long total = this.assetApplyGoodsDao.count(assetApplyGoods);
        return new PageImpl<>(this.assetApplyGoodsDao.queryAllByLimit(assetApplyGoods, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param assetApplyGoods 实例对象
     * @return 实例对象
     */
    @Override
    @CacheEvict(key = "'list'")
    public AssetApplyGoods insert(AssetApplyGoods assetApplyGoods) {
        this.assetApplyGoodsDao.insert(assetApplyGoods);
        return assetApplyGoods;
    }

    @Override
    public int insertBatch(List<AssetApplyGoods> applyGoodsList) {
        return this.assetApplyGoodsDao.insertBatch(applyGoodsList);
    }

    /**
     * 修改数据
     *
     * @param assetApplyGoods 实例对象
     * @return 实例对象
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "'list'"),
            @CacheEvict(key = "#assetApplyGoods.id")
    })
    public AssetApplyGoods update(AssetApplyGoods assetApplyGoods) {
        this.assetApplyGoodsDao.update(assetApplyGoods);
        return this.queryById(assetApplyGoods.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "'list'"),
            @CacheEvict(key = "#id")
    })
    public boolean deleteById(String id) {
        return this.assetApplyGoodsDao.deleteById(id) > 0;
    }
}
