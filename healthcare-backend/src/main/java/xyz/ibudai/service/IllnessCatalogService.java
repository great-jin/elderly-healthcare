package xyz.ibudai.service;

import xyz.ibudai.entity.IllnessCatalog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (IllnessCatalog)表服务接口
 *
 * @author Budai
 * @since 2022-03-11 16:21:08
 */
public interface IllnessCatalogService {

    /**
     * 通过ID查询单条数据
     *
     * @param illId 主键
     * @return 实例对象
     */
    IllnessCatalog queryById(String illId);

    /**
     * 条件查询
     *
     * @param illnessCatalog 筛选条件
     * @return 查询结果
     */
    List<IllnessCatalog> conditionQuery(IllnessCatalog illnessCatalog);

    /**
     * 分页查询
     *
     * @param illnessCatalog 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    Page<IllnessCatalog> queryByPage(IllnessCatalog illnessCatalog, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param illnessCatalog 实例对象
     * @return 实例对象
     */
    IllnessCatalog insert(IllnessCatalog illnessCatalog);

    /**
     * 修改数据
     *
     * @param illnessCatalog 实例对象
     * @return 实例对象
     */
    IllnessCatalog update(IllnessCatalog illnessCatalog);

    /**
     * 通过主键删除数据
     *
     * @param illId 主键
     * @return 是否成功
     */
    boolean deleteById(String illId);

}
