package xyz.ibudai.dao;

import xyz.ibudai.entity.PatientCostInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (PatientCostInfo)表数据库访问层
 *
 * @author Budai
 * @since 2022-04-06 14:07:05
 */
@Mapper
public interface PatientCostInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param costId 主键
     * @return 实例对象
     */
    PatientCostInfo queryById(String costId);

    /**
     * 条件查询
     *
     * @param patientCostInfo 查询条件
     * @return 对象列表
     */
    List<PatientCostInfo> conditionQuery(PatientCostInfo patientCostInfo);

    /**
     * 查询指定行数据
     *
     * @param patientCostInfo 查询条件
     * @param pageable        分页对象
     * @return 对象列表
     */
    List<PatientCostInfo> queryAllByLimit(PatientCostInfo patientCostInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param patientCostInfo 查询条件
     * @return 总行数
     */
    long count(PatientCostInfo patientCostInfo);

    /**
     * 新增数据
     *
     * @param patientCostInfo 实例对象
     * @return 影响行数
     */
    int insert(PatientCostInfo patientCostInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PatientCostInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PatientCostInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PatientCostInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PatientCostInfo> entities);

    /**
     * 修改数据
     *
     * @param patientCostInfo 实例对象
     * @return 影响行数
     */
    int update(PatientCostInfo patientCostInfo);

    /**
     * 通过主键删除数据
     *
     * @param costId 主键
     * @return 影响行数
     */
    int deleteById(String costId);

}

