package xyz.ibudai.service.impl;

import xyz.ibudai.entity.PatientContact;
import xyz.ibudai.dao.PatientContactDao;
import xyz.ibudai.service.PatientContactService;
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
 * (PatientContact)表服务实现类
 *
 * @author Budai
 * @since 2022-03-28 16:00:20
 */
@Service("patientContactService")
@CacheConfig(cacheNames = "patientContact")
public class PatientContactServiceImpl implements PatientContactService {
    @Resource
    private PatientContactDao patientContactDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(key = "#id")
    public PatientContact queryById(String id) {
        return this.patientContactDao.queryById(id);
    }

    /**
     * 条件查询
     *
     * @param patientContact 筛选条件
     * @return 查询结果
     */
    @Override
    public List<PatientContact> conditionQuery(PatientContact patientContact) {
        return this.patientContactDao.conditionQuery(patientContact);
    }

    /**
     * 分页查询
     *
     * @param patientContact 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @Override
    public Page<PatientContact> queryByPage(PatientContact patientContact, PageRequest pageRequest) {
        long total = this.patientContactDao.count(patientContact);
        return new PageImpl<>(this.patientContactDao.queryAllByLimit(patientContact, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param patientContact 实例对象
     * @return 实例对象
     */
    @Override
    public PatientContact insert(PatientContact patientContact) {
        this.patientContactDao.insert(patientContact);
        return patientContact;
    }

    /**
     * 批量新增
     *
     * @param contactList 实例对象
     * @return 影响行数
     */
    @Override
    public int insertBatch(List<PatientContact> contactList) {
        return this.patientContactDao.insertBatch(contactList);
    }

    /**
     * 修改数据
     *
     * @param patientContact 实例对象
     * @return 实例对象
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "#patientContact.id")
    })
    public PatientContact update(PatientContact patientContact) {
        this.patientContactDao.update(patientContact);
        return this.queryById(patientContact.getId());
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
        return this.patientContactDao.deleteById(id) > 0;
    }
}
