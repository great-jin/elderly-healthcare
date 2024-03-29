package xyz.ibudai.service;

import xyz.ibudai.entity.PatientContact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (PatientContact)表服务接口
 *
 * @author Budai
 * @since 2022-03-28 16:00:20
 */
public interface PatientContactService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PatientContact queryById(String id);

    /**
     * 条件查询
     *
     * @param patientContact 筛选条件
     * @return 查询结果
     */
    List<PatientContact> conditionQuery(PatientContact patientContact);

    /**
     * 分页查询
     *
     * @param patientContact 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    Page<PatientContact> queryByPage(PatientContact patientContact, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param patientContact 实例对象
     * @return 实例对象
     */
    PatientContact insert(PatientContact patientContact);

    /**
     * 批量新增
     *
     * @param contactList 实例对象
     * @return 影响行数
     */
    int insertBatch(List<PatientContact> contactList);

    /**
     * 修改数据
     *
     * @param patientContact 实例对象
     * @return 实例对象
     */
    PatientContact update(PatientContact patientContact);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
