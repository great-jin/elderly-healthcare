package com.budailad.service;

import com.budailad.entity.OrganizeDepart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (OrganizeDepart)表服务接口
 *
 * @Author Budai
 * @Since 2022-03-07 16:25:34
 */
public interface OrganizeDepartService {

    /**
     * 通过ID查询单条数据
     *
     * @param departId 主键
     * @return 实例对象
     */
    OrganizeDepart queryById(String departId);

    /**
     * 分页查询
     *
     * @param organizeDepart 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    Page<OrganizeDepart> queryByPage(OrganizeDepart organizeDepart, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param organizeDepart 实例对象
     * @return 实例对象
     */
    OrganizeDepart insert(OrganizeDepart organizeDepart);

    /**
     * 修改数据
     *
     * @param organizeDepart 实例对象
     * @return 实例对象
     */
    OrganizeDepart update(OrganizeDepart organizeDepart);

    /**
     * 通过主键删除数据
     *
     * @param departId 主键
     * @return 是否成功
     */
    boolean deleteById(String departId);

}
