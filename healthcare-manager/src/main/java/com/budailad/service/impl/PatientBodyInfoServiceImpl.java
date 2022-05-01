package com.budailad.service.impl;

import com.budailad.entity.PatientBodyInfo;
import com.budailad.dao.PatientBodyInfoDao;
import com.budailad.service.PatientBodyInfoService;
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
 * (PatientBodyInfo)表服务实现类
 *
 * @author Budai
 * @since 2022-03-30 09:20:21
 */
@Service("patientBodyInfoService")
@CacheConfig(cacheNames = "patientBodyInfo")
public class PatientBodyInfoServiceImpl implements PatientBodyInfoService {
    @Resource
    private PatientBodyInfoDao patientBodyInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(key = "#id")
    public PatientBodyInfo queryById(String id) {
        return this.patientBodyInfoDao.queryById(id);
    }

    /**
     * 条件查询
     *
     * @param patientBodyInfo 筛选条件
     * @return 查询结果
     */
    @Override
    public List<PatientBodyInfo> conditionQuery(PatientBodyInfo patientBodyInfo) {
        return this.patientBodyInfoDao.conditionQuery(patientBodyInfo);
    }

    /**
     * 分页查询
     *
     * @param patientBodyInfo 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @Override
    public Page<PatientBodyInfo> queryByPage(PatientBodyInfo patientBodyInfo, PageRequest pageRequest) {
        long total = this.patientBodyInfoDao.count(patientBodyInfo);
        return new PageImpl<>(this.patientBodyInfoDao.queryAllByLimit(patientBodyInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param patientBodyInfo 实例对象
     * @return 实例对象
     */
    @Override
    public PatientBodyInfo insert(PatientBodyInfo patientBodyInfo) {
        this.patientBodyInfoDao.insert(patientBodyInfo);
        return patientBodyInfo;
    }

    /**
     * 批量新增
     *
     * @param patientBodyInfoList
     * @return
     */
    @Override
    public int insertBatch(List<PatientBodyInfo> patientBodyInfoList) {
        return this.patientBodyInfoDao.insertBatch(patientBodyInfoList);
    }

    /**
     * 修改数据
     *
     * @param patientBodyInfo 实例对象
     * @return 实例对象
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "#patientBodyInfo.id")
    })
    public PatientBodyInfo update(PatientBodyInfo patientBodyInfo) {
        this.patientBodyInfoDao.update(patientBodyInfo);
        return this.queryById(patientBodyInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "#id")
    })
    public boolean deleteById(String id) {
        return this.patientBodyInfoDao.deleteById(id) > 0;
    }
}
