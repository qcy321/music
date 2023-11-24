package com.mu.mapper;

import com.mu.entities.AttentionMv;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * (AttentionMv)表数据库访问层
 *
 * @author qcy_java
 * @since 2021-05-27 15:02:34
 */
public interface AttentionMvMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param attentionId 主键
     * @return 实例对象
     */
    AttentionMv queryById(Integer attentionId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AttentionMv> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param attentionMv 实例对象
     * @return 对象列表
     */
    List<AttentionMv> queryAll(AttentionMv attentionMv);

    /**
     * 新增数据
     *
     * @param attentionMv 实例对象
     * @return 影响行数
     */
    int insert(AttentionMv attentionMv);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param attentionMv List<AttentionMv> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("attentionMv") List<AttentionMv> attentionMv);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param attentionMv List<AttentionMv> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("attentionMv") List<AttentionMv> attentionMv);

    /**
     * 修改数据
     *
     * @param attentionMv 实例对象
     * @return 影响行数
     */
    int update(AttentionMv attentionMv);

    /**
     * 通过主键删除数据
     *
     * @param attentionId 主键
     * @return 影响行数
     */
    int deleteById(Integer attentionId);

}

