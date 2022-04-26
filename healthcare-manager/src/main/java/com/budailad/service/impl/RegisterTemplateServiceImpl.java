package com.budailad.service.impl;

import com.budailad.entity.RegisterTemplate;
import com.budailad.dao.RegisterTemplateDao;
import com.budailad.service.RegisterTemplateService;
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
 * (RegisterTemplate)表服务实现类
 *
 * @author Budai
 * @since 2022-03-11 16:21:06
 */
@Service("registerTemplateService")
@CacheConfig(cacheNames = "registerTemplate")
public class RegisterTemplateServiceImpl implements RegisterTemplateService {
    @Resource
    private RegisterTemplateDao registerTemplateDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tempId 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(key = "#tempId")
    public RegisterTemplate queryById(String tempId) {
        return this.registerTemplateDao.queryById(tempId);
    }

    /**
     * 条件查询
     *
     * @param registerTemplate 筛选条件
     * @return 查询结果
     */
    @Override
    public List<RegisterTemplate> queryAll(RegisterTemplate registerTemplate) {
        return this.registerTemplateDao.queryAll(registerTemplate);
    }

    /**
     * 分页查询
     *
     * @param registerTemplate 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<RegisterTemplate> queryByPage(RegisterTemplate registerTemplate, PageRequest pageRequest) {
        long total = this.registerTemplateDao.count(registerTemplate);
        return new PageImpl<>(this.registerTemplateDao.queryAllByLimit(registerTemplate, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param registerTemplate 实例对象
     * @return 实例对象
     */
    @Override
    public RegisterTemplate insert(RegisterTemplate registerTemplate) {
        this.registerTemplateDao.insert(registerTemplate);
        return registerTemplate;
    }

    /**
     * 修改数据
     *
     * @param registerTemplate 实例对象
     * @return 实例对象
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "#registerTemplate.tempId")
    })
    public RegisterTemplate update(RegisterTemplate registerTemplate) {
        this.registerTemplateDao.update(registerTemplate);
        return this.queryById(registerTemplate.getTempId());
    }

    /**
     * 通过主键删除数据
     *
     * @param tempId 主键
     * @return 是否成功
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "#tempId")
    })
    public boolean deleteById(String tempId) {
        return this.registerTemplateDao.deleteById(tempId) > 0;
    }
}
