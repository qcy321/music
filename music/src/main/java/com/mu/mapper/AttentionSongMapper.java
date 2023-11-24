package com.mu.mapper;

import com.mu.entities.AttentionSong;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (AttentionSong)表数据库访问层
 *
 * @author qcy_java
 * @since 2021-05-27 15:03:14
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
     * 判断是否关注
     * @param attentionSong - 对象
     * @return
     */
    @Select("select count(1) from attention_song where user_id =#{userId} and song_id = #{songId}")
    Integer isAttention(AttentionSong attentionSong);

    /**
     * 统计用户关注数量
     *
     * @param userId 外键
     * @return 实例对象
     */
    @Select("select count(1) from attention_song where user_id = #{userId}")
    Integer countByUserId(Integer userId);

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
    @Insert("insert into attention_song(user_id,song_id) values(#{userId},#{songId})")
    @Options(useGeneratedKeys = true,keyProperty = "attentionId",keyColumn = "attentions_id")
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


    /**
     * 通过联合外键删除
     *
     * @param attentionSong 对象
     * @return 是否成功
     */
    @Delete("delete from attention_song where user_id = #{userId} and song_id = #{songId}")
    Integer deleteByUserAndAlbum(AttentionSong attentionSong);
}

