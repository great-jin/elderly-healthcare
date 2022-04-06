package com.budailad.service.impl;

import com.budailad.entity.WarehouseStorage;
import com.budailad.dao.WarehouseStorageDao;
import com.budailad.service.WarehouseStorageService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (WarehouseStorage)表服务实现类
 *
 * @author makejava
 * @since 2022-04-06 14:07:04
 */
@Service("warehouseStorageService")
public class WarehouseStorageServiceImpl implements WarehouseStorageService {
    @Resource
    private WarehouseStorageDao warehouseStorageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    @Override
    public WarehouseStorage queryById(String goodsId) {
        return this.warehouseStorageDao.queryById(goodsId);
    }

    /**
     * 条件查询
     *
     * @param warehouseStorage 筛选条件
     * @return 查询结果
     */
    @Override
    public List<WarehouseStorage> queryAll(WarehouseStorage warehouseStorage) {
        return this.warehouseStorageDao.queryAll(warehouseStorage);
    }

    /**
     * 分页查询
     *
     * @param warehouseStorage 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<WarehouseStorage> queryByPage(WarehouseStorage warehouseStorage, PageRequest pageRequest) {
        long total = this.warehouseStorageDao.count(warehouseStorage);
        return new PageImpl<>(this.warehouseStorageDao.queryAllByLimit(warehouseStorage, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param warehouseStorage 实例对象
     * @return 实例对象
     */
    @Override
    public WarehouseStorage insert(WarehouseStorage warehouseStorage) {
        this.warehouseStorageDao.insert(warehouseStorage);
        return warehouseStorage;
    }

    /**
     * 修改数据
     *
     * @param warehouseStorage 实例对象
     * @return 实例对象
     */
    @Override
    public WarehouseStorage update(WarehouseStorage warehouseStorage) {
        this.warehouseStorageDao.update(warehouseStorage);
        return this.queryById(warehouseStorage.getGoodsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String goodsId) {
        return this.warehouseStorageDao.deleteById(goodsId) > 0;
    }
}
