package com.budailad.service;

import com.budailad.entity.OrganizeInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (OrganizeInfo)表服务接口
 *
 * @author Budai
 * @since 2022-03-11 16:21:04
 */
public interface OrganizeInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param organizeId 主键
     * @return 实例对象
     */
    OrganizeInfo queryById(String organizeId);

    /**
     * 条件查询
     *
     * @param organizeInfo 筛选条件
     * @return 查询结果
     */
    List<OrganizeInfo> queryAll(OrganizeInfo organizeInfo);

    /**
     * 分页查询
     *
     * @param organizeInfo 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    Page<OrganizeInfo> queryByPage(OrganizeInfo organizeInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param organizeInfo 实例对象
     * @return 实例对象
     */
    OrganizeInfo insert(OrganizeInfo organizeInfo);

    /**
     * 修改数据
     *
     * @param organizeInfo 实例对象
     * @return 实例对象
     */
    OrganizeInfo update(OrganizeInfo organizeInfo);

    /**
     * 通过主键删除数据
     *
     * @param organizeId 主键
     * @return 是否成功
     */
    boolean deleteById(String organizeId);

}
