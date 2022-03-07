package com.budailad.service.impl;

import com.budailad.entity.TbUser;
import com.budailad.dao.TbUserDao;
import com.budailad.service.TbUserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TbUser)表服务实现类
 *
 * @author makejava
 * @since 2022-03-07 16:28:27
 */
@Service("tbUserService")
public class TbUserServiceImpl implements TbUserService {
    @Resource
    private TbUserDao tbUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbUser queryById(Integer id) {
        return this.tbUserDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbUser      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbUser> queryByPage(TbUser tbUser, PageRequest pageRequest) {
        long total = this.tbUserDao.count(tbUser);
        return new PageImpl<>(this.tbUserDao.queryAllByLimit(tbUser, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    public TbUser insert(TbUser tbUser) {
        this.tbUserDao.insert(tbUser);
        return tbUser;
    }

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    public TbUser update(TbUser tbUser) {
        this.tbUserDao.update(tbUser);
        return this.queryById(tbUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbUserDao.deleteById(id) > 0;
    }
}
