package com.budailad.service;

import com.budailad.entity.PatientCaseFiles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (PatientCaseFiles)表服务接口
 *
 * @author makejava
 * @since 2022-03-24 15:54:01
 */
public interface PatientCaseFilesService {

    /**
     * 通过ID查询单条数据
     *
     * @param fileId 主键
     * @return 实例对象
     */
    PatientCaseFiles queryById(String fileId);

    /**
     * 分页查询
     *
     * @param patientCaseFiles 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<PatientCaseFiles> queryByPage(PatientCaseFiles patientCaseFiles, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param patientCaseFiles 实例对象
     * @return 实例对象
     */
    PatientCaseFiles insert(PatientCaseFiles patientCaseFiles);

    /**
     * 修改数据
     *
     * @param patientCaseFiles 实例对象
     * @return 实例对象
     */
    PatientCaseFiles update(PatientCaseFiles patientCaseFiles);

    /**
     * 通过主键删除数据
     *
     * @param fileId 主键
     * @return 是否成功
     */
    boolean deleteById(String fileId);

}
