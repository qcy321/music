package com.mu.mapper;

import com.mu.entities.AttentionAlbum;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * (AttentionAlbum)表数据库访问层
 *
 * @author qcy_java
 * @since 2021-05-27 14:59:53
 */
public interface AttentionAlbumMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param attentionId 主键
     * @return 实例对象
     */
    AttentionAlbum queryById(Integer attentionId);

    /**
     * 通过userId，和singerId查询数据是否存在，用于判断用户是否关注歌手
     *
     * @param attentionAlbum 实例
     * @return 实例对象
     */
    @Select("select count(1) from attention_album where user_id =#{userId} and album_id = #{albumId}")
    Integer queryByUserAndAlbum(AttentionAlbum attentionAlbum);

    /**
     * 通过userId计算总数
     *
     * @param userId 外键
     * @return 实例对象
     */
    @Select("select count(1) from attention_album where user_id = #{userId}")
    Integer countByUserId(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AttentionAlbum> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param attentionAlbum 实例对象
     * @return 对象列表
     */
    List<AttentionAlbum> queryAll(AttentionAlbum attentionAlbum);

    /**
     * 新增数据
     *
     * @param attentionAlbum 实例对象
     * @return 影响行数
     */
    @Insert("insert into attention_album(user_id,album_id) values(#{userId},#{albumId})")
    @Options(useGeneratedKeys = true,keyProperty = "attentionId",keyColumn = "attention_id")
    int insert(AttentionAlbum attentionAlbum);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param attentionAlbum List<AttentionAlbum> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("attentionAlbum") List<AttentionAlbum> attentionAlbum);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param attentionAlbum List<AttentionAlbum> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("attentionAlbum") List<AttentionAlbum> attentionAlbum);

    /**
     * 修改数据
     *
     * @param attentionAlbum 实例对象
     * @return 影响行数
     */
    int update(AttentionAlbum attentionAlbum);

    /**
     * 通过主键删除数据
     *
     * @param attentionId 主键
     * @return 影响行数
     */
    int deleteById(Integer attentionId);

    /**
     * 通过联合主键删除
     * @param attentionAlbum - 实例
     * @return 影响行数
     */
    @Delete("delete from attention_album where user_id = #{userId} and album_id = #{albumId}")
    int deleteByUserAndAlbum(AttentionAlbum attentionAlbum);

}

