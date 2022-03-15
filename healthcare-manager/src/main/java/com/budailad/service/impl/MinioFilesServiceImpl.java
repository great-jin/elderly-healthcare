package com.budailad.service.impl;

import com.budailad.entity.MinioFiles;
import com.budailad.dao.MinioFilesDao;
import com.budailad.service.MinioFilesService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (MinioFiles)表服务实现类
 *
 * @author Budai
 * @since 2022-03-11 16:21:08
 */
@Service("minioFilesService")
@CacheConfig(cacheNames = "minio")
public class MinioFilesServiceImpl implements MinioFilesService {
    @Resource
    private MinioFilesDao minioFilesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(key = "#id")
    public MinioFiles queryById(String id) {
        return this.minioFilesDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param minioFiles  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<MinioFiles> queryByPage(MinioFiles minioFiles, PageRequest pageRequest) {
        long total = this.minioFilesDao.count(minioFiles);
        return new PageImpl<>(this.minioFilesDao.queryAllByLimit(minioFiles, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param minioFiles 实例对象
     * @return 实例对象
     */
    @Override
    public MinioFiles insert(MinioFiles minioFiles) {
        this.minioFilesDao.insert(minioFiles);
        return minioFiles;
    }

    /**
     * 修改数据
     *
     * @param minioFiles 实例对象
     * @return 实例对象
     */
    @Override
    public MinioFiles update(MinioFiles minioFiles) {
        this.minioFilesDao.update(minioFiles);
        return this.queryById(minioFiles.getAccountCode());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.minioFilesDao.deleteById(id) > 0;
    }
}
