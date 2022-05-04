package com.budailad.service.impl;

import com.budailad.entity.PatientCaseInfo;
import com.budailad.dao.PatientCaseInfoDao;
import com.budailad.entity.PatientInfo;
import com.budailad.service.PatientCaseInfoService;
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
 * (PatientCaseInfo)表服务实现类
 *
 * @author Budai
 * @since 2022-03-24 15:54:01
 */
@Service("patientCaseInfoService")
@CacheConfig(cacheNames = "patientCaseInfo")
public class PatientCaseInfoServiceImpl implements PatientCaseInfoService {
    @Resource
    private PatientCaseInfoDao patientCaseInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param castId 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(key = "#castId")
    public PatientCaseInfo queryById(String castId) {
        return this.patientCaseInfoDao.queryById(castId);
    }

    /**
     * 条件查询
     *
     * @param patientCaseInfo
     * @return
     */
    @Override
    public List<PatientCaseInfo> conditionQuery(PatientCaseInfo patientCaseInfo) {
        return patientCaseInfoDao.conditionQuery(patientCaseInfo);
    }

    /**
     * 分页查询
     *
     * @param patientCaseInfo 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @Override
    public Page<PatientCaseInfo> queryByPage(PatientCaseInfo patientCaseInfo, PageRequest pageRequest) {
        long total = this.patientCaseInfoDao.count(patientCaseInfo);
        return new PageImpl<>(this.patientCaseInfoDao.queryAllByLimit(patientCaseInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param patientCaseInfo 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(PatientCaseInfo patientCaseInfo) {
        return this.patientCaseInfoDao.insert(patientCaseInfo);
    }

    /**
     * 修改数据
     *
     * @param patientCaseInfo 实例对象
     * @return 实例对象
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "#patientCaseInfo.caseId")
    })
    public int update(PatientCaseInfo patientCaseInfo) {
        return this.patientCaseInfoDao.update(patientCaseInfo);
    }

    /**
     * 通过主键删除数据
     *
     * @param castId 主键
     * @return 是否成功
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "#castId")
    })
    public boolean deleteById(String castId) {
        return this.patientCaseInfoDao.deleteById(castId) > 0;
    }
}
