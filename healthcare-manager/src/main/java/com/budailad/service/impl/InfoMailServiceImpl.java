package com.budailad.service.impl;

import com.budailad.entity.InfoMail;
import com.budailad.dao.InfoMailDao;
import com.budailad.service.InfoMailService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (InfoMail)表服务实现类
 *
 * @Author Budai
 * @Since 2022-03-07 16:25:01
 */
@Service("infoMailService")
public class InfoMailServiceImpl implements InfoMailService {
    @Resource
    private InfoMailDao infoMailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param mailId 主键
     * @return 实例对象
     */
    @Override
    public InfoMail queryById(String mailId) {
        return this.infoMailDao.queryById(mailId);
    }

    /**
     * 分页查询
     *
     * @param infoMail    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<InfoMail> queryByPage(InfoMail infoMail, PageRequest pageRequest) {
        long total = this.infoMailDao.count(infoMail);
        return new PageImpl<>(this.infoMailDao.queryAllByLimit(infoMail, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param infoMail 实例对象
     * @return 实例对象
     */
    @Override
    public InfoMail insert(InfoMail infoMail) {
        this.infoMailDao.insert(infoMail);
        return infoMail;
    }

    /**
     * 修改数据
     *
     * @param infoMail 实例对象
     * @return 实例对象
     */
    @Override
    public InfoMail update(InfoMail infoMail) {
        this.infoMailDao.update(infoMail);
        return this.queryById(infoMail.getMailId());
    }

    /**
     * 通过主键删除数据
     *
     * @param mailId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String mailId) {
        return this.infoMailDao.deleteById(mailId) > 0;
    }
}
