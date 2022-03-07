package com.budailad.dao;

import com.budailad.entity.StaffUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (StaffUser)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-07 16:27:51
 */
@Mapper
public interface StaffUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StaffUser queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param staffUser 查询条件
     * @param pageable  分页对象
     * @return 对象列表
     */
    List<StaffUser> queryAllByLimit(StaffUser staffUser, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param staffUser 查询条件
     * @return 总行数
     */
    long count(StaffUser staffUser);

    /**
     * 新增数据
     *
     * @param staffUser 实例对象
     * @return 影响行数
     */
    int insert(StaffUser staffUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<StaffUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<StaffUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<StaffUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<StaffUser> entities);

    /**
     * 修改数据
     *
     * @param staffUser 实例对象
     * @return 影响行数
     */
    int update(StaffUser staffUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

