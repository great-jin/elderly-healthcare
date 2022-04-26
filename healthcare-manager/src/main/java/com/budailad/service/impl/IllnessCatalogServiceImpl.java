package com.budailad.service.impl;

import com.budailad.entity.IllnessCatalog;
import com.budailad.dao.IllnessCatalogDao;
import com.budailad.service.IllnessCatalogService;
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
 * (IllnessCatalog)表服务实现类
 *
 * @author Budai
 * @since 2022-03-11 16:21:08
 */
@Service("illnessCatalogService")
@CacheConfig(cacheNames = "illnessCatalog")
public class IllnessCatalogServiceImpl implements IllnessCatalogService {
    @Resource
    private IllnessCatalogDao illnessCatalogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param illId 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(key = "#illId")
    public IllnessCatalog queryById(String illId) {
        return this.illnessCatalogDao.queryById(illId);
    }

    /**
     * 条件查询
     *
     * @param illnessCatalog 筛选条件
     * @return 查询结果
     */
    @Override
    public List<IllnessCatalog> queryAll(IllnessCatalog illnessCatalog) {
        return this.illnessCatalogDao.queryAll(illnessCatalog);
    }

    /**
     * 分页查询
     *
     * @param illnessCatalog 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @Override
    public Page<IllnessCatalog> queryByPage(IllnessCatalog illnessCatalog, PageRequest pageRequest) {
        long total = this.illnessCatalogDao.count(illnessCatalog);
        return new PageImpl<>(this.illnessCatalogDao.queryAllByLimit(illnessCatalog, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param illnessCatalog 实例对象
     * @return 实例对象
     */
    @Override
    public IllnessCatalog insert(IllnessCatalog illnessCatalog) {
        this.illnessCatalogDao.insert(illnessCatalog);
        return illnessCatalog;
    }

    /**
     * 修改数据
     *
     * @param illnessCatalog 实例对象
     * @return 实例对象
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "#illnessCatalog.illId")
    })
    public IllnessCatalog update(IllnessCatalog illnessCatalog) {
        this.illnessCatalogDao.update(illnessCatalog);
        return this.queryById(illnessCatalog.getIllId());
    }

    /**
     * 通过主键删除数据
     *
     * @param illId 主键
     * @return 是否成功
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "#illId")
    })
    public boolean deleteById(String illId) {
        return this.illnessCatalogDao.deleteById(illId) > 0;
    }
}
