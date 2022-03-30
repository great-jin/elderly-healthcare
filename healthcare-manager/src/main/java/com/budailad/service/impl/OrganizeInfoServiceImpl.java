package com.budailad.service.impl;

import com.budailad.entity.OrganizeInfo;
import com.budailad.dao.OrganizeInfoDao;
import com.budailad.service.OrganizeInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OrganizeInfo)表服务实现类
 *
 * @author Budai
 * @since 2022-03-11 16:21:04
 */
@Service("organizeInfoService")
public class OrganizeInfoServiceImpl implements OrganizeInfoService {
    @Resource
    private OrganizeInfoDao organizeInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param organizeId 主键
     * @return 实例对象
     */
    @Override
    public OrganizeInfo queryById(String organizeId) {
        return this.organizeInfoDao.queryById(organizeId);
    }

    /**
     * 条件查询
     *
     * @param organizeInfo 筛选条件
     * @return 查询结果
     */
    @Override
    public List<OrganizeInfo> queryAll(OrganizeInfo organizeInfo) {
        return this.organizeInfoDao.queryAll(organizeInfo);
    }

    /**
     * 分页查询
     *
     * @param organizeInfo 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    @Override
    public Page<OrganizeInfo> queryByPage(OrganizeInfo organizeInfo, PageRequest pageRequest) {
        long total = this.organizeInfoDao.count(organizeInfo);
        return new PageImpl<>(this.organizeInfoDao.queryAllByLimit(organizeInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param organizeInfo 实例对象
     * @return 实例对象
     */
    @Override
    public OrganizeInfo insert(OrganizeInfo organizeInfo) {
        this.organizeInfoDao.insert(organizeInfo);
        return organizeInfo;
    }

    /**
     * 修改数据
     *
     * @param organizeInfo 实例对象
     * @return 实例对象
     */
    @Override
    public OrganizeInfo update(OrganizeInfo organizeInfo) {
        this.organizeInfoDao.update(organizeInfo);
        return this.queryById(organizeInfo.getOrganizeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param organizeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String organizeId) {
        return this.organizeInfoDao.deleteById(organizeId) > 0;
    }
}
