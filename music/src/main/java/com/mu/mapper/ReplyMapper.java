package com.mu.mapper;

import com.mu.entities.Reply;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * (Reply)表数据库访问层
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:21
 */
public interface ReplyMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param replyId 主键
     * @return 实例对象
     */
    @Select("select * from reply where reply_id = #{replyId}")
    @Results(id = "replyResult", value = {
            @Result(property = "comment",column = "comment_id",one = @One(select = "com.mu.mapper.CommentMapper.queryById",fetchType = FetchType.EAGER)),
            @Result(property = "user", column = "user_id", one = @One(select = "com.mu.mapper.UserMapper.queryByPart",fetchType = FetchType.EAGER)),
    })
    Reply queryById(Integer replyId);

    /**
     * 通过ID查询单条数据
     *
     * @param replyId 主键
     * @return 实例对象
     */
    @Select("select * from reply where reply_id = #{replyId}")
    @Results(id = "replyResultRelation", value = {
            @Result(property = "user", column = "user_id", one = @One(select = "com.mu.mapper.UserMapper.queryByPart",fetchType = FetchType.EAGER)),
    })
    Reply queryByIdRelation(Integer replyId);

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    @Select("select * from reply where comment_id = #{commentId}")
    @ResultMap("replyResultRelation")
    Reply queryByFk(Integer commentId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select("select * from reply limit #{offset},#{limit}")
    @ResultMap("replyResult")
    List<Reply> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param reply 实例对象
     * @return 对象列表
     */
    @Select("select * from reply")
    @ResultMap("replyResult")
    List<Reply> queryAll(Reply reply);

    /**
     * 新增数据
     *
     * @param reply 实例对象
     * @return 影响行数
     */
    @Insert("insert into reply(comment_id,user_id,content,content_time,number) " +
            "values(#{comment.commentId},#{user.userId},#{content},#{contentTime},#{number})")
    @Options(useGeneratedKeys = true,keyColumn = "reply_id",keyProperty = "replyId")
    int insert(Reply reply);

    /**
     * 通过主键删除数据
     *
     * @param replyId 主键
     * @return 影响行数
     */
    @Delete("delete from reply wherer reply_id = #{replyId}")
    int deleteById(Integer replyId);

}

