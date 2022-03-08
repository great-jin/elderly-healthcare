package com.budailad.service.impl;

import com.budailad.entity.PatientDetails;
import com.budailad.dao.PatientDetailsDao;
import com.budailad.service.PatientDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (PatientDetails)表服务实现类
 *
 * @Author Budai
 * @Since 2022-03-07 16:26:11
 */
@Service("patientDetailsService")
public class PatientDetailsServiceImpl implements PatientDetailsService {
    @Resource
    private PatientDetailsDao patientDetailsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PatientDetails queryById(Integer id) {
        return this.patientDetailsDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param patientDetails 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @Override
    public Page<PatientDetails> queryByPage(PatientDetails patientDetails, PageRequest pageRequest) {
        long total = this.patientDetailsDao.count(patientDetails);
        return new PageImpl<>(this.patientDetailsDao.queryAllByLimit(patientDetails, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param patientDetails 实例对象
     * @return 实例对象
     */
    @Override
    public PatientDetails insert(PatientDetails patientDetails) {
        this.patientDetailsDao.insert(patientDetails);
        return patientDetails;
    }

    /**
     * 修改数据
     *
     * @param patientDetails 实例对象
     * @return 实例对象
     */
    @Override
    public PatientDetails update(PatientDetails patientDetails) {
        this.patientDetailsDao.update(patientDetails);
        return this.queryById(patientDetails.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.patientDetailsDao.deleteById(id) > 0;
    }
}
