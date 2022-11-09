package xyz.ibudai.dao;

import xyz.ibudai.entity.PatientCaseFiles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (PatientCaseFiles)表数据库访问层
 *
 * @author Budai
 * @since 2022-03-24 15:54:00
 */
@Mapper
public interface PatientCaseFilesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param fileId 主键
     * @return 实例对象
     */
    PatientCaseFiles queryById(String fileId);

    /**
     * 条件查询
     *
     * @param patientCaseFiles 筛选条件
     * @return 查询结果
     */
    List<PatientCaseFiles> conditionQuery(PatientCaseFiles patientCaseFiles);

    /**
     * 查询指定行数据
     *
     * @param patientCaseFiles 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<PatientCaseFiles> queryAllByLimit(PatientCaseFiles patientCaseFiles, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param patientCaseFiles 查询条件
     * @return 总行数
     */
    long count(PatientCaseFiles patientCaseFiles);

    /**
     * 新增数据
     *
     * @param patientCaseFiles 实例对象
     * @return 影响行数
     */
    int insert(PatientCaseFiles patientCaseFiles);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PatientCaseFiles> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PatientCaseFiles> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PatientCaseFiles> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PatientCaseFiles> entities);

    /**
     * 修改数据
     *
     * @param patientCaseFiles 实例对象
     * @return 影响行数
     */
    int update(PatientCaseFiles patientCaseFiles);

    /**
     * 通过主键删除数据
     *
     * @param fileId 主键
     * @return 影响行数
     */
    int deleteById(String fileId);

}

