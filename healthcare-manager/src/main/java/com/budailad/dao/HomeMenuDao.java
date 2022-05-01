package com.budailad.dao;

import com.budailad.entity.HomeMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (HomeMenu)表数据库访问层
 *
 * @author Budai
 * @since 2022-04-04 11:39:33
 */
public interface HomeMenuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    HomeMenu queryById(Integer id);

    /**
     * 条件查询
     *
     * @param homeMenu 查询条件
     * @return 对象列表
     */
    List<HomeMenu> conditionQuery(HomeMenu homeMenu);

    /**
     * 查询指定行数据
     *
     * @param homeMenu 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<HomeMenu> queryAllByLimit(HomeMenu homeMenu, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param homeMenu 查询条件
     * @return 总行数
     */
    long count(HomeMenu homeMenu);

    /**
     * 新增数据
     *
     * @param homeMenu 实例对象
     * @return 影响行数
     */
    int insert(HomeMenu homeMenu);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<HomeMenu> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<HomeMenu> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<HomeMenu> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<HomeMenu> entities);

    /**
     * 修改数据
     *
     * @param homeMenu 实例对象
     * @return 影响行数
     */
    int update(HomeMenu homeMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

