package com.budailad.service.impl;

import com.budailad.entity.OrganizeStaff;
import com.budailad.dao.OrganizeStaffDao;
import com.budailad.service.OrganizeStaffService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (OrganizeStaff)表服务实现类
 *
 * @Author Budai
 * @Since 2022-03-07 16:25:46
 */
@Service("organizeStaffService")
public class OrganizeStaffServiceImpl implements OrganizeStaffService {
    @Resource
    private OrganizeStaffDao organizeStaffDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrganizeStaff queryById(Integer id) {
        return this.organizeStaffDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param organizeStaff 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    @Override
    public Page<OrganizeStaff> queryByPage(OrganizeStaff organizeStaff, PageRequest pageRequest) {
        long total = this.organizeStaffDao.count(organizeStaff);
        return new PageImpl<>(this.organizeStaffDao.queryAllByLimit(organizeStaff, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param organizeStaff 实例对象
     * @return 实例对象
     */
    @Override
    public OrganizeStaff insert(OrganizeStaff organizeStaff) {
        this.organizeStaffDao.insert(organizeStaff);
        return organizeStaff;
    }

    /**
     * 修改数据
     *
     * @param organizeStaff 实例对象
     * @return 实例对象
     */
    @Override
    public OrganizeStaff update(OrganizeStaff organizeStaff) {
        this.organizeStaffDao.update(organizeStaff);
        return this.queryById(organizeStaff.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.organizeStaffDao.deleteById(id) > 0;
    }
}
