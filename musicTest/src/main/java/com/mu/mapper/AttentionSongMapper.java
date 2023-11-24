package com.mu.mapper;

import com.mu.pojo.AttentionSong;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (AttentionSong)表数据库访问层
 *
 * @author qcy_java
 * @since 2021-05-27 15:02:35
 */
public interface AttentionSongMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param attentionId 主键
     * @return 实例对象
     */
    AttentionSong queryById(Integer attentionId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AttentionSong> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param attentionSong 实例对象
     * @return 对象列表
     */
    List<AttentionSong> queryAll(AttentionSong attentionSong);

    /**
     * 新增数据
     *
     * @param attentionSong 实例对象
     * @return 影响行数
     */
    int insert(AttentionSong attentionSong);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param attentionSong List<AttentionSong> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("attentionSong") List<AttentionSong> attentionSong);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param attentionSong List<AttentionSong> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("attentionSong") List<AttentionSong> attentionSong);

    /**
     * 修改数据
     *
     * @param attentionSong 实例对象
     * @return 影响行数
     */
    int update(AttentionSong attentionSong);

    /**
     * 通过主键删除数据
     *
     * @param attentionId 主键
     * @return 影响行数
     */
    int deleteById(Integer attentionId);

}

