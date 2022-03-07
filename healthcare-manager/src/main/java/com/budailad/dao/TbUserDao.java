package com.budailad.dao;

import com.budailad.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (TbUser)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-07 16:28:27
 */
@Mapper
public interface TbUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbUser queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tbUser   查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<TbUser> queryAllByLimit(TbUser tbUser, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbUser 查询条件
     * @return 总行数
     */
    long count(TbUser tbUser);

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 影响行数
     */
    int insert(TbUser tbUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbUser> entities);

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 影响行数
     */
    int update(TbUser tbUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

