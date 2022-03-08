package com.budailad.service;

import com.budailad.entity.StaffDoctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (StaffDoctor)表服务接口
 *
 * @Author Budai
 * @Since 2022-03-07 16:26:34
 */
public interface StaffDoctorService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StaffDoctor queryById(Integer id);

    /**
     * 分页查询
     *
     * @param staffDoctor 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<StaffDoctor> queryByPage(StaffDoctor staffDoctor, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param staffDoctor 实例对象
     * @return 实例对象
     */
    StaffDoctor insert(StaffDoctor staffDoctor);

    /**
     * 修改数据
     *
     * @param staffDoctor 实例对象
     * @return 实例对象
     */
    StaffDoctor update(StaffDoctor staffDoctor);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}