package com.budailad.service.impl;

import com.budailad.entity.EmployeeSalary;
import com.budailad.dao.EmployeeSalaryDao;
import com.budailad.service.EmployeeSalaryService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EmployeeSalary)表服务实现类
 *
 * @author Budai
 * @since 2022-03-11 16:21:07
 */
@Service("employeeSalaryService")
public class EmployeeSalaryServiceImpl implements EmployeeSalaryService {
    @Resource
    private EmployeeSalaryDao employeeSalaryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param salaryId 主键
     * @return 实例对象
     */
    @Override
    public EmployeeSalary queryById(String salaryId) {
        return this.employeeSalaryDao.queryById(salaryId);
    }

    /**
     * 条件查询
     *
     * @param employeeSalary 筛选条件
     * @return 查询结果
     */
    @Override
    public List<EmployeeSalary> queryAll(EmployeeSalary employeeSalary) {
        return this.employeeSalaryDao.queryAll(employeeSalary);
    }

    /**
     * 分页查询
     *
     * @param employeeSalary 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @Override
    public Page<EmployeeSalary> queryByPage(EmployeeSalary employeeSalary, PageRequest pageRequest) {
        long total = this.employeeSalaryDao.count(employeeSalary);
        return new PageImpl<>(this.employeeSalaryDao.queryAllByLimit(employeeSalary, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param employeeSalary 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeSalary insert(EmployeeSalary employeeSalary) {
        this.employeeSalaryDao.insert(employeeSalary);
        return employeeSalary;
    }

    /**
     * 修改数据
     *
     * @param employeeSalary 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeSalary update(EmployeeSalary employeeSalary) {
        this.employeeSalaryDao.update(employeeSalary);
        return this.queryById(employeeSalary.getSalaryId());
    }

    /**
     * 通过主键删除数据
     *
     * @param salaryId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String salaryId) {
        return this.employeeSalaryDao.deleteById(salaryId) > 0;
    }
}
