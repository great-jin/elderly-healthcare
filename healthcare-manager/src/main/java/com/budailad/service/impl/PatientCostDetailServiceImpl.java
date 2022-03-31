package com.budailad.service.impl;

import com.budailad.entity.PatientCostDetail;
import com.budailad.dao.PatientCostDetailDao;
import com.budailad.service.PatientCostDetailService;
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
public class PatientCostDetailServiceImpl implements PatientCostDetailService {
    @Resource
    private PatientCostDetailDao patientCostDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param costId 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(key = "#costId")
    public PatientCostDetail queryById(String costId) {
        return this.patientCostDetailDao.queryById(costId);
    }

    /**
     * 条件查询
     *
     * @param patientCostDetail 筛选条件
     * @return 查询结果
     */
    @Override
    @Cacheable(key = "'list'")
    public List<PatientCostDetail> queryAll(PatientCostDetail patientCostDetail) {
        return this.patientCostDetailDao.queryAll(patientCostDetail);
    }

    /**
     * 分页查询
     *
     * @param patientCostDetail 筛选条件
     * @param pageRequest       分页对象
     * @return 查询结果
     */
    @Override
    public Page<PatientCostDetail> queryByPage(PatientCostDetail patientCostDetail, PageRequest pageRequest) {
        long total = this.patientCostDetailDao.count(patientCostDetail);
        return new PageImpl<>(this.patientCostDetailDao.queryAllByLimit(patientCostDetail, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param patientCostDetail 实例对象
     * @return 实例对象
     */
    @Override
    @CacheEvict(key = "'list'")
    public PatientCostDetail insert(PatientCostDetail patientCostDetail) {
        this.patientCostDetailDao.insert(patientCostDetail);
        return patientCostDetail;
    }

    /**
     * 修改数据
     *
     * @param patientCostDetail 实例对象
     * @return 实例对象
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "'list'"),
            @CacheEvict(key = "#patientCostDetail.costId")
    })
    public PatientCostDetail update(PatientCostDetail patientCostDetail) {
        this.patientCostDetailDao.update(patientCostDetail);
        return this.queryById(patientCostDetail.getCostId());
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
        return this.patientCostDetailDao.deleteById(costId) > 0;
    }
}
