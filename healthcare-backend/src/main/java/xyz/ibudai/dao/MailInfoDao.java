package xyz.ibudai.dao;

import xyz.ibudai.entity.MailInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (MailInfo)表数据库访问层
 *
 * @author Budai
 * @since 2022-03-11 16:21:06
 */
@Mapper
public interface MailInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param mailId 主键
     * @return 实例对象
     */
    MailInfo queryById(String mailId);

    /**
     * 条件查询
     *
     * @param mailInfo    筛选条件
     * @return 查询结果
     */
    List<MailInfo> conditionQuery(MailInfo mailInfo);

    /**
     * 查询指定行数据
     *
     * @param mailInfo 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<MailInfo> queryAllByLimit(MailInfo mailInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param mailInfo 查询条件
     * @return 总行数
     */
    long count(MailInfo mailInfo);

    /**
     * 新增数据
     *
     * @param mailInfo 实例对象
     * @return 影响行数
     */
    int insert(MailInfo mailInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MailInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MailInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MailInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MailInfo> entities);

    /**
     * 修改数据
     *
     * @param mailInfo 实例对象
     * @return 影响行数
     */
    int update(MailInfo mailInfo);

    /**
     * 通过主键删除数据
     *
     * @param mailId 主键
     * @return 影响行数
     */
    int deleteById(String mailId);

}

