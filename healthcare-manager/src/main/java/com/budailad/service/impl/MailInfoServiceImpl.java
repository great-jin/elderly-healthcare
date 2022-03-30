package com.budailad.service.impl;

import com.budailad.entity.MailInfo;
import com.budailad.dao.MailInfoDao;
import com.budailad.service.MailInfoService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MailInfo)表服务实现类
 *
 * @author Budai
 * @since 2022-03-11 16:21:07
 */
@Service("mailInfoService")
@CacheConfig(cacheNames = "mailInfo")
public class MailInfoServiceImpl implements MailInfoService {
    @Resource
    private MailInfoDao mailInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param mailId 主键
     * @return 实例对象
     */
    @Override
    public MailInfo queryById(String mailId) {
        return this.mailInfoDao.queryById(mailId);
    }

    /**
     * 条件查询
     *
     * @param mailInfo 筛选条件
     * @return 查询结果
     */
    @Override
    @Cacheable(key = "'list'")
    public List<MailInfo> queryAll(MailInfo mailInfo) {
        return this.mailInfoDao.queryAll(mailInfo);
    }

    /**
     * 分页查询
     *
     * @param mailInfo    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<MailInfo> queryByPage(MailInfo mailInfo, PageRequest pageRequest) {
        long total = this.mailInfoDao.count(mailInfo);
        return new PageImpl<>(this.mailInfoDao.queryAllByLimit(mailInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param mailInfo 实例对象
     * @return 实例对象
     */
    @Override
    @CacheEvict(key = "'list'")
    public MailInfo insert(MailInfo mailInfo) {
        this.mailInfoDao.insert(mailInfo);
        return mailInfo;
    }

    /**
     * 修改数据
     *
     * @param mailInfo 实例对象
     * @return 实例对象
     */
    @Override
    @CacheEvict(key = "'list'")
    public MailInfo update(MailInfo mailInfo) {
        this.mailInfoDao.update(mailInfo);
        return this.queryById(mailInfo.getMailId());
    }

    /**
     * 通过主键删除数据
     *
     * @param mailId 主键
     * @return 是否成功
     */
    @Override
    @CacheEvict(key = "'list'")
    public boolean deleteById(String mailId) {
        return this.mailInfoDao.deleteById(mailId) > 0;
    }
}
