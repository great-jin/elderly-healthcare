package com.budailad.service.impl;

import com.budailad.entity.StaffNurse;
import com.budailad.dao.StaffNurseDao;
import com.budailad.service.StaffNurseService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (StaffNurse)表服务实现类
 *
 * @Author Budai
 * @Since 2022-03-07 16:26:48
 */
@Service("staffNurseService")
public class StaffNurseServiceImpl implements StaffNurseService {
    @Resource
    private StaffNurseDao staffNurseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StaffNurse queryById(Integer id) {
        return this.staffNurseDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param staffNurse  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<StaffNurse> queryByPage(StaffNurse staffNurse, PageRequest pageRequest) {
        long total = this.staffNurseDao.count(staffNurse);
        return new PageImpl<>(this.staffNurseDao.queryAllByLimit(staffNurse, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param staffNurse 实例对象
     * @return 实例对象
     */
    @Override
    public StaffNurse insert(StaffNurse staffNurse) {
        this.staffNurseDao.insert(staffNurse);
        return staffNurse;
    }

    /**
     * 修改数据
     *
     * @param staffNurse 实例对象
     * @return 实例对象
     */
    @Override
    public StaffNurse update(StaffNurse staffNurse) {
        this.staffNurseDao.update(staffNurse);
        return this.queryById(staffNurse.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.staffNurseDao.deleteById(id) > 0;
    }
}