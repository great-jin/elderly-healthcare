package xyz.ibudai.dao;

import xyz.ibudai.entity.AssetApplyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (AssetApplyInfo)表数据库访问层
 *
 * @author Budai
 * @since 2022-03-28 16:00:21
 */
@Mapper
public interface AssetApplyInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param applyId 主键
     * @return 实例对象
     */
    AssetApplyInfo queryById(String applyId);

    /**
     * 条件查询
     *
     * @param assetApplyInfo 筛选条件
     * @return 查询结果
     */
    List<AssetApplyInfo> conditionQuery(AssetApplyInfo assetApplyInfo);

    /**
     * 查询指定行数据
     *
     * @param assetApplyInfo 查询条件
     * @param pageable       分页对象
     * @return 对象列表
     */
    List<AssetApplyInfo> queryAllByLimit(AssetApplyInfo assetApplyInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param assetApplyInfo 查询条件
     * @return 总行数
     */
    long count(AssetApplyInfo assetApplyInfo);

    /**
     * 新增数据
     *
     * @param assetApplyInfo 实例对象
     * @return 影响行数
     */
    int insert(AssetApplyInfo assetApplyInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AssetApplyInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AssetApplyInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AssetApplyInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AssetApplyInfo> entities);

    /**
     * 修改数据
     *
     * @param assetApplyInfo 实例对象
     * @return 影响行数
     */
    int update(AssetApplyInfo assetApplyInfo);

    /**
     * 通过主键删除数据
     *
     * @param applyId 主键
     * @return 影响行数
     */
    int deleteById(String applyId);

}

