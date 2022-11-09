package xyz.ibudai.service.impl;

import xyz.ibudai.entity.OrganizeStaff;
import xyz.ibudai.dao.OrganizeStaffDao;
import xyz.ibudai.service.OrganizeStaffService;
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
 * (OrganizeStaff)表服务实现类
 *
 * @author Budai
 * @since 2022-03-11 16:21:04
 */
@Service("organizeStaffService")
@CacheConfig(cacheNames = "organizeStaff")
public class OrganizeStaffServiceImpl implements OrganizeStaffService {
    @Resource
    private OrganizeStaffDao organizeStaffDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(key = "#id")
    public OrganizeStaff queryById(Integer id) {
        return this.organizeStaffDao.queryById(id);
    }

    @Override
    public String getStaffEmail(String staffId) {
        return this.organizeStaffDao.getStaffEmail(staffId);
    }

    /**
     * 条件查询
     *
     * @param organizeStaff 筛选条件
     * @return 查询结果
     */
    @Override
    public List<OrganizeStaff> conditionQuery(OrganizeStaff organizeStaff) {
        return this.organizeStaffDao.conditionQuery(organizeStaff);
    }

    /**
     *
     * @return
     */
    @Override
    public List<OrganizeStaff> getAllStaff() {
        return this.organizeStaffDao.getAllStaff();
    }

    /**
     * 分页查询
     *
     * @param organizeStaff 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    @Override
    public Page<OrganizeStaff> queryByPage(OrganizeStaff organizeStaff, PageRequest pageRequest) {
        long total = this.organizeStaffDao.count(organizeStaff);
        return new PageImpl<>(this.organizeStaffDao.queryAllByLimit(organizeStaff, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param organizeStaff 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(OrganizeStaff organizeStaff) {
        return this.organizeStaffDao.insert(organizeStaff);
    }

    /**
     * 修改数据
     *
     * @param organizeStaff 实例对象
     * @return 实例对象
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "#organizeStaff.id")
    })
    public int update(OrganizeStaff organizeStaff) {
        return this.organizeStaffDao.update(organizeStaff);
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
    public boolean deleteById(Integer id) {
        return this.organizeStaffDao.deleteById(id) > 0;
    }
}
