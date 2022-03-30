package com.budailad.service.impl;

import com.budailad.entity.PatientCaseInfo;
import com.budailad.dao.PatientCaseInfoDao;
import com.budailad.service.PatientCaseInfoService;
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
    public PatientCaseInfo queryById(String castId) {
        return this.patientCaseInfoDao.queryById(castId);
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
     * 条件查询
     *
     * @param patientCaseInfo
     * @return
     */
    @Override
    public List<PatientCaseInfo> queryAll(PatientCaseInfo patientCaseInfo) {
        return patientCaseInfoDao.queryAll(patientCaseInfo);
    }

    /**
     * 新增数据
     *
     * @param patientCaseInfo 实例对象
     * @return 实例对象
     */
    @Override
    public PatientCaseInfo insert(PatientCaseInfo patientCaseInfo) {
        this.patientCaseInfoDao.insert(patientCaseInfo);
        return patientCaseInfo;
    }

    /**
     * 修改数据
     *
     * @param patientCaseInfo 实例对象
     * @return 实例对象
     */
    @Override
    public PatientCaseInfo update(PatientCaseInfo patientCaseInfo) {
        this.patientCaseInfoDao.update(patientCaseInfo);
        return this.queryById(patientCaseInfo.getCaseId());
    }

    /**
     * 通过主键删除数据
     *
     * @param castId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String castId) {
        return this.patientCaseInfoDao.deleteById(castId) > 0;
    }
}