package com.budailad.service;

import com.budailad.entity.OrganizeStaff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (OrganizeStaff)表服务接口
 *
 * @author Budai
 * @since 2022-03-11 16:21:04
 */
public interface OrganizeStaffService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrganizeStaff queryById(Integer id);

    /**
     * 条件查询
     *
     * @param organizeStaff 筛选条件
     * @return 查询结果
     */
    List<OrganizeStaff> conditionQuery(OrganizeStaff organizeStaff);

    /**
     * 分页查询
     *
     * @param organizeStaff 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    Page<OrganizeStaff> queryByPage(OrganizeStaff organizeStaff, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param organizeStaff 实例对象
     * @return 实例对象
     */
    OrganizeStaff insert(OrganizeStaff organizeStaff);

    /**
     * 修改数据
     *
     * @param organizeStaff 实例对象
     * @return 实例对象
     */
    OrganizeStaff update(OrganizeStaff organizeStaff);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
