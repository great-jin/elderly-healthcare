package com.budailad.service;

import com.budailad.entity.AssetApplyInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (AssetApplyInfo)表服务接口
 *
 * @author Budai
 * @since 2022-03-28 16:00:21
 */
public interface AssetApplyInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param applyId 主键
     * @return 实例对象
     */
    AssetApplyInfo queryById(String applyId);

    /**
     * 条件查询
     *
     * @param assetApplyInfo 筛选条件
     * @return 查询结果
     */
    List<AssetApplyInfo> queryAll(AssetApplyInfo assetApplyInfo);

    /**
     * 分页查询
     *
     * @param assetApplyInfo 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    Page<AssetApplyInfo> queryByPage(AssetApplyInfo assetApplyInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param assetApplyInfo 实例对象
     * @return 实例对象
     */
    AssetApplyInfo insert(AssetApplyInfo assetApplyInfo);

    /**
     * 修改数据
     *
     * @param assetApplyInfo 实例对象
     * @return 实例对象
     */
    AssetApplyInfo update(AssetApplyInfo assetApplyInfo);

    /**
     * 通过主键删除数据
     *
     * @param applyId 主键
     * @return 是否成功
     */
    boolean deleteById(String applyId);

}
