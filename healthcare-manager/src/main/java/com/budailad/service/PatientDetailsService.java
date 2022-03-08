package com.budailad.service;

import com.budailad.entity.PatientDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (PatientDetails)表服务接口
 *
 * @Author Budai
 * @Since 2022-03-07 16:26:11
 */
public interface PatientDetailsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PatientDetails queryById(Integer id);

    /**
     * 分页查询
     *
     * @param patientDetails 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    Page<PatientDetails> queryByPage(PatientDetails patientDetails, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param patientDetails 实例对象
     * @return 实例对象
     */
    PatientDetails insert(PatientDetails patientDetails);

    /**
     * 修改数据
     *
     * @param patientDetails 实例对象
     * @return 实例对象
     */
    PatientDetails update(PatientDetails patientDetails);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
