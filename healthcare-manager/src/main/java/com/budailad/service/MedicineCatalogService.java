package com.budailad.service;

import com.budailad.entity.MedicineCatalog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (MedicineCatalog)表服务接口
 *
 * @author Budai
 * @since 2022-03-11 16:21:04
 */
public interface MedicineCatalogService {

    /**
     * 通过ID查询单条数据
     *
     * @param drugId 主键
     * @return 实例对象
     */
    MedicineCatalog queryById(String drugId);

    /**
     * 条件查询
     *
     * @param medicineCatalog 筛选条件
     * @return 查询结果
     */
    List<MedicineCatalog> conditionQuery(MedicineCatalog medicineCatalog);

    /**
     * 分页查询
     *
     * @param medicineCatalog 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    Page<MedicineCatalog> queryByPage(MedicineCatalog medicineCatalog, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param medicineCatalog 实例对象
     * @return 实例对象
     */
    MedicineCatalog insert(MedicineCatalog medicineCatalog);

    /**
     * 修改数据
     *
     * @param medicineCatalog 实例对象
     * @return 实例对象
     */
    MedicineCatalog update(MedicineCatalog medicineCatalog);

    /**
     * 通过主键删除数据
     *
     * @param drugId 主键
     * @return 是否成功
     */
    boolean deleteById(String drugId);

}
