package xyz.ibudai.service.impl;

import xyz.ibudai.entity.PatientCostInfo;
import xyz.ibudai.dao.PatientCostInfoDao;
import xyz.ibudai.service.PatientCostInfoService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PatientCostInfo)表服务实现类
 *
 * @author Budai
 * @since 2022-04-06 14:07:05
 */
@Service("patientCostInfoService")
@CacheConfig(cacheNames = "patientCostInfo")
public class PatientCostInfoServiceImpl implements PatientCostInfoService {
    @Resource
    private PatientCostInfoDao patientCostInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param costId 主键
     * @return 实例对象
     */
    @Override
    public PatientCostInfo queryById(String costId) {
        return this.patientCostInfoDao.queryById(costId);
    }

    /**
     * 条件查询
     *
     * @param patientCostInfo 筛选条件
     * @return 查询结果
     */
    @Override
    public List<PatientCostInfo> conditionQuery(PatientCostInfo patientCostInfo) {
        return this.patientCostInfoDao.conditionQuery(patientCostInfo);
    }

    /**
     * 分页查询
     *
     * @param patientCostInfo 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @Override
    public Page<PatientCostInfo> queryByPage(PatientCostInfo patientCostInfo, PageRequest pageRequest) {
        long total = this.patientCostInfoDao.count(patientCostInfo);
        return new PageImpl<>(this.patientCostInfoDao.queryAllByLimit(patientCostInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param patientCostInfo 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(PatientCostInfo patientCostInfo) {
        return this.patientCostInfoDao.insert(patientCostInfo);
    }

    /**
     * 修改数据
     *
     * @param patientCostInfo 实例对象
     * @return 实例对象
     */
    @Override
    public PatientCostInfo update(PatientCostInfo patientCostInfo) {
        this.patientCostInfoDao.update(patientCostInfo);
        return this.queryById(patientCostInfo.getCostId());
    }

    /**
     * 通过主键删除数据
     *
     * @param costId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String costId) {
        return this.patientCostInfoDao.deleteById(costId) > 0;
    }
}
