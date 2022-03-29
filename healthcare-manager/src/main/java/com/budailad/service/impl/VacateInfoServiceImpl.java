package com.budailad.service.impl;

import com.budailad.entity.VacateInfo;
import com.budailad.dao.VacateInfoDao;
import com.budailad.service.VacateInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (VacateInfo)表服务实现类
 *
 * @author makejava
 * @since 2022-03-29 15:38:02
 */
@Service("vacateInfoService")
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
    public VacateInfo queryById(String id) {
        return this.vacateInfoDao.queryById(id);
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
    public VacateInfo update(VacateInfo vacateInfo) {
        this.vacateInfoDao.update(vacateInfo);
        return this.queryById(vacateInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.vacateInfoDao.deleteById(id) > 0;
    }
}
