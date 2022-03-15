package com.budailad.service.impl;

import com.budailad.entity.LoginUser;
import com.budailad.dao.LoginUserDao;
import com.budailad.service.LoginUserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (LoginUser)表服务实现类
 *
 * @author Budai
 * @since 2022-03-11 16:21:07
 */
@Service("loginUserService")
//@CacheConfig(cacheNames = "login")
public class LoginUserServiceImpl implements LoginUserService {
    @Resource
    private LoginUserDao loginUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
//    @Cacheable(key = "#id")
    public LoginUser queryById(String id) {
        return this.loginUserDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param loginUser   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<LoginUser> queryByPage(LoginUser loginUser, PageRequest pageRequest) {
        long total = this.loginUserDao.count(loginUser);
        return new PageImpl<>(this.loginUserDao.queryAllByLimit(loginUser, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param loginUser 实例对象
     * @return 实例对象
     */
    @Override
    public LoginUser insert(LoginUser loginUser) {
        this.loginUserDao.insert(loginUser);
        return loginUser;
    }

    /**
     * 修改数据
     *
     * @param loginUser 实例对象
     * @return 实例对象
     */
    @Override
    public LoginUser update(LoginUser loginUser) {
        this.loginUserDao.update(loginUser);
        return this.queryById(loginUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.loginUserDao.deleteById(id) > 0;
    }
}
