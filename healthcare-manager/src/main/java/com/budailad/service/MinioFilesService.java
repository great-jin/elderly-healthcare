package com.budailad.service;

import com.budailad.entity.MinioFiles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (MinioFiles)表服务接口
 *
 * @author Budai
 * @since 2022-03-11 16:21:08
 */
public interface MinioFilesService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MinioFiles queryById(String id);

    /**
     * 分页查询
     *
     * @param minioFiles  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<MinioFiles> queryByPage(MinioFiles minioFiles, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param minioFiles 实例对象
     * @return 实例对象
     */
    MinioFiles insert(MinioFiles minioFiles);

    /**
     * 修改数据
     *
     * @param minioFiles 实例对象
     * @return 实例对象
     */
    MinioFiles update(MinioFiles minioFiles);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
