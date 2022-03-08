package com.budailad.service;

import com.budailad.entity.PaitentCostDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (PaitentCostDetail)表服务接口
 *
 * @Author Budai
 * @Since 2022-03-07 16:25:59
 */
public interface PaitentCostDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PaitentCostDetail queryById(Integer id);

    /**
     * 分页查询
     *
     * @param paitentCostDetail 筛选条件
     * @param pageRequest       分页对象
     * @return 查询结果
     */
    Page<PaitentCostDetail> queryByPage(PaitentCostDetail paitentCostDetail, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param paitentCostDetail 实例对象
     * @return 实例对象
     */
    PaitentCostDetail insert(PaitentCostDetail paitentCostDetail);

    /**
     * 修改数据
     *
     * @param paitentCostDetail 实例对象
     * @return 实例对象
     */
    PaitentCostDetail update(PaitentCostDetail paitentCostDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}