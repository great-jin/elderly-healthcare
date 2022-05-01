package com.budailad.dao;

import com.budailad.entity.MedicineCatalog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (MedicineCatalog)表数据库访问层
 *
 * @author Budai
 * @since 2022-03-11 16:21:04
 */
@Mapper
public interface MedicineCatalogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param drugId 主键
     * @return 实例对象
     */
    MedicineCatalog queryById(String drugId);

    /**
     * 条件查询
     *
     * @param medicineCatalog 筛选条件
     * @return 查询结果
     */
    List<MedicineCatalog> conditionQuery(MedicineCatalog medicineCatalog);

    /**
     * 查询指定行数据
     *
     * @param medicineCatalog 查询条件
     * @param pageable        分页对象
     * @return 对象列表
     */
    List<MedicineCatalog> queryAllByLimit(MedicineCatalog medicineCatalog, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param medicineCatalog 查询条件
     * @return 总行数
     */
    long count(MedicineCatalog medicineCatalog);

    /**
     * 新增数据
     *
     * @param medicineCatalog 实例对象
     * @return 影响行数
     */
    int insert(MedicineCatalog medicineCatalog);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MedicineCatalog> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MedicineCatalog> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MedicineCatalog> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MedicineCatalog> entities);

    /**
     * 修改数据
     *
     * @param medicineCatalog 实例对象
     * @return 影响行数
     */
    int update(MedicineCatalog medicineCatalog);

    /**
     * 通过主键删除数据
     *
     * @param drugId 主键
     * @return 影响行数
     */
    int deleteById(String drugId);

}

