package com.budailad.service;

import com.budailad.entity.DailyTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (DailyTask)表服务接口
 *
 * @author makejava
 * @since 2022-03-24 15:54:00
 */
public interface DailyTaskService {

    /**
     * 通过ID查询单条数据
     *
     * @param taskId 主键
     * @return 实例对象
     */
    DailyTask queryById(String taskId);

    /**
     * 分页查询
     *
     * @param dailyTask   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<DailyTask> queryByPage(DailyTask dailyTask, PageRequest pageRequest);

    /**
     *
     * @return
     */
    List<DailyTask> queryAll();

    /**
     * 新增数据
     *
     * @param dailyTask 实例对象
     * @return 实例对象
     */
    DailyTask insert(DailyTask dailyTask);

    /**
     * 修改数据
     *
     * @param dailyTask 实例对象
     * @return 实例对象
     */
    DailyTask update(DailyTask dailyTask);

    /**
     * 通过主键删除数据
     *
     * @param taskId 主键
     * @return 是否成功
     */
    boolean deleteById(String taskId);

}
