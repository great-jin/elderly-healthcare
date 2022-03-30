package com.budailad.service;

import com.budailad.entity.SysLogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (SysLogs)表服务接口
 *
 * @author Budai
 * @since 2022-03-11 16:21:08
 */
public interface SysLogsService {

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    SysLogs queryById(String logId);

    /**
     * 条件查询
     *
     * @param sysLogs     筛选条件
     * @return 查询结果
     */
    List<SysLogs> queryAll(SysLogs sysLogs);

    /**
     * 分页查询
     *
     * @param sysLogs     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<SysLogs> queryByPage(SysLogs sysLogs, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sysLogs 实例对象
     * @return 实例对象
     */
    SysLogs insert(SysLogs sysLogs);

    /**
     * 修改数据
     *
     * @param sysLogs 实例对象
     * @return 实例对象
     */
    SysLogs update(SysLogs sysLogs);

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 是否成功
     */
    boolean deleteById(String logId);

}
