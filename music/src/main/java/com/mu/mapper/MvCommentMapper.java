package com.mu.mapper;

import com.mu.entities.MvComment;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * (MvComment)表数据库访问层
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:20
 */
public interface MvCommentMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    @Select("select * from mv_comment where comment_id = #{commentId}")
    @Results(id = "mvCommentResult", value = {
            @Result(property = "user",column = "id",one = @One(select = "com.mu.mapper.UserMapper.queryByPart",fetchType = FetchType.EAGER)),
            @Result(property = "mv", column = "mv_id", one = @One(select = "com.mu.mapper.MvMapper.queryById",fetchType = FetchType.EAGER)),
    })
    MvComment queryById(Integer commentId);

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    @Select("select * from mv_comment where comment_id = #{commentId}")
    @Results(id = "mvCommentResultRelation", value = {
            @Result(property = "user",column = "id",one = @One(select = "com.mu.mapper.UserMapper.queryByPart",fetchType = FetchType.EAGER)),
            @Result(property = "mvReplies", column = "comment_id",many = @Many(select = "com.mu.mapper.MvReplyMapper.queryByFk",fetchType = FetchType.EAGER)),
    })
    MvComment queryByIdRelation(Integer commentId);

    /**
     * 通过ID查询单条数据
     *
     * @param MvId 主键
     * @return 实例对象
     */
    @Select("select * from mv_comment where mv_id = #{MvId}")
    @ResultMap("mvCommentResultRelation")
    MvComment queryByFk(Integer MvId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select("select * from mv_comment limit #{offset},#{limit}")
    @ResultMap("mvCommentResultRelation")
    List<MvComment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mvComment 实例对象
     * @return 对象列表
     */
    @Select("select * from mv_comment")
    @ResultMap("mvCommentResultRelation")
    List<MvComment> queryAll(MvComment mvComment);

    /**
     * 新增数据
     *
     * @param mvComment 实例对象
     * @return 影响行数
     */
    @Insert("insert into mv_comment(id,mv_id,content,content_time,number) " +
            "values(#{user.id},#{mv.mvId},#{content},#{contentTime},#{number})")
    @Options(useGeneratedKeys = true,keyColumn = "comment_id",keyProperty = "commentId")
    int insert(MvComment mvComment);

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 影响行数
     */
    @Delete("delete from mv_comment where comment_id = #{commentId}")
    int deleteById(Integer commentId);

}

