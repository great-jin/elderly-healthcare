package com.budailad.dao;

import com.budailad.entity.DailyTask;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (DailyTask)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-24 15:53:59
 */
public interface DailyTaskDao {

    /**
     * 通过ID查询单条数据
     *
     * @param taskId 主键
     * @return 实例对象
     */
    DailyTask queryById(String taskId);

    /**
     * 查询指定行数据
     *
     * @param dailyTask 查询条件
     * @param pageable  分页对象
     * @return 对象列表
     */
    List<DailyTask> queryAllByLimit(DailyTask dailyTask, @Param("pageable") Pageable pageable);


    /**
     * 
     * @return
     */
    List<DailyTask> queryAll();

    /**
     * 统计总行数
     *
     * @param dailyTask 查询条件
     * @return 总行数
     */
    long count(DailyTask dailyTask);

    /**
     * 新增数据
     *
     * @param dailyTask 实例对象
     * @return 影响行数
     */
    int insert(DailyTask dailyTask);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DailyTask> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DailyTask> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DailyTask> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DailyTask> entities);

    /**
     * 修改数据
     *
     * @param dailyTask 实例对象
     * @return 影响行数
     */
    int update(DailyTask dailyTask);

    /**
     * 通过主键删除数据
     *
     * @param taskId 主键
     * @return 影响行数
     */
    int deleteById(String taskId);

}

