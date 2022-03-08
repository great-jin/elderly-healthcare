package com.budailad.service.impl;

import com.budailad.entity.StaffUser;
import com.budailad.dao.StaffUserDao;
import com.budailad.service.StaffUserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (StaffUser)表服务实现类
 *
 * @Author Budai
 * @Since 2022-03-07 16:27:51
 */
@Service("staffUserService")
public class StaffUserServiceImpl implements StaffUserService {
    @Resource
    private StaffUserDao staffUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StaffUser queryById(Integer id) {
        return this.staffUserDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param staffUser   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<StaffUser> queryByPage(StaffUser staffUser, PageRequest pageRequest) {
        long total = this.staffUserDao.count(staffUser);
        return new PageImpl<>(this.staffUserDao.queryAllByLimit(staffUser, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param staffUser 实例对象
     * @return 实例对象
     */
    @Override
    public StaffUser insert(StaffUser staffUser) {
        this.staffUserDao.insert(staffUser);
        return staffUser;
    }

    /**
     * 修改数据
     *
     * @param staffUser 实例对象
     * @return 实例对象
     */
    @Override
    public StaffUser update(StaffUser staffUser) {
        this.staffUserDao.update(staffUser);
        return this.queryById(staffUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.staffUserDao.deleteById(id) > 0;
    }
}
