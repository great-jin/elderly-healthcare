package com.budailad.dao;

import com.budailad.entity.VacateInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (VacateInfo)表数据库访问层
 *
 * @author Budai
 * @since 2022-03-29 15:38:01
 */
@Mapper
public interface VacateInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    VacateInfo queryById(String id);

    /**
     * 条件查询
     *
     * @param vacateInfo  筛选条件
     * @return 查询结果
     */
    List<VacateInfo> queryAll(VacateInfo vacateInfo);

    /**
     * 查询指定行数据
     *
     * @param vacateInfo 查询条件
     * @param pageable   分页对象
     * @return 对象列表
     */
    List<VacateInfo> queryAllByLimit(VacateInfo vacateInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param vacateInfo 查询条件
     * @return 总行数
     */
    long count(VacateInfo vacateInfo);

    /**
     * 新增数据
     *
     * @param vacateInfo 实例对象
     * @return 影响行数
     */
    int insert(VacateInfo vacateInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<VacateInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<VacateInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<VacateInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<VacateInfo> entities);

    /**
     * 修改数据
     *
     * @param vacateInfo 实例对象
     * @return 影响行数
     */
    int update(VacateInfo vacateInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

