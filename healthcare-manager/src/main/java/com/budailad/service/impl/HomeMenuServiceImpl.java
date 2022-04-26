package com.budailad.service.impl;

import com.budailad.entity.HomeMenu;
import com.budailad.dao.HomeMenuDao;
import com.budailad.service.HomeMenuService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (HomeMenu)表服务实现类
 *
 * @author Budai
 * @since 2022-04-04 11:39:35
 */
@Service("homeMenuService")
@CacheConfig(cacheNames = "homeMenu")
public class HomeMenuServiceImpl implements HomeMenuService {
    @Resource
    private HomeMenuDao homeMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public HomeMenu queryById(Integer id) {
        return this.homeMenuDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param homeMenu    筛选条件
     * @return 查询结果
     */
    @Override
    public List<HomeMenu> queryAll(HomeMenu homeMenu) {
        return this.homeMenuDao.queryAll(homeMenu);
    }

    /**
     * 分页查询
     *
     * @param homeMenu    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<HomeMenu> queryByPage(HomeMenu homeMenu, PageRequest pageRequest) {
        long total = this.homeMenuDao.count(homeMenu);
        return new PageImpl<>(this.homeMenuDao.queryAllByLimit(homeMenu, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param homeMenu 实例对象
     * @return 实例对象
     */
    @Override
    public HomeMenu insert(HomeMenu homeMenu) {
        this.homeMenuDao.insert(homeMenu);
        return homeMenu;
    }

    /**
     * 修改数据
     *
     * @param homeMenu 实例对象
     * @return 实例对象
     */
    @Override
    public HomeMenu update(HomeMenu homeMenu) {
        this.homeMenuDao.update(homeMenu);
        return this.queryById(homeMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.homeMenuDao.deleteById(id) > 0;
    }
}
