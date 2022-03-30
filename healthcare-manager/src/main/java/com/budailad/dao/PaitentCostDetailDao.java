package com.budailad.dao;

import com.budailad.entity.PaitentCostDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (PaitentCostDetail)表数据库访问层
 *
 * @author Budai
 * @since 2022-03-11 16:21:06
 */
@Mapper
public interface PaitentCostDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param costId 主键
     * @return 实例对象
     */
    PaitentCostDetail queryById(String costId);

    /**
     * 条件查询
     *
     * @param paitentCostDetail 筛选条件
     * @return 查询结果
     */
    List<PaitentCostDetail> queryAll(PaitentCostDetail paitentCostDetail);

    /**
     * 查询指定行数据
     *
     * @param paitentCostDetail 查询条件
     * @param pageable          分页对象
     * @return 对象列表
     */
    List<PaitentCostDetail> queryAllByLimit(PaitentCostDetail paitentCostDetail, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param paitentCostDetail 查询条件
     * @return 总行数
     */
    long count(PaitentCostDetail paitentCostDetail);

    /**
     * 新增数据
     *
     * @param paitentCostDetail 实例对象
     * @return 影响行数
     */
    int insert(PaitentCostDetail paitentCostDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PaitentCostDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PaitentCostDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PaitentCostDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PaitentCostDetail> entities);

    /**
     * 修改数据
     *
     * @param paitentCostDetail 实例对象
     * @return 影响行数
     */
    int update(PaitentCostDetail paitentCostDetail);

    /**
     * 通过主键删除数据
     *
     * @param costId 主键
     * @return 影响行数
     */
    int deleteById(String costId);

}

