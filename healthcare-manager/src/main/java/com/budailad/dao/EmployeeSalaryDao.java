package com.budailad.dao;

import com.budailad.entity.EmployeeSalary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (EmployeeSalary)表数据库访问层
 *
 * @author Budai
 * @since 2022-03-11 16:21:07
 */
@Mapper
public interface EmployeeSalaryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param salaryId 主键
     * @return 实例对象
     */
    EmployeeSalary queryById(String salaryId);

    /**
     * 条件查询
     *
     * @param employeeSalary 筛选条件
     * @return 查询结果
     */
    List<EmployeeSalary> queryAll(EmployeeSalary employeeSalary);

    /**
     * 查询指定行数据
     *
     * @param employeeSalary 查询条件
     * @param pageable       分页对象
     * @return 对象列表
     */
    List<EmployeeSalary> queryAllByLimit(EmployeeSalary employeeSalary, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param employeeSalary 查询条件
     * @return 总行数
     */
    long count(EmployeeSalary employeeSalary);

    /**
     * 新增数据
     *
     * @param employeeSalary 实例对象
     * @return 影响行数
     */
    int insert(EmployeeSalary employeeSalary);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeSalary> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EmployeeSalary> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeSalary> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<EmployeeSalary> entities);

    /**
     * 修改数据
     *
     * @param employeeSalary 实例对象
     * @return 影响行数
     */
    int update(EmployeeSalary employeeSalary);

    /**
     * 通过主键删除数据
     *
     * @param salaryId 主键
     * @return 影响行数
     */
    int deleteById(String salaryId);

}

