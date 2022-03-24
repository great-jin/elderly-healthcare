package com.budailad.service.impl;

import com.budailad.entity.DailyTask;
import com.budailad.dao.DailyTaskDao;
import com.budailad.service.DailyTaskService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (DailyTask)表服务实现类
 *
 * @author makejava
 * @since 2022-03-24 15:54:00
 */
@Service("dailyTaskService")
public class DailyTaskServiceImpl implements DailyTaskService {
    @Resource
    private DailyTaskDao dailyTaskDao;

    /**
     * 通过ID查询单条数据
     *
     * @param taskId 主键
     * @return 实例对象
     */
    @Override
    public DailyTask queryById(String taskId) {
        return this.dailyTaskDao.queryById(taskId);
    }

    /**
     * 分页查询
     *
     * @param dailyTask   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<DailyTask> queryByPage(DailyTask dailyTask, PageRequest pageRequest) {
        long total = this.dailyTaskDao.count(dailyTask);
        return new PageImpl<>(this.dailyTaskDao.queryAllByLimit(dailyTask, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dailyTask 实例对象
     * @return 实例对象
     */
    @Override
    public DailyTask insert(DailyTask dailyTask) {
        this.dailyTaskDao.insert(dailyTask);
        return dailyTask;
    }

    /**
     * 修改数据
     *
     * @param dailyTask 实例对象
     * @return 实例对象
     */
    @Override
    public DailyTask update(DailyTask dailyTask) {
        this.dailyTaskDao.update(dailyTask);
        return this.queryById(dailyTask.getTaskId());
    }

    /**
     * 通过主键删除数据
     *
     * @param taskId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String taskId) {
        return this.dailyTaskDao.deleteById(taskId) > 0;
    }
}
