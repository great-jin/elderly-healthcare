package com.budailad.service.impl;

import com.budailad.entity.SysFileConfig;
import com.budailad.dao.SysFileConfigDao;
import com.budailad.service.SysFileConfigService;
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
 * (SysFileConfig)表服务实现类
 *
 * @author Budai
 * @since 2022-04-06 14:11:13
 */
@Service("sysFileConfigService")
@CacheConfig(cacheNames = "sysFileConfig")
public class SysFileConfigServiceImpl implements SysFileConfigService {
    @Resource
    private SysFileConfigDao sysFileConfigDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysFileConfig queryById(Integer id) {
        return this.sysFileConfigDao.queryById(id);
    }

    /**
     * 条件查询
     *
     * @param sysFileConfig 筛选条件
     * @return 查询结果
     */
    @Override
    public List<SysFileConfig> queryAll(SysFileConfig sysFileConfig) {
        return this.sysFileConfigDao.queryAll(sysFileConfig);
    }

    /**
     * 分页查询
     *
     * @param sysFileConfig 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    @Override
    public Page<SysFileConfig> queryByPage(SysFileConfig sysFileConfig, PageRequest pageRequest) {
        long total = this.sysFileConfigDao.count(sysFileConfig);
        return new PageImpl<>(this.sysFileConfigDao.queryAllByLimit(sysFileConfig, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param sysFileConfig 实例对象
     * @return 实例对象
     */
    @Override
    public SysFileConfig insert(SysFileConfig sysFileConfig) {
        this.sysFileConfigDao.insert(sysFileConfig);
        return sysFileConfig;
    }

    /**
     * 修改数据
     *
     * @param sysFileConfig 实例对象
     * @return 实例对象
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "'list'")
    })
    public SysFileConfig update(SysFileConfig sysFileConfig) {
        this.sysFileConfigDao.update(sysFileConfig);
        return this.queryById(sysFileConfig.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysFileConfigDao.deleteById(id) > 0;
    }
}
