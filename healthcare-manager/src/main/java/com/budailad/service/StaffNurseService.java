package com.budailad.service;

import com.budailad.entity.StaffNurse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (StaffNurse)表服务接口
 *
 * @author Budai
 * @since 2022-03-11 16:21:06
 */
public interface StaffNurseService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StaffNurse queryById(Integer id);

    /**
     * 条件查询
     *
     * @param staffNurse  筛选条件
     * @return 查询结果
     */
    List<StaffNurse> queryAll(StaffNurse staffNurse);

    /**
     * 分页查询
     *
     * @param staffNurse  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<StaffNurse> queryByPage(StaffNurse staffNurse, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param staffNurse 实例对象
     * @return 实例对象
     */
    StaffNurse insert(StaffNurse staffNurse);

    /**
     * 修改数据
     *
     * @param staffNurse 实例对象
     * @return 实例对象
     */
    StaffNurse update(StaffNurse staffNurse);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
