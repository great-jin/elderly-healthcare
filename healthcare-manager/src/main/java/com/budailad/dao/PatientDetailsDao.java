package com.budailad.dao;

import com.budailad.entity.PatientDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (PatientDetails)表数据库访问层
 *
 * @Author Budai
 * @Since 2022-03-07 16:26:11
 */
@Mapper
public interface PatientDetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PatientDetails queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param patientDetails 查询条件
     * @param pageable       分页对象
     * @return 对象列表
     */
    List<PatientDetails> queryAllByLimit(PatientDetails patientDetails, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param patientDetails 查询条件
     * @return 总行数
     */
    long count(PatientDetails patientDetails);

    /**
     * 新增数据
     *
     * @param patientDetails 实例对象
     * @return 影响行数
     */
    int insert(PatientDetails patientDetails);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PatientDetails> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PatientDetails> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PatientDetails> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PatientDetails> entities);

    /**
     * 修改数据
     *
     * @param patientDetails 实例对象
     * @return 影响行数
     */
    int update(PatientDetails patientDetails);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

