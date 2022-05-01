package com.budailad.service.impl;

import com.budailad.entity.PatientCostDetail;
import com.budailad.dao.PatientCostDetailDao;
import com.budailad.service.PatientCostDetailService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PatientCostDetail)表服务实现类
 *
 * @author Budai
 * @since 2022-04-06 14:07:04
 */
@Service("patientCostDetailService")
@CacheConfig(cacheNames = "patientCostDetail")
public class PatientCostDetailServiceImpl implements PatientCostDetailService {
    @Resource
    private PatientCostDetailDao patientCostDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PatientCostDetail queryById(String id) {
        return this.patientCostDetailDao.queryById(id);
    }

    /**
     * 条件查询
     *
     * @param patientCostDetail 筛选条件
     * @return 查询结果
     */
    @Override
    public List<PatientCostDetail> conditionQuery(PatientCostDetail patientCostDetail) {
        return this.patientCostDetailDao.conditionQuery(patientCostDetail);
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
    public PatientCostDetail update(PatientCostDetail patientCostDetail) {
        this.patientCostDetailDao.update(patientCostDetail);
        return this.queryById(patientCostDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.patientCostDetailDao.deleteById(id) > 0;
    }
}
