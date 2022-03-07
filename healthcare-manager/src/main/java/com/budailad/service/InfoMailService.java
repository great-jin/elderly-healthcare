package com.budailad.service;

import com.budailad.entity.InfoMail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (InfoMail)表服务接口
 *
 * @author makejava
 * @since 2022-03-07 16:25:01
 */
public interface InfoMailService {

    /**
     * 通过ID查询单条数据
     *
     * @param mailId 主键
     * @return 实例对象
     */
    InfoMail queryById(String mailId);

    /**
     * 分页查询
     *
     * @param infoMail    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<InfoMail> queryByPage(InfoMail infoMail, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param infoMail 实例对象
     * @return 实例对象
     */
    InfoMail insert(InfoMail infoMail);

    /**
     * 修改数据
     *
     * @param infoMail 实例对象
     * @return 实例对象
     */
    InfoMail update(InfoMail infoMail);

    /**
     * 通过主键删除数据
     *
     * @param mailId 主键
     * @return 是否成功
     */
    boolean deleteById(String mailId);

}
