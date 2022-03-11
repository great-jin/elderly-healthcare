package com.budailad.service;

import com.budailad.entity.MailInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (MailInfo)表服务接口
 *
 * @author Budai
 * @since 2022-03-11 16:21:07
 */
public interface MailInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param mailId 主键
     * @return 实例对象
     */
    MailInfo queryById(String mailId);

    /**
     * 分页查询
     *
     * @param mailInfo    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<MailInfo> queryByPage(MailInfo mailInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param mailInfo 实例对象
     * @return 实例对象
     */
    MailInfo insert(MailInfo mailInfo);

    /**
     * 修改数据
     *
     * @param mailInfo 实例对象
     * @return 实例对象
     */
    MailInfo update(MailInfo mailInfo);

    /**
     * 通过主键删除数据
     *
     * @param mailId 主键
     * @return 是否成功
     */
    boolean deleteById(String mailId);

}
