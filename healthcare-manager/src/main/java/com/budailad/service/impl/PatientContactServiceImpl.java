package com.budailad.service.impl;

import com.budailad.entity.PatientContact;
import com.budailad.dao.PatientContactDao;
import com.budailad.service.PatientContactService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(key = "'list'")
    public List<PatientContact> queryAll(PatientContact patientContact) {
        return this.patientContactDao.queryAll(patientContact);
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
    @CacheEvict(key = "'list'")
    public PatientContact insert(PatientContact patientContact) {
        this.patientContactDao.insert(patientContact);
        return patientContact;
    }

    /**
     * 修改数据
     *
     * @param patientContact 实例对象
     * @return 实例对象
     */
    @Override
    @CacheEvict(key = "'list'")
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
    @CacheEvict(key = "'list'")
    public boolean deleteById(String id) {
        return this.patientContactDao.deleteById(id) > 0;
    }
}
