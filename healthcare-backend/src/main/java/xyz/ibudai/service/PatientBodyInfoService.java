package xyz.ibudai.service;

import xyz.ibudai.entity.PatientBodyInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (PatientBodyInfo)表服务接口
 *
 * @author Budai
 * @since 2022-03-30 09:20:21
 */
public interface PatientBodyInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PatientBodyInfo queryById(String id);

    /**
     * 条件查询
     *
     * @param patientBodyInfo 筛选条件
     * @return 查询结果
     */
    List<PatientBodyInfo> conditionQuery(PatientBodyInfo patientBodyInfo);

    /**
     * 分页查询
     *
     * @param patientBodyInfo 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    Page<PatientBodyInfo> queryByPage(PatientBodyInfo patientBodyInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param patientBodyInfo 实例对象
     * @return 实例对象
     */
    PatientBodyInfo insert(PatientBodyInfo patientBodyInfo);


    /**
     * 批量新增
     *
     * @param patientBodyInfoList
     * @return
     */
    int insertBatch(List<PatientBodyInfo> patientBodyInfoList);

    /**
     * 修改数据
     *
     * @param patientBodyInfo 实例对象
     * @return 实例对象
     */
    PatientBodyInfo update(PatientBodyInfo patientBodyInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
