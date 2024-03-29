package xyz.ibudai.service;

import xyz.ibudai.entity.SalaryDetailFiles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (SalaryDetailFiles)表服务接口
 *
 * @author Budai
 * @since 2022-03-24 15:54:00
 */
public interface SalaryDetailFilesService {

    /**
     * 通过ID查询单条数据
     *
     * @param fileId 主键
     * @return 实例对象
     */
    SalaryDetailFiles queryById(String fileId);

    /**
     * 条件查询
     *
     * @param salaryDetailFiles 筛选条件
     * @return 查询结果
     */
    List<SalaryDetailFiles> conditionQuery(SalaryDetailFiles salaryDetailFiles);

    /**
     * 分页查询
     *
     * @param salaryDetailFiles 筛选条件
     * @param pageRequest       分页对象
     * @return 查询结果
     */
    Page<SalaryDetailFiles> queryByPage(SalaryDetailFiles salaryDetailFiles, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param salaryDetailFiles 实例对象
     * @return 实例对象
     */
    SalaryDetailFiles insert(SalaryDetailFiles salaryDetailFiles);

    /**
     * 修改数据
     *
     * @param salaryDetailFiles 实例对象
     * @return 实例对象
     */
    SalaryDetailFiles update(SalaryDetailFiles salaryDetailFiles);

    /**
     * 通过主键删除数据
     *
     * @param fileId 主键
     * @return 是否成功
     */
    boolean deleteById(String fileId);

}
