package com.budailad.dao;

import com.budailad.entity.PatientBodyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (PatientBodyInfo)表数据库访问层
 *
 * @author Budai
 * @since 2022-03-30 09:20:20
 */
@Mapper
public interface PatientBodyInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PatientBodyInfo queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param patientBodyInfo 查询条件
     * @param pageable        分页对象
     * @return 对象列表
     */
    List<PatientBodyInfo> queryAllByLimit(PatientBodyInfo patientBodyInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param patientBodyInfo 查询条件
     * @return 总行数
     */
    long count(PatientBodyInfo patientBodyInfo);

    /**
     * 新增数据
     *
     * @param patientBodyInfo 实例对象
     * @return 影响行数
     */
    int insert(PatientBodyInfo patientBodyInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PatientBodyInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PatientBodyInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PatientBodyInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PatientBodyInfo> entities);

    /**
     * 修改数据
     *
     * @param patientBodyInfo 实例对象
     * @return 影响行数
     */
    int update(PatientBodyInfo patientBodyInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

