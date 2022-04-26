package com.budailad.service.impl;

import com.budailad.entity.MedicineCatalog;
import com.budailad.dao.MedicineCatalogDao;
import com.budailad.service.MedicineCatalogService;
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
 * (MedicineCatalog)表服务实现类
 *
 * @author Budai
 * @since 2022-03-11 16:21:04
 */
@Service("medicineCatalogService")
@CacheConfig(cacheNames = "medicineCatalog")
public class MedicineCatalogServiceImpl implements MedicineCatalogService {
    @Resource
    private MedicineCatalogDao medicineCatalogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param drugId 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(key = "#drugId")
    public MedicineCatalog queryById(String drugId) {
        return this.medicineCatalogDao.queryById(drugId);
    }

    /**
     * 条件查询
     *
     * @param medicineCatalog 筛选条件
     * @return 查询结果
     */
    @Override
    public List<MedicineCatalog> queryAll(MedicineCatalog medicineCatalog) {
        return this.medicineCatalogDao.queryAll(medicineCatalog);
    }

    /**
     * 分页查询
     *
     * @param medicineCatalog 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @Override
    public Page<MedicineCatalog> queryByPage(MedicineCatalog medicineCatalog, PageRequest pageRequest) {
        long total = this.medicineCatalogDao.count(medicineCatalog);
        return new PageImpl<>(this.medicineCatalogDao.queryAllByLimit(medicineCatalog, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param medicineCatalog 实例对象
     * @return 实例对象
     */
    @Override
    public MedicineCatalog insert(MedicineCatalog medicineCatalog) {
        this.medicineCatalogDao.insert(medicineCatalog);
        return medicineCatalog;
    }

    /**
     * 修改数据
     *
     * @param medicineCatalog 实例对象
     * @return 实例对象
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "#medicineCatalog.drugId")
    })
    public MedicineCatalog update(MedicineCatalog medicineCatalog) {
        this.medicineCatalogDao.update(medicineCatalog);
        return this.queryById(medicineCatalog.getDrugId());
    }

    /**
     * 通过主键删除数据
     *
     * @param drugId 主键
     * @return 是否成功
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "#drugId")
    })
    public boolean deleteById(String drugId) {
        return this.medicineCatalogDao.deleteById(drugId) > 0;
    }
}
