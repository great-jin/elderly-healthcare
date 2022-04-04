package com.budailad.service;

import com.budailad.entity.HomeMenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (HomeMenu)表服务接口
 *
 * @author makejava
 * @since 2022-04-04 11:39:35
 */
public interface HomeMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    HomeMenu queryById(Integer id);

    /**
     * 条件查询
     *
     * @param homeMenu
     * @return
     */
    List<HomeMenu> queryAll(HomeMenu homeMenu);

    /**
     * 分页查询
     *
     * @param homeMenu    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<HomeMenu> queryByPage(HomeMenu homeMenu, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param homeMenu 实例对象
     * @return 实例对象
     */
    HomeMenu insert(HomeMenu homeMenu);

    /**
     * 修改数据
     *
     * @param homeMenu 实例对象
     * @return 实例对象
     */
    HomeMenu update(HomeMenu homeMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
