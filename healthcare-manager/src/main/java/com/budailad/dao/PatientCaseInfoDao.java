package com.budailad.dao;

import com.budailad.entity.PatientCaseInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (PatientCaseInfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-24 15:54:01
 */
public interface PatientCaseInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param castId 主键
     * @return 实例对象
     */
    PatientCaseInfo queryById(String castId);

    /**
     * 查询指定行数据
     *
     * @param patientCaseInfo 查询条件
     * @param pageable        分页对象
     * @return 对象列表
     */
    List<PatientCaseInfo> queryAllByLimit(PatientCaseInfo patientCaseInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param patientCaseInfo 查询条件
     * @return 总行数
     */
    long count(PatientCaseInfo patientCaseInfo);

    /**
     * 新增数据
     *
     * @param patientCaseInfo 实例对象
     * @return 影响行数
     */
    int insert(PatientCaseInfo patientCaseInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PatientCaseInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PatientCaseInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PatientCaseInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PatientCaseInfo> entities);

    /**
     * 修改数据
     *
     * @param patientCaseInfo 实例对象
     * @return 影响行数
     */
    int update(PatientCaseInfo patientCaseInfo);

    /**
     * 通过主键删除数据
     *
     * @param castId 主键
     * @return 影响行数
     */
    int deleteById(String castId);

}

