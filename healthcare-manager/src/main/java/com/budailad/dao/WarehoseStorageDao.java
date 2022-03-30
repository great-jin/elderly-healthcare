package com.budailad.dao;

import com.budailad.entity.WarehoseStorage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (WarehoseStorage)表数据库访问层
 *
 * @author Budai
 * @since 2022-03-11 16:21:05
 */
@Mapper
public interface WarehoseStorageDao {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    WarehoseStorage queryById(String goodsId);

    /**
     * 条件查询
     *
     * @param warehoseStorage 筛选条件
     * @return 查询结果
     */
    List<WarehoseStorage> queryAll(WarehoseStorage warehoseStorage);

    /**
     *
     * @return
     */
    List<WarehoseStorage> queryAll();

    /**
     * 查询指定行数据
     *
     * @param warehoseStorage 查询条件
     * @param pageable        分页对象
     * @return 对象列表
     */
    List<WarehoseStorage> queryAllByLimit(WarehoseStorage warehoseStorage, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param warehoseStorage 查询条件
     * @return 总行数
     */
    long count(WarehoseStorage warehoseStorage);

    /**
     * 新增数据
     *
     * @param warehoseStorage 实例对象
     * @return 影响行数
     */
    int insert(WarehoseStorage warehoseStorage);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<WarehoseStorage> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<WarehoseStorage> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<WarehoseStorage> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<WarehoseStorage> entities);

    /**
     * 修改数据
     *
     * @param warehoseStorage 实例对象
     * @return 影响行数
     */
    int update(WarehoseStorage warehoseStorage);

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 影响行数
     */
    int deleteById(String goodsId);

}

