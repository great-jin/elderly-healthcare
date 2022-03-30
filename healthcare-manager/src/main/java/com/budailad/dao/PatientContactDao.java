package com.budailad.dao;

import com.budailad.entity.PatientContact;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (PatientContact)表数据库访问层
 *
 * @author Budai
 * @since 2022-03-28 16:00:20
 */
@Mapper
public interface PatientContactDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PatientContact queryById(String id);

    /**
     * 条件查询
     *
     * @param patientContact 筛选条件
     * @return 查询结果
     */
    List<PatientContact> queryAll(PatientContact patientContact);

    /**
     * 查询指定行数据
     *
     * @param patientContact 查询条件
     * @param pageable       分页对象
     * @return 对象列表
     */
    List<PatientContact> queryAllByLimit(PatientContact patientContact, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param patientContact 查询条件
     * @return 总行数
     */
    long count(PatientContact patientContact);

    /**
     * 新增数据
     *
     * @param patientContact 实例对象
     * @return 影响行数
     */
    int insert(PatientContact patientContact);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PatientContact> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PatientContact> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PatientContact> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PatientContact> entities);

    /**
     * 修改数据
     *
     * @param patientContact 实例对象
     * @return 影响行数
     */
    int update(PatientContact patientContact);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

