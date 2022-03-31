package com.budailad.service;

import com.budailad.entity.PatientCostDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (PaitentCostDetail)表服务接口
 *
 * @author Budai
 * @since 2022-03-11 16:21:06
 */
public interface PatientCostDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param costId 主键
     * @return 实例对象
     */
    PatientCostDetail queryById(String costId);

    /**
     * 条件查询
     *
     * @param patientCostDetail 筛选条件
     * @return 查询结果
     */
    List<PatientCostDetail> queryAll(PatientCostDetail patientCostDetail);

    /**
     * 分页查询
     *
     * @param patientCostDetail 筛选条件
     * @param pageRequest       分页对象
     * @return 查询结果
     */
    Page<PatientCostDetail> queryByPage(PatientCostDetail patientCostDetail, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param patientCostDetail 实例对象
     * @return 实例对象
     */
    PatientCostDetail insert(PatientCostDetail patientCostDetail);

    /**
     * 修改数据
     *
     * @param patientCostDetail 实例对象
     * @return 实例对象
     */
    PatientCostDetail update(PatientCostDetail patientCostDetail);

    /**
     * 通过主键删除数据
     *
     * @param costId 主键
     * @return 是否成功
     */
    boolean deleteById(String costId);

}
