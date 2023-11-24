package com.mu.mapper;

import com.mu.entities.Mv;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Mv)表数据库访问层
 *
 * @author qcy_java
 * @since 2021-04-27 19:47:58
 */
@Repository
public interface MvMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param mvId 主键
     * @return 实例对象
     */
    @Select("select * from mv where mv_id = #{mvId}")
    @Results(id = "mvResult", value = {
            @Result(property = "song", column = "song_id",one = @One(select = "com.mu.mapper.SongMapper.queryById",fetchType = FetchType.EAGER)),
    })
    Mv queryById(Integer mvId);


    /**
     * 通过ID查询单条数据
     *
     * @param mvId 主键
     * @return 实例对象
     */
    @Select("select * from mv where mv_id = #{mvId}")
    @Results(id = "mvResultRelation", value = {
            @Result(property = "mvComments", column = "mv_id",many = @Many(select = "com.mu.mapper.MvCommentMapper.queryByFk",fetchType = FetchType.EAGER)),
    })
    Mv queryByIdRelation(Integer mvId);

    /**
     * 通过ID查询单条数据
     *
     * @param song_id 主键
     * @return 实例对象
     */
    @Select("select * from mv where song_id = #{song_id}")
    @ResultMap("mvResultRelation")
    Mv queryByFk(Integer song_id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select("select * from mv limit #{offset},#{limit}")
    @ResultMap("mvResultRelation")
    List<Mv> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 随机查询
     * @param typeId id
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select({
            "<script>",
            "select * from Mv",
            "<where>",
            "<if test='typeId != null'>type_id = #{typeId}</if>",
            "</where>",
            "ORDER BY RAND()",
            "limit #{limit}",
            "</script>"
    })
    List<Mv> queryRand(Integer typeId, @Param("limit") int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    @Select("select * from mv")
    @ResultMap("mvResultRelation")
    List<Mv> queryAll();

    /**
     * 新增数据
     *
     * @param mv 实例对象
     * @return 影响行数
     */
    @Insert("insert into mv(mv_title,song_id,play_volume,cover,video,time) " +
            "values(#{mvTitle},#{song.songId},#{playVolume},#{cover},#{video},#{time})")
    @Options(useGeneratedKeys = true,keyColumn = "mv_id",keyProperty = "mvId")
    int insert(Mv mv);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param mvs List<Mv> 实例对象列表
     * @return 影响行数
     */
    @Insert({
            "<script>",
            "insert into mv(mv_title,song_id,play_volume,cover,video,time)",
            "values",
            "<foreach item='mv' collection='mvs' separator=','>",
            "(#{mv.mvTitle},#{mv.song.songId},#{mv.playVolume},#{mv.cover},#{mv.video},#{mv.time})",
            "</foreach>",
            "</script>"
    })
    @Options(useGeneratedKeys = true,keyColumn = "mv_id",keyProperty = "mvId")
    int insertBatch(@Param("mvs") List<Mv> mvs);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param mvs List<Mv> 实例对象列表
     * @return 影响行数
     */
    @Insert({
            "<script>",
            "insert into mv(mv_id,mv_title,song_id,play_volume,cover,video,time)",
            "values",
            "<foreach item='mv' collection='mvs' separator=','>",
            "(#{mv.mvId},#{mv.mvTitle},#{mv.song.songId},#{mv.playVolume},#{mv.cover},#{mv.video},#{mv.time})",
            "</foreach>",
            "on duplicate key update",
            "mv_id = values(mv_id),mv_title = values(mv_title),song_id = values(song_id),play_volume = values(play_volume),cover = values(cover),video = values(video),time = values(time)",
            "</script>"
    })
    int insertOrUpdateBatch(@Param("mvs") List<Mv> mvs);

    /**
     * 修改数据
     *
     * @param mv 实例对象
     * @return 影响行数
     */
    @Update({"<script>",
            "update mv ",
            "<set>",
            "<if test='mvTitle != null'>mv_title = #{mvTitle},</if>",
            "<if test='song != null and song.songId != null'>song_id = #{song.songId},</if>",
            "<if test='playVolume != null'>play_volume = #{playVolume},</if>",
            "<if test='cover != null'>cover = #{cover},</if>",
            "<if test='video != null'>video = #{video},</if>",
            "<if test='time != null'>time = #{time},</if>",
            "</set>",
            "where song_id = #{songId}",
            "</script>"})
    int update(Mv mv);

    /**
     * 通过主键删除数据
     *
     * @param mvId 主键
     * @return 影响行数
     */
    @Delete("delete from mv where mv_id = #{mvId}")
    int deleteById(Integer mvId);

}

