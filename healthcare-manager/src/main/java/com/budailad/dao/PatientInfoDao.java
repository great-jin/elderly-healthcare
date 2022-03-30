package com.budailad.dao;

import com.budailad.entity.PatientInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (PatientInfo)表数据库访问层
 *
 * @author Budai
 * @since 2022-03-29 15:57:12
 */
@Mapper
public interface PatientInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param patientId 主键
     * @return 实例对象
     */
    PatientInfo queryById(String patientId);

    /**
     * 查询指定行数据
     *
     * @param patientInfo 查询条件
     * @param pageable    分页对象
     * @return 对象列表
     */
    List<PatientInfo> queryAllByLimit(PatientInfo patientInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param patientInfo 查询条件
     * @return 总行数
     */
    long count(PatientInfo patientInfo);

    /**
     * 新增数据
     *
     * @param patientInfo 实例对象
     * @return 影响行数
     */
    int insert(PatientInfo patientInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PatientInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PatientInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PatientInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PatientInfo> entities);

    /**
     * 修改数据
     *
     * @param patientInfo 实例对象
     * @return 影响行数
     */
    int update(PatientInfo patientInfo);

    /**
     * 通过主键删除数据
     *
     * @param patientId 主键
     * @return 影响行数
     */
    int deleteById(String patientId);

}

