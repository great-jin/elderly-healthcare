package com.budailad.dao;

import com.budailad.entity.OrganizeDepart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (OrganizeDepart)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-07 16:25:34
 */
@Mapper
public interface OrganizeDepartDao {

    /**
     * 通过ID查询单条数据
     *
     * @param departId 主键
     * @return 实例对象
     */
    OrganizeDepart queryById(String departId);

    /**
     * 查询指定行数据
     *
     * @param organizeDepart 查询条件
     * @param pageable       分页对象
     * @return 对象列表
     */
    List<OrganizeDepart> queryAllByLimit(OrganizeDepart organizeDepart, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param organizeDepart 查询条件
     * @return 总行数
     */
    long count(OrganizeDepart organizeDepart);

    /**
     * 新增数据
     *
     * @param organizeDepart 实例对象
     * @return 影响行数
     */
    int insert(OrganizeDepart organizeDepart);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrganizeDepart> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<OrganizeDepart> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrganizeDepart> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<OrganizeDepart> entities);

    /**
     * 修改数据
     *
     * @param organizeDepart 实例对象
     * @return 影响行数
     */
    int update(OrganizeDepart organizeDepart);

    /**
     * 通过主键删除数据
     *
     * @param departId 主键
     * @return 影响行数
     */
    int deleteById(String departId);

}

