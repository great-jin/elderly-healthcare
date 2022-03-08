package com.budailad.dao;

import com.budailad.entity.InfoMail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (InfoMail)表数据库访问层
 *
 * @Author Budai
 * @Since 2022-03-07 16:25:00
 */
@Mapper
public interface InfoMailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param mailId 主键
     * @return 实例对象
     */
    InfoMail queryById(String mailId);

    /**
     * 查询指定行数据
     *
     * @param infoMail 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<InfoMail> queryAllByLimit(InfoMail infoMail, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param infoMail 查询条件
     * @return 总行数
     */
    long count(InfoMail infoMail);

    /**
     * 新增数据
     *
     * @param infoMail 实例对象
     * @return 影响行数
     */
    int insert(InfoMail infoMail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<InfoMail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<InfoMail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<InfoMail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<InfoMail> entities);

    /**
     * 修改数据
     *
     * @param infoMail 实例对象
     * @return 影响行数
     */
    int update(InfoMail infoMail);

    /**
     * 通过主键删除数据
     *
     * @param mailId 主键
     * @return 影响行数
     */
    int deleteById(String mailId);

}

