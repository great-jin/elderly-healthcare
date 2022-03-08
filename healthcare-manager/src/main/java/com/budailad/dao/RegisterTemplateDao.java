package com.budailad.dao;

import com.budailad.entity.RegisterTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (RegisterTemplate)表数据库访问层
 *
 * @Author Budai
 * @Since 2022-03-07 16:26:22
 */
@Mapper
public interface RegisterTemplateDao {

    /**
     * 通过ID查询单条数据
     *
     * @param tempId 主键
     * @return 实例对象
     */
    RegisterTemplate queryById(String tempId);

    /**
     * 查询指定行数据
     *
     * @param registerTemplate 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<RegisterTemplate> queryAllByLimit(RegisterTemplate registerTemplate, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param registerTemplate 查询条件
     * @return 总行数
     */
    long count(RegisterTemplate registerTemplate);

    /**
     * 新增数据
     *
     * @param registerTemplate 实例对象
     * @return 影响行数
     */
    int insert(RegisterTemplate registerTemplate);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RegisterTemplate> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RegisterTemplate> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RegisterTemplate> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RegisterTemplate> entities);

    /**
     * 修改数据
     *
     * @param registerTemplate 实例对象
     * @return 影响行数
     */
    int update(RegisterTemplate registerTemplate);

    /**
     * 通过主键删除数据
     *
     * @param tempId 主键
     * @return 影响行数
     */
    int deleteById(String tempId);

}

