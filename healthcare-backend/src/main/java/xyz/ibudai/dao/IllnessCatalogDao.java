package xyz.ibudai.dao;

import xyz.ibudai.entity.IllnessCatalog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (IllnessCatalog)表数据库访问层
 *
 * @author Budai
 * @since 2022-03-11 16:21:08
 */
@Mapper
public interface IllnessCatalogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param illId 主键
     * @return 实例对象
     */
    IllnessCatalog queryById(String illId);

    /**
     * 条件查询
     *
     * @param illnessCatalog 筛选条件
     * @return 查询结果
     */
    List<IllnessCatalog> conditionQuery(IllnessCatalog illnessCatalog);

    /**
     * 查询指定行数据
     *
     * @param illnessCatalog 查询条件
     * @param pageable       分页对象
     * @return 对象列表
     */
    List<IllnessCatalog> queryAllByLimit(IllnessCatalog illnessCatalog, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param illnessCatalog 查询条件
     * @return 总行数
     */
    long count(IllnessCatalog illnessCatalog);

    /**
     * 新增数据
     *
     * @param illnessCatalog 实例对象
     * @return 影响行数
     */
    int insert(IllnessCatalog illnessCatalog);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<IllnessCatalog> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<IllnessCatalog> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<IllnessCatalog> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<IllnessCatalog> entities);

    /**
     * 修改数据
     *
     * @param illnessCatalog 实例对象
     * @return 影响行数
     */
    int update(IllnessCatalog illnessCatalog);

    /**
     * 通过主键删除数据
     *
     * @param illId 主键
     * @return 影响行数
     */
    int deleteById(String illId);

}

