package xyz.ibudai.service;

import xyz.ibudai.entity.PatientCostInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (PatientCostInfo)表服务接口
 *
 * @author Budai
 * @since 2022-04-06 14:07:05
 */
public interface PatientCostInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param costId 主键
     * @return 实例对象
     */
    PatientCostInfo queryById(String costId);

    /**
     * 条件查询
     *
     * @param patientCostInfo 筛选条件
     * @return 查询结果
     */
    List<PatientCostInfo> conditionQuery(PatientCostInfo patientCostInfo);

    /**
     * 分页查询
     *
     * @param patientCostInfo 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    Page<PatientCostInfo> queryByPage(PatientCostInfo patientCostInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param patientCostInfo 实例对象
     * @return 实例对象
     */
    int insert(PatientCostInfo patientCostInfo);

    /**
     * 修改数据
     *
     * @param patientCostInfo 实例对象
     * @return 实例对象
     */
    PatientCostInfo update(PatientCostInfo patientCostInfo);

    /**
     * 通过主键删除数据
     *
     * @param costId 主键
     * @return 是否成功
     */
    boolean deleteById(String costId);

}
