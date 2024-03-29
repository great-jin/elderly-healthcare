package xyz.ibudai.service.impl;

import xyz.ibudai.entity.LoginUser;
import xyz.ibudai.dao.LoginUserDao;
import xyz.ibudai.entity.dto.LoginUserDTO;
import xyz.ibudai.service.LoginUserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (LoginUser)表服务实现类
 *
 * @author Budai
 * @since 2022-03-11 16:21:07
 */
@Service("loginUserService")
@CacheConfig(cacheNames = "loginUser")
public class LoginUserServiceImpl implements LoginUserService {
    @Resource
    private LoginUserDao loginUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public LoginUser queryById(String id) {
        return this.loginUserDao.queryById(id);
    }

    /**
     * @param staffId
     * @return
     */
    @Override
    public LoginUserDTO getInfo(String staffId) {
        return loginUserDao.getInfo(staffId);
    }

    /**
     * 条件查询
     *
     * @param loginUser   筛选条件
     * @return 查询结果
     */
    @Override
    public List<LoginUser> conditionQuery(LoginUser loginUser) {
        return this.loginUserDao.conditionQuery(loginUser);
    }

    /**
     * 分页查询
     *
     * @param loginUser   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<LoginUser> queryByPage(LoginUser loginUser, PageRequest pageRequest) {
        long total = this.loginUserDao.count(loginUser);
        return new PageImpl<>(this.loginUserDao.queryAllByLimit(loginUser, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param loginUser 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(LoginUser loginUser) {
        return loginUserDao.insert(loginUser);
    }

    /**
     * 修改数据
     *
     * @param loginUser 实例对象
     * @return 实例对象
     */
    @Override
    @CacheEvict(key = "#loginUser.staffId")
    public int update(LoginUser loginUser) {
        return this.loginUserDao.update(loginUser);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @CacheEvict(key = "#loginUser.staffId")
    public boolean deleteById(String id) {
        return this.loginUserDao.deleteById(id) > 0;
    }
}
