package com.budailad.service;

import com.budailad.entity.StaffUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (StaffUser)表服务接口
 *
 * @Author Budai
 * @Since 2022-03-07 16:27:51
 */
public interface StaffUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StaffUser queryById(Integer id);

    /**
     * 分页查询
     *
     * @param staffUser   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<StaffUser> queryByPage(StaffUser staffUser, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param staffUser 实例对象
     * @return 实例对象
     */
    StaffUser insert(StaffUser staffUser);

    /**
     * 修改数据
     *
     * @param staffUser 实例对象
     * @return 实例对象
     */
    StaffUser update(StaffUser staffUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
