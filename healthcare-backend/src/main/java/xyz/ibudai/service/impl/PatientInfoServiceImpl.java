package xyz.ibudai.service.impl;

import xyz.ibudai.entity.PatientInfo;
import xyz.ibudai.dao.PatientInfoDao;
import xyz.ibudai.service.PatientInfoService;
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
 * (PatientInfo)表服务实现类
 *
 * @author Budai
 * @since 2022-03-29 15:57:13
 */
@Service("patientInfoService")
@CacheConfig(cacheNames = "patientInfo")
public class PatientInfoServiceImpl implements PatientInfoService {
    @Resource
    private PatientInfoDao patientInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param patientId 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(key = "#patientId")
    public PatientInfo queryById(String patientId) {
        return this.patientInfoDao.queryById(patientId);
    }

    /**
     * 条件查询
     *
     * @param patientInfo 筛选条件
     * @return 查询结果
     */
    @Override
    public List<PatientInfo> conditionQuery(PatientInfo patientInfo) {
        return this.patientInfoDao.conditionQuery(patientInfo);
    }

    /**
     * 分页查询
     *
     * @param patientInfo 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<PatientInfo> queryByPage(PatientInfo patientInfo, PageRequest pageRequest) {
        long total = this.patientInfoDao.count(patientInfo);
        return new PageImpl<>(this.patientInfoDao.queryAllByLimit(patientInfo, pageRequest), pageRequest, total);
    }

    /**
     *
     * @return
     */
    @Override
    public List<PatientInfo> getAdded() {
        return this.patientInfoDao.getAdded();
    }


    /**
     * 新增数据
     *
     * @param patientInfo 实例对象
     * @return 实例对象
     */
    @Override
    public PatientInfo insert(PatientInfo patientInfo) {
        this.patientInfoDao.insert(patientInfo);
        return patientInfo;
    }

    /**
     * 修改数据
     *
     * @param patientInfo 实例对象
     * @return 实例对象
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "#patientInfo.patientId")
    })
    public PatientInfo update(PatientInfo patientInfo) {
        this.patientInfoDao.update(patientInfo);
        return this.queryById(patientInfo.getPatientId());
    }

    /**
     * 通过主键删除数据
     *
     * @param patientId 主键
     * @return 是否成功
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "#patientId")
    })
    public boolean deleteById(String patientId) {
        return this.patientInfoDao.deleteById(patientId) > 0;
    }
}
