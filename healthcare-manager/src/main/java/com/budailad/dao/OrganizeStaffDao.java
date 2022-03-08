package com.budailad.dao;

import com.budailad.entity.OrganizeStaff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (OrganizeStaff)表数据库访问层
 *
 * @Author Budai
 * @Since 2022-03-07 16:25:46
 */
@Mapper
public interface OrganizeStaffDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrganizeStaff queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param organizeStaff 查询条件
     * @param pageable      分页对象
     * @return 对象列表
     */
    List<OrganizeStaff> queryAllByLimit(OrganizeStaff organizeStaff, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param organizeStaff 查询条件
     * @return 总行数
     */
    long count(OrganizeStaff organizeStaff);

    /**
     * 新增数据
     *
     * @param organizeStaff 实例对象
     * @return 影响行数
     */
    int insert(OrganizeStaff organizeStaff);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrganizeStaff> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<OrganizeStaff> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrganizeStaff> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<OrganizeStaff> entities);

    /**
     * 修改数据
     *
     * @param organizeStaff 实例对象
     * @return 影响行数
     */
    int update(OrganizeStaff organizeStaff);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

