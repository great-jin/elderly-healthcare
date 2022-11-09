package xyz.ibudai.service.impl;

import xyz.ibudai.entity.OrganizeInfo;
import xyz.ibudai.dao.OrganizeInfoDao;
import xyz.ibudai.service.OrganizeInfoService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
@CacheConfig(cacheNames = "organizeInfo")
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
    @Cacheable(key = "#organizeId")
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
    public List<OrganizeInfo> conditionQuery(OrganizeInfo organizeInfo) {
        return this.organizeInfoDao.conditionQuery(organizeInfo);
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
    @Caching(evict = {
            @CacheEvict(key = "#organizeInfo.organizeId")
    })
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
    @Caching(evict = {
            @CacheEvict(key = "#organizeId")
    })
    public boolean deleteById(String organizeId) {
        return this.organizeInfoDao.deleteById(organizeId) > 0;
    }
}
