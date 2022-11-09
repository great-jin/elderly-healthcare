package xyz.ibudai.dao;

import xyz.ibudai.entity.LoginUser;
import xyz.ibudai.entity.dto.LoginUserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (LoginUser)表数据库访问层
 *
 * @author Budai
 * @since 2022-03-11 16:21:07
 */
@Mapper
public interface LoginUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LoginUser queryById(String id);

    /**
     *
     * @param staffId
     * @return
     */
    LoginUserDTO getInfo(String staffId);

    /**
     * 条件查询
     *
     * @param loginUser   筛选条件
     * @return 查询结果
     */
    List<LoginUser> conditionQuery(LoginUser loginUser);

    /**
     * 查询指定行数据
     *
     * @param loginUser 查询条件
     * @param pageable  分页对象
     * @return 对象列表
     */
    List<LoginUser> queryAllByLimit(LoginUser loginUser, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param loginUser 查询条件
     * @return 总行数
     */
    long count(LoginUser loginUser);

    /**
     * 新增数据
     *
     * @param loginUser 实例对象
     * @return 影响行数
     */
    int insert(LoginUser loginUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<LoginUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<LoginUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<LoginUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<LoginUser> entities);

    /**
     * 修改数据
     *
     * @param loginUser 实例对象
     * @return 影响行数
     */
    int update(LoginUser loginUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

