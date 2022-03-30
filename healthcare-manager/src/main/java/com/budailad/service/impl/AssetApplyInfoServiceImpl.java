package com.budailad.service.impl;

import com.budailad.entity.AssetApplyInfo;
import com.budailad.dao.AssetApplyInfoDao;
import com.budailad.service.AssetApplyInfoService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AssetApplyInfo)表服务实现类
 *
 * @author Budai
 * @since 2022-03-28 16:00:21
 */
@Service("assetApplyInfoService")
@CacheConfig(cacheNames = "applyInfo")
public class AssetApplyInfoServiceImpl implements AssetApplyInfoService {
    @Resource
    private AssetApplyInfoDao assetApplyInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param applyId 主键
     * @return 实例对象
     */
    @Override
    public AssetApplyInfo queryById(String applyId) {
        return this.assetApplyInfoDao.queryById(applyId);
    }

    /**
     * 条件查询
     *
     * @param assetApplyInfo 筛选条件
     * @return 查询结果
     */
    @Override
    @Cacheable(key = "'list'")
    public List<AssetApplyInfo> queryAll(AssetApplyInfo assetApplyInfo) {
        return this.assetApplyInfoDao.queryAll(assetApplyInfo);
    }

    /**
     * 分页查询
     *
     * @param assetApplyInfo 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @Override
    public Page<AssetApplyInfo> queryByPage(AssetApplyInfo assetApplyInfo, PageRequest pageRequest) {
        long total = this.assetApplyInfoDao.count(assetApplyInfo);
        return new PageImpl<>(this.assetApplyInfoDao.queryAllByLimit(assetApplyInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param assetApplyInfo 实例对象
     * @return 实例对象
     */
    @Override
    @CacheEvict(key = "'list'")
    public AssetApplyInfo insert(AssetApplyInfo assetApplyInfo) {
        this.assetApplyInfoDao.insert(assetApplyInfo);
        return assetApplyInfo;
    }

    /**
     * 修改数据
     *
     * @param assetApplyInfo 实例对象
     * @return 实例对象
     */
    @Override
    @CacheEvict(key = "'list'")
    public AssetApplyInfo update(AssetApplyInfo assetApplyInfo) {
        this.assetApplyInfoDao.update(assetApplyInfo);
        return this.queryById(assetApplyInfo.getApplyId());
    }

    /**
     * 通过主键删除数据
     *
     * @param applyId 主键
     * @return 是否成功
     */
    @Override
    @CacheEvict(key = "'list'")
    public boolean deleteById(String applyId) {
        return this.assetApplyInfoDao.deleteById(applyId) > 0;
    }
}
