package com.budailad.dao;

import com.budailad.entity.OrganizeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (OrganizeInfo)表数据库访问层
 *
 * @author Budai
 * @since 2022-03-11 16:21:04
 */
@Mapper
public interface OrganizeInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param organizeId 主键
     * @return 实例对象
     */
    OrganizeInfo queryById(String organizeId);

    /**
     * 查询非分页数据
     *
     * @return
     */
    List<OrganizeInfo> queryAll();


    /**
     * 查询指定行数据
     *
     * @param organizeInfo 查询条件
     * @param pageable     分页对象
     * @return 对象列表
     */
    List<OrganizeInfo> queryAllByLimit(OrganizeInfo organizeInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param organizeInfo 查询条件
     * @return 总行数
     */
    long count(OrganizeInfo organizeInfo);

    /**
     * 新增数据
     *
     * @param organizeInfo 实例对象
     * @return 影响行数
     */
    int insert(OrganizeInfo organizeInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrganizeInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<OrganizeInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrganizeInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<OrganizeInfo> entities);

    /**
     * 修改数据
     *
     * @param organizeInfo 实例对象
     * @return 影响行数
     */
    int update(OrganizeInfo organizeInfo);

    /**
     * 通过主键删除数据
     *
     * @param organizeId 主键
     * @return 影响行数
     */
    int deleteById(String organizeId);

}

