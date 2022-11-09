package xyz.ibudai.dao;

import xyz.ibudai.entity.PatientCostDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (PatientCostDetail)表数据库访问层
 *
 * @author Budai
 * @since 2022-04-06 14:07:04
 */
@Mapper
public interface PatientCostDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PatientCostDetail queryById(String id);

    /**
     * 条件查询
     *
     * @param patientCostDetail 查询条件
     * @return 对象列表
     */
    List<PatientCostDetail> conditionQuery(PatientCostDetail patientCostDetail);

    /**
     * 查询指定行数据
     *
     * @param patientCostDetail 查询条件
     * @param pageable          分页对象
     * @return 对象列表
     */
    List<PatientCostDetail> queryAllByLimit(PatientCostDetail patientCostDetail, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param patientCostDetail 查询条件
     * @return 总行数
     */
    long count(PatientCostDetail patientCostDetail);

    /**
     * 新增数据
     *
     * @param patientCostDetail 实例对象
     * @return 影响行数
     */
    int insert(PatientCostDetail patientCostDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PatientCostDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PatientCostDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PatientCostDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PatientCostDetail> entities);

    /**
     * 修改数据
     *
     * @param patientCostDetail 实例对象
     * @return 影响行数
     */
    int update(PatientCostDetail patientCostDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

