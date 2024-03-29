package xyz.ibudai.service;

import xyz.ibudai.entity.RegisterTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (RegisterTemplate)表服务接口
 *
 * @author Budai
 * @since 2022-03-11 16:21:06
 */
public interface RegisterTemplateService {

    /**
     * 通过ID查询单条数据
     *
     * @param tempId 主键
     * @return 实例对象
     */
    RegisterTemplate queryById(String tempId);

    /**
     * 条件查询
     *
     * @param registerTemplate 筛选条件
     * @return 查询结果
     */
    List<RegisterTemplate> conditionQuery(RegisterTemplate registerTemplate);

    /**
     * 分页查询
     *
     * @param registerTemplate 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<RegisterTemplate> queryByPage(RegisterTemplate registerTemplate, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param registerTemplate 实例对象
     * @return 实例对象
     */
    RegisterTemplate insert(RegisterTemplate registerTemplate);

    /**
     * 修改数据
     *
     * @param registerTemplate 实例对象
     * @return 实例对象
     */
    RegisterTemplate update(RegisterTemplate registerTemplate);

    /**
     * 通过主键删除数据
     *
     * @param tempId 主键
     * @return 是否成功
     */
    boolean deleteById(String tempId);

}
