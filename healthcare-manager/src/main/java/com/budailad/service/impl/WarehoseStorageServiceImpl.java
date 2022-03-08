package com.budailad.service.impl;

import com.budailad.entity.WarehoseStorage;
import com.budailad.dao.WarehoseStorageDao;
import com.budailad.service.WarehoseStorageService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (WarehoseStorage)表服务实现类
 *
 * @Author Budai
 * @Since 2022-03-07 16:28:54
 */
@Service("warehoseStorageService")
public class WarehoseStorageServiceImpl implements WarehoseStorageService {
    @Resource
    private WarehoseStorageDao warehoseStorageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    @Override
    public WarehoseStorage queryById(String goodsId) {
        return this.warehoseStorageDao.queryById(goodsId);
    }

    /**
     * 分页查询
     *
     * @param warehoseStorage 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @Override
    public Page<WarehoseStorage> queryByPage(WarehoseStorage warehoseStorage, PageRequest pageRequest) {
        long total = this.warehoseStorageDao.count(warehoseStorage);
        return new PageImpl<>(this.warehoseStorageDao.queryAllByLimit(warehoseStorage, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param warehoseStorage 实例对象
     * @return 实例对象
     */
    @Override
    public WarehoseStorage insert(WarehoseStorage warehoseStorage) {
        this.warehoseStorageDao.insert(warehoseStorage);
        return warehoseStorage;
    }

    /**
     * 修改数据
     *
     * @param warehoseStorage 实例对象
     * @return 实例对象
     */
    @Override
    public WarehoseStorage update(WarehoseStorage warehoseStorage) {
        this.warehoseStorageDao.update(warehoseStorage);
        return this.queryById(warehoseStorage.getGoodsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String goodsId) {
        return this.warehoseStorageDao.deleteById(goodsId) > 0;
    }
}
