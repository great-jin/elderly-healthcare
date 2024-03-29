package xyz.ibudai.service.impl;

import xyz.ibudai.entity.VacateInfo;
import xyz.ibudai.dao.VacateInfoDao;
import xyz.ibudai.service.VacateInfoService;
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
 * (VacateInfo)表服务实现类
 *
 * @author Budai
 * @since 2022-03-29 15:38:02
 */
@Service("vacateInfoService")
@CacheConfig(cacheNames = "vacateInfo")
public class VacateInfoServiceImpl implements VacateInfoService {
    @Resource
    private VacateInfoDao vacateInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(key = "#id")
    public VacateInfo queryById(String id) {
        return this.vacateInfoDao.queryById(id);
    }

    /**
     * 条件查询
     *
     * @param vacateInfo 筛选条件
     * @return 查询结果
     */
    @Override
    public List<VacateInfo> conditionQuery(VacateInfo vacateInfo) {
        return this.vacateInfoDao.conditionQuery(vacateInfo);
    }

    /**
     * 分页查询
     *
     * @param vacateInfo  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<VacateInfo> queryByPage(VacateInfo vacateInfo, PageRequest pageRequest) {
        long total = this.vacateInfoDao.count(vacateInfo);
        return new PageImpl<>(this.vacateInfoDao.queryAllByLimit(vacateInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param vacateInfo 实例对象
     * @return 实例对象
     */
    @Override
    public VacateInfo insert(VacateInfo vacateInfo) {
        this.vacateInfoDao.insert(vacateInfo);
        return vacateInfo;
    }

    /**
     * 修改数据
     *
     * @param vacateInfo 实例对象
     * @return 实例对象
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "#vacateInfo.id")
    })
    public int update(VacateInfo vacateInfo) {
        return this.vacateInfoDao.update(vacateInfo);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "#id")
    })
    public boolean deleteById(String id) {
        return this.vacateInfoDao.deleteById(id) > 0;
    }
}
