package xyz.ibudai.service;

import xyz.ibudai.entity.PatientInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (PatientInfo)表服务接口
 *
 * @author Budai
 * @since 2022-03-29 15:57:13
 */
public interface PatientInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param patientId 主键
     * @return 实例对象
     */
    PatientInfo queryById(String patientId);

    /**
     *
     * @return
     */
    List<PatientInfo> getAdded();

    /**
     * 条件查询
     *
     * @param patientInfo 筛选条件
     * @return 查询结果
     */
    List<PatientInfo> conditionQuery(PatientInfo patientInfo);

    /**
     * 分页查询
     *
     * @param patientInfo 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<PatientInfo> queryByPage(PatientInfo patientInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param patientInfo 实例对象
     * @return 实例对象
     */
    PatientInfo insert(PatientInfo patientInfo);

    /**
     * 修改数据
     *
     * @param patientInfo 实例对象
     * @return 实例对象
     */
    PatientInfo update(PatientInfo patientInfo);

    /**
     * 通过主键删除数据
     *
     * @param patientId 主键
     * @return 是否成功
     */
    boolean deleteById(String patientId);

}
