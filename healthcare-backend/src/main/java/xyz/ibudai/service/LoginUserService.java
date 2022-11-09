package xyz.ibudai.service;

import xyz.ibudai.entity.LoginUser;
import xyz.ibudai.entity.dto.LoginUserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (LoginUser)表服务接口
 *
 * @author Budai
 * @since 2022-03-11 16:21:07
 */
public interface LoginUserService {

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
     * 分页查询
     *
     * @param loginUser   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<LoginUser> queryByPage(LoginUser loginUser, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param loginUser 实例对象
     * @return 实例对象
     */
    int insert(LoginUser loginUser);

    /**
     * 修改数据
     *
     * @param loginUser 实例对象
     * @return 实例对象
     */
    int update(LoginUser loginUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
