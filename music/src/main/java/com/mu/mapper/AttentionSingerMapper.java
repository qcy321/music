package com.mu.mapper;

import com.mu.entities.AttentionSinger;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (AttentionSinger)表数据库访问层
 *
 * @author qcy_java
 * @since 2021-05-27 15:03:03
 */
public interface AttentionSingerMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param attentionId 主键
     * @return 实例对象
     */
    AttentionSinger queryById(Integer attentionId);

    /**
     * 通过userId，和singerId查询数据是否存在，用于判断用户是否关注歌手
     *
     * @param attentionSinger 实例
     * @return 实例对象
     */
    @Select("select count(1) from attention_singer where user_id =#{userId} and singer_id = #{singerId}")
    Integer queryByUserAndSinger(AttentionSinger attentionSinger);

    /**
     * 通过userId计算总数
     *
     * @param userId 外键
     * @return 实例对象
     */
    @Select("select count(1) from attention_singer where user_id = #{userId}")
    Integer countByUserId(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AttentionSinger> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param attentionSinger 实例对象
     * @return 对象列表
     */
    List<AttentionSinger> queryAll(AttentionSinger attentionSinger);

    /**
     * 新增数据
     *
     * @param attentionSinger 实例对象
     * @return 影响行数
     */
    @Insert("insert into attention_singer(user_id,singer_id) values(#{userId},#{singerId})")
    @Options(useGeneratedKeys = true,keyProperty = "attentionId",keyColumn = "attention_id")
    int insert(AttentionSinger attentionSinger);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param attentionSinger List<AttentionSinger> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("attentionSinger") List<AttentionSinger> attentionSinger);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param attentionSinger List<AttentionSinger> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("attentionSinger") List<AttentionSinger> attentionSinger);

    /**
     * 修改数据
     *
     * @param attentionSinger 实例对象
     * @return 影响行数
     */
    int update(AttentionSinger attentionSinger);

    /**
     * 通过主键删除数据
     *
     * @param attentionId 主键
     * @return 影响行数
     */
    @Delete("delete from attention_singer where attention_id = #{attentionId}")
    int deleteById(Integer attentionId);

    /**
     * 通过联合主键删除
     *
     * @return 影响行数
     */
    @Delete("delete from attention_singer where user_id = #{userId} and singer_id = #{singerId}")
    int deleteByUserAndSinger(AttentionSinger attentionSinger);

}

