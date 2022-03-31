package com.budailad.service.impl;

import com.budailad.entity.SysLogs;
import com.budailad.dao.SysLogsDao;
import com.budailad.service.SysLogsService;
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
 * (SysLogs)表服务实现类
 *
 * @author Budai
 * @since 2022-03-11 16:21:08
 */
@Service("sysLogsService")
@CacheConfig(cacheNames = "sysLogs")
public class SysLogsServiceImpl implements SysLogsService {
    @Resource
    private SysLogsDao sysLogsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(key = "#logId")
    public SysLogs queryById(String logId) {
        return this.sysLogsDao.queryById(logId);
    }

    /**
     * 条件查询
     *
     * @param sysLogs 筛选条件
     * @return 查询结果
     */
    @Override
    @Cacheable(key = "'list'")
    public List<SysLogs> queryAll(SysLogs sysLogs) {
        return this.sysLogsDao.queryAll(sysLogs);
    }

    /**
     * 分页查询
     *
     * @param sysLogs     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<SysLogs> queryByPage(SysLogs sysLogs, PageRequest pageRequest) {
        long total = this.sysLogsDao.count(sysLogs);
        return new PageImpl<>(this.sysLogsDao.queryAllByLimit(sysLogs, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param sysLogs 实例对象
     * @return 实例对象
     */
    @Override
    @CacheEvict(key = "'list'")
    public SysLogs insert(SysLogs sysLogs) {
        this.sysLogsDao.insert(sysLogs);
        return sysLogs;
    }

    /**
     * 修改数据
     *
     * @param sysLogs 实例对象
     * @return 实例对象
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "'list'"),
            @CacheEvict(key = "#sysLogs.logId")
    })
    public SysLogs update(SysLogs sysLogs) {
        this.sysLogsDao.update(sysLogs);
        return this.queryById(sysLogs.getLogId());
    }

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 是否成功
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "'list'"),
            @CacheEvict(key = "#logId")
    })
    public boolean deleteById(String logId) {
        return this.sysLogsDao.deleteById(logId) > 0;
    }
}
