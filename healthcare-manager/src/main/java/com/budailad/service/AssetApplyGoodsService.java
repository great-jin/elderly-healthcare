package com.budailad.service;

import com.budailad.entity.AssetApplyGoods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (AssetApplyGoods)表服务接口
 *
 * @author Budai
 * @since 2022-03-28 16:00:21
 */
public interface AssetApplyGoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AssetApplyGoods queryById(String id);

    /**
     * 分页查询
     *
     * @param assetApplyGoods 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    Page<AssetApplyGoods> queryByPage(AssetApplyGoods assetApplyGoods, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param assetApplyGoods 实例对象
     * @return 实例对象
     */
    AssetApplyGoods insert(AssetApplyGoods assetApplyGoods);

    /**
     * 修改数据
     *
     * @param assetApplyGoods 实例对象
     * @return 实例对象
     */
    AssetApplyGoods update(AssetApplyGoods assetApplyGoods);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
