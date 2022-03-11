package com.budailad.dao;

import com.budailad.entity.SysLogs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (SysLogs)表数据库访问层
 *
 * @author Budai
 * @since 2022-03-11 16:21:08
 */
@Mapper
public interface SysLogsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    SysLogs queryById(String logId);

    /**
     * 查询指定行数据
     *
     * @param sysLogs  查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<SysLogs> queryAllByLimit(SysLogs sysLogs, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param sysLogs 查询条件
     * @return 总行数
     */
    long count(SysLogs sysLogs);

    /**
     * 新增数据
     *
     * @param sysLogs 实例对象
     * @return 影响行数
     */
    int insert(SysLogs sysLogs);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysLogs> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysLogs> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysLogs> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SysLogs> entities);

    /**
     * 修改数据
     *
     * @param sysLogs 实例对象
     * @return 影响行数
     */
    int update(SysLogs sysLogs);

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 影响行数
     */
    int deleteById(String logId);

}

