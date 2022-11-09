package xyz.ibudai.dao;

import xyz.ibudai.entity.SysFileConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (SysFileConfig)表数据库访问层
 *
 * @author Budai
 * @since 2022-04-06 14:11:13
 */
@Mapper
public interface SysFileConfigDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysFileConfig queryById(Integer id);

    /**
     * 条件查询
     *
     * @param sysFileConfig 查询条件
     * @return 对象列表
     */
    List<SysFileConfig> conditionQuery(SysFileConfig sysFileConfig);

    /**
     * 查询指定行数据
     *
     * @param sysFileConfig 查询条件
     * @param pageable      分页对象
     * @return 对象列表
     */
    List<SysFileConfig> queryAllByLimit(SysFileConfig sysFileConfig, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param sysFileConfig 查询条件
     * @return 总行数
     */
    long count(SysFileConfig sysFileConfig);

    /**
     * 新增数据
     *
     * @param sysFileConfig 实例对象
     * @return 影响行数
     */
    int insert(SysFileConfig sysFileConfig);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysFileConfig> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysFileConfig> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysFileConfig> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SysFileConfig> entities);

    /**
     * 修改数据
     *
     * @param sysFileConfig 实例对象
     * @return 影响行数
     */
    int update(SysFileConfig sysFileConfig);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

