package com.budailad.service;

import com.budailad.entity.WarehouseStorage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (WarehouseStorage)表服务接口
 *
 * @author makejava
 * @since 2022-04-06 14:07:04
 */
public interface WarehouseStorageService {

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
     * @param warehouseStorage 筛选条件
     * @return 查询结果
     */
    List<WarehouseStorage> queryAll(WarehouseStorage warehouseStorage);

    /**
     * 分页查询
     *
     * @param warehouseStorage 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<WarehouseStorage> queryByPage(WarehouseStorage warehouseStorage, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param warehouseStorage 实例对象
     * @return 实例对象
     */
    WarehouseStorage insert(WarehouseStorage warehouseStorage);

    /**
     * 修改数据
     *
     * @param warehouseStorage 实例对象
     * @return 实例对象
     */
    WarehouseStorage update(WarehouseStorage warehouseStorage);

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    boolean deleteById(String goodsId);

}
