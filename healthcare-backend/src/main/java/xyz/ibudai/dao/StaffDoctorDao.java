package xyz.ibudai.dao;

import xyz.ibudai.entity.StaffDoctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (StaffDoctor)表数据库访问层
 *
 * @author Budai
 * @since 2022-03-11 16:21:08
 */
@Mapper
public interface StaffDoctorDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StaffDoctor queryById(Integer id);

    /**
     * 条件查询
     *
     * @param staffDoctor 筛选条件
     * @return 查询结果
     */
    List<StaffDoctor> conditionQuery(StaffDoctor staffDoctor);

    /**
     * 查询指定行数据
     *
     * @param staffDoctor 查询条件
     * @param pageable    分页对象
     * @return 对象列表
     */
    List<StaffDoctor> queryAllByLimit(StaffDoctor staffDoctor, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param staffDoctor 查询条件
     * @return 总行数
     */
    long count(StaffDoctor staffDoctor);

    /**
     * 新增数据
     *
     * @param staffDoctor 实例对象
     * @return 影响行数
     */
    int insert(StaffDoctor staffDoctor);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<StaffDoctor> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<StaffDoctor> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<StaffDoctor> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<StaffDoctor> entities);

    /**
     * 修改数据
     *
     * @param staffDoctor 实例对象
     * @return 影响行数
     */
    int update(StaffDoctor staffDoctor);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

