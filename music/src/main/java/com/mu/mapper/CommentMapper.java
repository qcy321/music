package com.mu.mapper;

import com.mu.entities.Comment;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * (Comment)表数据库访问层
 *
 * @author qcy_java
 * @since 2021-04-27 19:47:36
 */
public interface CommentMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    @Select("select * from comment where comment_id = #{commentId}")
    @Results(id = "commentResult", value = {
            @Result(property = "user",column = "id",one = @One(select = "com.mu.mapper.UserMapper.queryByPart",fetchType = FetchType.EAGER)),
            @Result(property = "song", column = "song_id", one = @One(select = "com.mu.mapper.SongMapper.queryById",fetchType = FetchType.EAGER)),
    })
    Comment queryById(Integer commentId);

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    @Select("select * from comment where comment_id = #{commentId}")
    @Results(id = "commentResultRelation", value = {
            @Result(property = "user",column = "id",one = @One(select = "com.mu.mapper.UserMapper.queryByPart",fetchType = FetchType.EAGER)),
            @Result(property = "replies", column = "comment_id",many = @Many(select = "com.mu.mapper.ReplyMapper.queryByFk",fetchType = FetchType.EAGER)),
    })
    Comment queryByIdRelation(Integer commentId);

    /**
     * 通过ID查询单条数据
     *
     * @param songId 主键
     * @return 实例对象
     */
    @Select("select * from comment where song_id = #{songId}")
    @ResultMap("commentResultRelation")
    Comment queryByFk(Integer songId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select("select * from comment where limit #{offset},#{limit}")
    @ResultMap("commentResult")
    List<Comment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param comment 实例对象
     * @return 对象列表
     */
    @Select("select * from comment")
    List<Comment> queryAll(Comment comment);

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 影响行数
     */
    @Insert(
            "insert into comment(id,song_id,content,content_time,number) "+
            "values(#{user.id},#{song.songId},#{content},#{contentTime},#{number})"
    )
    @Options(useGeneratedKeys = true,keyColumn = "comment_id",keyProperty = "commentId")
    int insert(Comment comment);

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 影响行数
     */
    @Delete("delete * from comment where comment_id =#{commentId}")
    int deleteById(Integer commentId);

}

