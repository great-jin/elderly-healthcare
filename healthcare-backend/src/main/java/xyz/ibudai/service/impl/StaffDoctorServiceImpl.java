package xyz.ibudai.service.impl;

import xyz.ibudai.entity.StaffDoctor;
import xyz.ibudai.dao.StaffDoctorDao;
import xyz.ibudai.service.StaffDoctorService;
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
 * (StaffDoctor)表服务实现类
 *
 * @author Budai
 * @since 2022-03-11 16:21:08
 */
@Service("staffDoctorService")
@CacheConfig(cacheNames = "staffDoctor")
public class StaffDoctorServiceImpl implements StaffDoctorService {
    @Resource
    private StaffDoctorDao staffDoctorDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(key = "#id")
    public StaffDoctor queryById(Integer id) {
        return this.staffDoctorDao.queryById(id);
    }

    /**
     * 条件查询
     *
     * @param staffDoctor 筛选条件
     * @return 查询结果
     */
    @Override
    public List<StaffDoctor> conditionQuery(StaffDoctor staffDoctor) {
        return this.staffDoctorDao.conditionQuery(staffDoctor);
    }

    /**
     * 分页查询
     *
     * @param staffDoctor 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<StaffDoctor> queryByPage(StaffDoctor staffDoctor, PageRequest pageRequest) {
        long total = this.staffDoctorDao.count(staffDoctor);
        return new PageImpl<>(this.staffDoctorDao.queryAllByLimit(staffDoctor, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param staffDoctor 实例对象
     * @return 实例对象
     */
    @Override
    public StaffDoctor insert(StaffDoctor staffDoctor) {
        this.staffDoctorDao.insert(staffDoctor);
        return staffDoctor;
    }

    /**
     * 修改数据
     *
     * @param staffDoctor 实例对象
     * @return 实例对象
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "#staffDoctor.id")
    })
    public int update(StaffDoctor staffDoctor) {
        return this.staffDoctorDao.update(staffDoctor);
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
        return this.staffDoctorDao.deleteById(id) > 0;
    }
}
