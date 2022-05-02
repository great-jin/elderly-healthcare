package com.budailad.service;

import com.budailad.entity.AssetApplyGoods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

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
     * 条件查询
     *
     * @param assetApplyGoods 筛选条件
     * @return 查询结果
     */
    List<AssetApplyGoods> conditionQuery(AssetApplyGoods assetApplyGoods);

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


    int insertBatch(List<AssetApplyGoods> applyGoodsList);

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
    int deleteById(String id);

    /**
     * 根据关联字段删除
     *
     * @param applyId
     * @return
     */
    int deleteByApplyId(String applyId);

}
