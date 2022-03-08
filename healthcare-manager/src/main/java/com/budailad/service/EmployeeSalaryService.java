package com.budailad.service;

import com.budailad.entity.EmployeeSalary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (EmployeeSalary)表服务接口
 *
 * @Author Budai
 * @Since 2022-03-07 16:24:02
 */
public interface EmployeeSalaryService {

    /**
     * 通过ID查询单条数据
     *
     * @param salaryId 主键
     * @return 实例对象
     */
    EmployeeSalary queryById(String salaryId);

    /**
     * 分页查询
     *
     * @param employeeSalary 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    Page<EmployeeSalary> queryByPage(EmployeeSalary employeeSalary, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param employeeSalary 实例对象
     * @return 实例对象
     */
    EmployeeSalary insert(EmployeeSalary employeeSalary);

    /**
     * 修改数据
     *
     * @param employeeSalary 实例对象
     * @return 实例对象
     */
    EmployeeSalary update(EmployeeSalary employeeSalary);

    /**
     * 通过主键删除数据
     *
     * @param salaryId 主键
     * @return 是否成功
     */
    boolean deleteById(String salaryId);

}