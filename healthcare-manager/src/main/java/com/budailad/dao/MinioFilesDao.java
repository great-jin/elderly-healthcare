package com.budailad.dao;

import com.budailad.entity.MinioFiles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (MinioFiles)表数据库访问层
 *
 * @author Budai
 * @since 2022-03-11 16:21:08
 */
@Mapper
public interface MinioFilesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MinioFiles queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param minioFiles 查询条件
     * @param pageable   分页对象
     * @return 对象列表
     */
    List<MinioFiles> queryAllByLimit(MinioFiles minioFiles, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param minioFiles 查询条件
     * @return 总行数
     */
    long count(MinioFiles minioFiles);

    /**
     * 新增数据
     *
     * @param minioFiles 实例对象
     * @return 影响行数
     */
    int insert(MinioFiles minioFiles);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MinioFiles> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MinioFiles> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MinioFiles> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MinioFiles> entities);

    /**
     * 修改数据
     *
     * @param minioFiles 实例对象
     * @return 影响行数
     */
    int update(MinioFiles minioFiles);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

