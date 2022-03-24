package com.budailad.service.impl;

import com.budailad.entity.SalaryDetailFiles;
import com.budailad.dao.SalaryDetailFilesDao;
import com.budailad.service.SalaryDetailFilesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (SalaryDetailFiles)表服务实现类
 *
 * @author makejava
 * @since 2022-03-24 15:54:00
 */
@Service("salaryDetailFilesService")
public class SalaryDetailFilesServiceImpl implements SalaryDetailFilesService {
    @Resource
    private SalaryDetailFilesDao salaryDetailFilesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param fileId 主键
     * @return 实例对象
     */
    @Override
    public SalaryDetailFiles queryById(String fileId) {
        return this.salaryDetailFilesDao.queryById(fileId);
    }

    /**
     * 分页查询
     *
     * @param salaryDetailFiles 筛选条件
     * @param pageRequest       分页对象
     * @return 查询结果
     */
    @Override
    public Page<SalaryDetailFiles> queryByPage(SalaryDetailFiles salaryDetailFiles, PageRequest pageRequest) {
        long total = this.salaryDetailFilesDao.count(salaryDetailFiles);
        return new PageImpl<>(this.salaryDetailFilesDao.queryAllByLimit(salaryDetailFiles, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param salaryDetailFiles 实例对象
     * @return 实例对象
     */
    @Override
    public SalaryDetailFiles insert(SalaryDetailFiles salaryDetailFiles) {
        this.salaryDetailFilesDao.insert(salaryDetailFiles);
        return salaryDetailFiles;
    }

    /**
     * 修改数据
     *
     * @param salaryDetailFiles 实例对象
     * @return 实例对象
     */
    @Override
    public SalaryDetailFiles update(SalaryDetailFiles salaryDetailFiles) {
        this.salaryDetailFilesDao.update(salaryDetailFiles);
        return this.queryById(salaryDetailFiles.getFileId());
    }

    /**
     * 通过主键删除数据
     *
     * @param fileId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String fileId) {
        return this.salaryDetailFilesDao.deleteById(fileId) > 0;
    }
}
