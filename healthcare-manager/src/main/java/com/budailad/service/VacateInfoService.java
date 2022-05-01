package com.budailad.service;

import com.budailad.entity.VacateInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (VacateInfo)表服务接口
 *
 * @author Budai
 * @since 2022-03-29 15:38:02
 */
public interface VacateInfoService {

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
    List<VacateInfo> conditionQuery(VacateInfo vacateInfo);

    /**
     * 分页查询
     *
     * @param vacateInfo  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<VacateInfo> queryByPage(VacateInfo vacateInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param vacateInfo 实例对象
     * @return 实例对象
     */
    VacateInfo insert(VacateInfo vacateInfo);

    /**
     * 修改数据
     *
     * @param vacateInfo 实例对象
     * @return 实例对象
     */
    VacateInfo update(VacateInfo vacateInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
