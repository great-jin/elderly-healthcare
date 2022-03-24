package com.budailad.service;

import com.budailad.entity.PatientCaseInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (PatientCaseInfo)表服务接口
 *
 * @author makejava
 * @since 2022-03-24 15:54:01
 */
public interface PatientCaseInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param castId 主键
     * @return 实例对象
     */
    PatientCaseInfo queryById(String castId);

    /**
     * 分页查询
     *
     * @param patientCaseInfo 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    Page<PatientCaseInfo> queryByPage(PatientCaseInfo patientCaseInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param patientCaseInfo 实例对象
     * @return 实例对象
     */
    PatientCaseInfo insert(PatientCaseInfo patientCaseInfo);

    /**
     * 修改数据
     *
     * @param patientCaseInfo 实例对象
     * @return 实例对象
     */
    PatientCaseInfo update(PatientCaseInfo patientCaseInfo);

    /**
     * 通过主键删除数据
     *
     * @param castId 主键
     * @return 是否成功
     */
    boolean deleteById(String castId);

}
