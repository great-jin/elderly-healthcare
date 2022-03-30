package com.budailad.service.impl;

import com.budailad.entity.PatientInfo;
import com.budailad.dao.PatientInfoDao;
import com.budailad.service.PatientInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (PatientInfo)表服务实现类
 *
 * @author Budai
 * @since 2022-03-29 15:57:13
 */
@Service("patientInfoService")
public class PatientInfoServiceImpl implements PatientInfoService {
    @Resource
    private PatientInfoDao patientInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param patientId 主键
     * @return 实例对象
     */
    @Override
    public PatientInfo queryById(String patientId) {
        return this.patientInfoDao.queryById(patientId);
    }

    /**
     * 分页查询
     *
     * @param patientInfo 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<PatientInfo> queryByPage(PatientInfo patientInfo, PageRequest pageRequest) {
        long total = this.patientInfoDao.count(patientInfo);
        return new PageImpl<>(this.patientInfoDao.queryAllByLimit(patientInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param patientInfo 实例对象
     * @return 实例对象
     */
    @Override
    public PatientInfo insert(PatientInfo patientInfo) {
        this.patientInfoDao.insert(patientInfo);
        return patientInfo;
    }

    /**
     * 修改数据
     *
     * @param patientInfo 实例对象
     * @return 实例对象
     */
    @Override
    public PatientInfo update(PatientInfo patientInfo) {
        this.patientInfoDao.update(patientInfo);
        return this.queryById(patientInfo.getPatientId());
    }

    /**
     * 通过主键删除数据
     *
     * @param patientId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String patientId) {
        return this.patientInfoDao.deleteById(patientId) > 0;
    }
}
