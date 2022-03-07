package com.budailad.service.impl;

import com.budailad.entity.OrganizeDepart;
import com.budailad.dao.OrganizeDepartDao;
import com.budailad.service.OrganizeDepartService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (OrganizeDepart)表服务实现类
 *
 * @author makejava
 * @since 2022-03-07 16:25:34
 */
@Service("organizeDepartService")
public class OrganizeDepartServiceImpl implements OrganizeDepartService {
    @Resource
    private OrganizeDepartDao organizeDepartDao;

    /**
     * 通过ID查询单条数据
     *
     * @param departId 主键
     * @return 实例对象
     */
    @Override
    public OrganizeDepart queryById(String departId) {
        return this.organizeDepartDao.queryById(departId);
    }

    /**
     * 分页查询
     *
     * @param organizeDepart 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @Override
    public Page<OrganizeDepart> queryByPage(OrganizeDepart organizeDepart, PageRequest pageRequest) {
        long total = this.organizeDepartDao.count(organizeDepart);
        return new PageImpl<>(this.organizeDepartDao.queryAllByLimit(organizeDepart, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param organizeDepart 实例对象
     * @return 实例对象
     */
    @Override
    public OrganizeDepart insert(OrganizeDepart organizeDepart) {
        this.organizeDepartDao.insert(organizeDepart);
        return organizeDepart;
    }

    /**
     * 修改数据
     *
     * @param organizeDepart 实例对象
     * @return 实例对象
     */
    @Override
    public OrganizeDepart update(OrganizeDepart organizeDepart) {
        this.organizeDepartDao.update(organizeDepart);
        return this.queryById(organizeDepart.getDepartId());
    }

    /**
     * 通过主键删除数据
     *
     * @param departId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String departId) {
        return this.organizeDepartDao.deleteById(departId) > 0;
    }
}
