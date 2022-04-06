package com.budailad.dao;

import com.budailad.entity.WarehouseStorage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (WarehouseStorage)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-06 14:07:04
 */
@Mapper
public interface WarehouseStorageDao {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    WarehouseStorage queryById(String goodsId);

    /**
     * 条件查询
     *
     * @param warehouseStorage 查询条件
     * @return 对象列表
     */
    List<WarehouseStorage> queryAll(WarehouseStorage warehouseStorage);

    /**
     * 查询指定行数据
     *
     * @param warehouseStorage 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<WarehouseStorage> queryAllByLimit(WarehouseStorage warehouseStorage, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param warehouseStorage 查询条件
     * @return 总行数
     */
    long count(WarehouseStorage warehouseStorage);

    /**
     * 新增数据
     *
     * @param warehouseStorage 实例对象
     * @return 影响行数
     */
    int insert(WarehouseStorage warehouseStorage);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<WarehouseStorage> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<WarehouseStorage> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<WarehouseStorage> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<WarehouseStorage> entities);

    /**
     * 修改数据
     *
     * @param warehouseStorage 实例对象
     * @return 影响行数
     */
    int update(WarehouseStorage warehouseStorage);

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 影响行数
     */
    int deleteById(String goodsId);

}

