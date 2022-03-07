package com.budailad.service;

import com.budailad.entity.WarehoseStorage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (WarehoseStorage)表服务接口
 *
 * @author makejava
 * @since 2022-03-07 16:28:54
 */
public interface WarehoseStorageService {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    WarehoseStorage queryById(String goodsId);

    /**
     * 分页查询
     *
     * @param warehoseStorage 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    Page<WarehoseStorage> queryByPage(WarehoseStorage warehoseStorage, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param warehoseStorage 实例对象
     * @return 实例对象
     */
    WarehoseStorage insert(WarehoseStorage warehoseStorage);

    /**
     * 修改数据
     *
     * @param warehoseStorage 实例对象
     * @return 实例对象
     */
    WarehoseStorage update(WarehoseStorage warehoseStorage);

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    boolean deleteById(String goodsId);

}
