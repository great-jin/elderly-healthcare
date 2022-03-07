package com.budailad.service.impl;

import com.budailad.entity.StaffDoctor;
import com.budailad.dao.StaffDoctorDao;
import com.budailad.service.StaffDoctorService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (StaffDoctor)表服务实现类
 *
 * @author makejava
 * @since 2022-03-07 16:26:35
 */
@Service("staffDoctorService")
public class StaffDoctorServiceImpl implements StaffDoctorService {
    @Resource
    private StaffDoctorDao staffDoctorDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StaffDoctor queryById(Integer id) {
        return this.staffDoctorDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param staffDoctor 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<StaffDoctor> queryByPage(StaffDoctor staffDoctor, PageRequest pageRequest) {
        long total = this.staffDoctorDao.count(staffDoctor);
        return new PageImpl<>(this.staffDoctorDao.queryAllByLimit(staffDoctor, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param staffDoctor 实例对象
     * @return 实例对象
     */
    @Override
    public StaffDoctor insert(StaffDoctor staffDoctor) {
        this.staffDoctorDao.insert(staffDoctor);
        return staffDoctor;
    }

    /**
     * 修改数据
     *
     * @param staffDoctor 实例对象
     * @return 实例对象
     */
    @Override
    public StaffDoctor update(StaffDoctor staffDoctor) {
        this.staffDoctorDao.update(staffDoctor);
        return this.queryById(staffDoctor.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.staffDoctorDao.deleteById(id) > 0;
    }
}
