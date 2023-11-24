package com.mu.mapper;

import com.mu.entities.MvReply;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * (MvReply)表数据库访问层
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:21
 */
public interface MvReplyMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param replyId 主键
     * @return 实例对象
     */
    @Select("select * from mv_reply where reply_id = #{replyId}")
    @Results(id = "mvReplyResult", value = {
            @Result(property = "mvComment",column = "comment_id",one = @One(select = "com.mu.mapper.MvCommentMapper.queryById",fetchType = FetchType.EAGER)),
            @Result(property = "user", column = "user_id", one = @One(select = "com.mu.mapper.UserMapper.queryByPart",fetchType = FetchType.EAGER)),
    })
    MvReply queryById(Integer replyId);

    /**
     * 通过ID查询单条数据
     *
     * @param replyId 主键
     * @return 实例对象
     */
    @Select("select * from mv_reply where reply_id = #{replyId}")
    @Results(id = "mvReplyResultRelation", value = {
            @Result(property = "user", column = "user_id", one = @One(select = "com.mu.mapper.UserMapper.queryByPart",fetchType = FetchType.EAGER)),
    })
    MvReply queryByIdRelation(Integer replyId);

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    @Select("select * from mv_reply where comment_id = #{commentId}")
    @ResultMap("mvReplyResultRelation")
    MvReply queryByFk(Integer commentId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select("select * from mv_reply limit #{offset},#{limit}")
    @ResultMap("mvReplyResultRelation")
    List<MvReply> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mvReply 实例对象
     * @return 对象列表
     */
    @Select("select * from mv_reply")
    @ResultMap("mvReplyResultRelation")
    List<MvReply> queryAll(MvReply mvReply);

    /**
     * 新增数据
     *
     * @param mvReply 实例对象
     * @return 影响行数
     */
    @Insert("insert into mv_reply(comment_id,user_id,content,content_time,number) " +
            "values(#{mvComment.commentId},#{user.id},#{content},#{contentTime},#{number})")
    @Options(useGeneratedKeys = true,keyColumn = "reply_id",keyProperty = "replyId")
    int insert(MvReply mvReply);


    /**
     * 通过主键删除数据
     *
     * @param replyId 主键
     * @return 影响行数
     */
    @Delete("delete from mv_reply where reply_id = #{replyId}")
    int deleteById(Integer replyId);

}

