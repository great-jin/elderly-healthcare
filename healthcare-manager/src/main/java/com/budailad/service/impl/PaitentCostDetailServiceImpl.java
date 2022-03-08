package com.budailad.service.impl;

import com.budailad.entity.PaitentCostDetail;
import com.budailad.dao.PaitentCostDetailDao;
import com.budailad.service.PaitentCostDetailService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (PaitentCostDetail)表服务实现类
 *
 * @Author Budai
 * @Since 2022-03-07 16:25:59
 */
@Service("paitentCostDetailService")
public class PaitentCostDetailServiceImpl implements PaitentCostDetailService {
    @Resource
    private PaitentCostDetailDao paitentCostDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PaitentCostDetail queryById(Integer id) {
        return this.paitentCostDetailDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param paitentCostDetail 筛选条件
     * @param pageRequest       分页对象
     * @return 查询结果
     */
    @Override
    public Page<PaitentCostDetail> queryByPage(PaitentCostDetail paitentCostDetail, PageRequest pageRequest) {
        long total = this.paitentCostDetailDao.count(paitentCostDetail);
        return new PageImpl<>(this.paitentCostDetailDao.queryAllByLimit(paitentCostDetail, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param paitentCostDetail 实例对象
     * @return 实例对象
     */
    @Override
    public PaitentCostDetail insert(PaitentCostDetail paitentCostDetail) {
        this.paitentCostDetailDao.insert(paitentCostDetail);
        return paitentCostDetail;
    }

    /**
     * 修改数据
     *
     * @param paitentCostDetail 实例对象
     * @return 实例对象
     */
    @Override
    public PaitentCostDetail update(PaitentCostDetail paitentCostDetail) {
        this.paitentCostDetailDao.update(paitentCostDetail);
        return this.queryById(paitentCostDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.paitentCostDetailDao.deleteById(id) > 0;
    }
}
