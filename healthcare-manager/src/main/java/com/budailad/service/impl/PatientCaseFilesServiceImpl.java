package com.budailad.service.impl;

import com.budailad.entity.PatientCaseFiles;
import com.budailad.dao.PatientCaseFilesDao;
import com.budailad.service.PatientCaseFilesService;
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
 * (PatientCaseFiles)表服务实现类
 *
 * @author Budai
 * @since 2022-03-24 15:54:01
 */
@Service("patientCaseFilesService")
@CacheConfig(cacheNames = "patientCaseFiles")
public class PatientCaseFilesServiceImpl implements PatientCaseFilesService {
    @Resource
    private PatientCaseFilesDao patientCaseFilesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param fileId 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(key = "#fileId")
    public PatientCaseFiles queryById(String fileId) {
        return this.patientCaseFilesDao.queryById(fileId);
    }

    /**
     * 条件查询
     *
     * @param patientCaseFiles 筛选条件
     * @return 查询结果
     */
    @Override
    @Cacheable(key = "'list'")
    public List<PatientCaseFiles> queryAll(PatientCaseFiles patientCaseFiles) {
        return this.patientCaseFilesDao.queryAll(patientCaseFiles);
    }

    /**
     * 分页查询
     *
     * @param patientCaseFiles 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<PatientCaseFiles> queryByPage(PatientCaseFiles patientCaseFiles, PageRequest pageRequest) {
        long total = this.patientCaseFilesDao.count(patientCaseFiles);
        return new PageImpl<>(this.patientCaseFilesDao.queryAllByLimit(patientCaseFiles, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param patientCaseFiles 实例对象
     * @return 实例对象
     */
    @Override
    @CacheEvict(key = "'list'")
    public PatientCaseFiles insert(PatientCaseFiles patientCaseFiles) {
        this.patientCaseFilesDao.insert(patientCaseFiles);
        return patientCaseFiles;
    }

    /**
     * 修改数据
     *
     * @param patientCaseFiles 实例对象
     * @return 实例对象
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "'list'"),
            @CacheEvict(key = "#patientCaseFiles.fileId")
    })
    public PatientCaseFiles update(PatientCaseFiles patientCaseFiles) {
        this.patientCaseFilesDao.update(patientCaseFiles);
        return this.queryById(patientCaseFiles.getFileId());
    }

    /**
     * 通过主键删除数据
     *
     * @param fileId 主键
     * @return 是否成功
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "'list'"),
            @CacheEvict(key = "#fileId")
    })
    public boolean deleteById(String fileId) {
        return this.patientCaseFilesDao.deleteById(fileId) > 0;
    }
}
