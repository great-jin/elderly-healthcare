package com.budailad.service;

import com.budailad.entity.SysFileConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (SysFileConfig)表服务接口
 *
 * @author Budai
 * @since 2022-04-06 14:11:13
 */
public interface SysFileConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysFileConfig queryById(Integer id);

    /**
     * 条件查询
     *
     * @param sysFileConfig 筛选条件
     * @return 查询结果
     */
    List<SysFileConfig> conditionQuery(SysFileConfig sysFileConfig);

    /**
     * 分页查询
     *
     * @param sysFileConfig 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    Page<SysFileConfig> queryByPage(SysFileConfig sysFileConfig, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sysFileConfig 实例对象
     * @return 实例对象
     */
    SysFileConfig insert(SysFileConfig sysFileConfig);

    /**
     * 修改数据
     *
     * @param sysFileConfig 实例对象
     * @return 实例对象
     */
    SysFileConfig update(SysFileConfig sysFileConfig);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
