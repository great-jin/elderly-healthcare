package com.budailad.service.impl;

import com.budailad.entity.PatientBodyInfo;
import com.budailad.dao.PatientBodyInfoDao;
import com.budailad.service.PatientBodyInfoService;
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
    public List<PatientBodyInfo> queryAll(PatientBodyInfo patientBodyInfo) {
        return this.patientBodyInfoDao.queryAll(patientBodyInfo);
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
     * 修改数据
     *
     * @param patientBodyInfo 实例对象
     * @return 实例对象
     */
    @Override
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
    public boolean deleteById(String id) {
        return this.patientBodyInfoDao.deleteById(id) > 0;
    }
}
