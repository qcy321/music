package com.mu.mapper;

import com.mu.entities.Song;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Song)表数据库访问层
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:22
 */
@Repository
public interface SongMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param songId 主键
     * @return 实例对象
     */
    @Select("select * from song where song_id = #{songId}")
    @Results(id = "songResult", value = {
            @Result(property = "songId", column = "song_id", id = true),
            @Result(property = "songTitle", column = "song_title"),
            @Result(property = "songUrl", column = "song_url"),
            @Result(property = "album", column = "album_id", one = @One(select = "com.mu.mapper.AlbumMapper.queryById", fetchType = FetchType.EAGER)),
            @Result(property = "lyric", column = "lyric"),
            @Result(property = "spectrum", column = "spectrum"),
    })
    Song queryById(Integer songId);

    /**
     * 通过ID查询单条数据及对应的mv
     *
     * @param songId 主键
     * @return 实例对象
     */
    @Select("select * from song where song_id = #{songId}")
    @Results(id = "songResultMv", value = {
            @Result(property = "songId", column = "song_id", id = true),
            @Result(property = "songTitle", column = "song_title"),
            @Result(property = "songUrl", column = "song_url"),
            @Result(property = "album", column = "album_id", one = @One(select = "com.mu.mapper.AlbumMapper.queryById", fetchType = FetchType.EAGER)),
            @Result(property = "lyric", column = "lyric"),
            @Result(property = "spectrum", column = "spectrum"),
            @Result(property = "mv", column = "song_id", one = @One(select = "com.mu.mapper.MvMapper.queryById", fetchType = FetchType.EAGER))
    })
    Song queryByIdAndMv(Integer songId);

    /**
     * 查询歌手的歌曲，分页
     *
     * @param singerId - 歌手id
     * @param offset   - 起始
     * @param limit    - 条数
     * @return
     */
    @Select("select * from song WHERE album_id in (SELECT album_id from album WHERE singer_id = #{singerId}) limit #{offset},#{limit}")
    @ResultMap("parent")
    List<Song> queryByFkSinger(Integer singerId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 查询专辑的歌曲，分页
     *
     * @param albumId - 歌手id
     * @param offset  - 起始
     * @param limit   - 条数
     * @return
     */
    @Select("select * from song WHERE album_id = #{albumId} limit #{offset},#{limit}")
    List<Song> queryByFkAlbum(Integer albumId, @Param("offset") Integer offset, @Param("limit") Integer limit);


    /**
     * 查询用户关注的歌曲，分页
     *
     * @param userId - 用户id
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    @Select("select * from song WHERE song_id in (SELECT song_id from attention_song WHERE user_id = #{userId}) limit #{offset},#{limit}")
    @ResultMap("parent")
    List<Song> queryByFkUser(Integer userId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 模糊查询歌曲，分页
     *
     * @param name   - 歌曲名
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    @Select("select * from song WHERE song_title like #{name} limit #{offset},#{limit}")
    @ResultMap("parent")
    List<Song> queryByFkName(String name, @Param("offset") Integer offset, @Param("limit") Integer limit);


    /**
     * 通过ID查询单条数据 - 歌曲及歌曲的所有评论
     *
     * @param songId 主键
     * @return 实例对象
     */
    @Select("select * from song where song_id = #{songId}")
    @Results(id = "songResultRelation", value = {
            @Result(property = "songId", column = "song_id", id = true),
            @Result(property = "songTitle", column = "song_title"),
            @Result(property = "songUrl", column = "song_url"),
            //@Result(property = "album", column = "album_id",one = @One(select = "com.mu.mapper.AlbumMapper.queryById",fetchType = FetchType.EAGER)),
            @Result(property = "lyric", column = "lyric"),
            @Result(property = "spectrum", column = "spectrum"),
            @Result(property = "mv", column = "song_id", one = @One(select = "com.mu.mapper.MvMapper.queryByFk", fetchType = FetchType.EAGER)),
            @Result(property = "comments", column = "song_id", many = @Many(select = "com.mu.mapper.CommentMapper.queryByFk", fetchType = FetchType.EAGER))
    })
    Song queryByIdRelation(Integer songId);

    /**
     * 通过ID查询单条数据
     *
     * @param albumId 主键
     * @return 实例对象
     */
    @Select("select * from song where album_id = #{albumId}")
    @ResultMap("songResultRelation")
    Song queryByFk(Integer albumId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select("select * from song limit #{offset},#{limit}")
    @ResultMap(value = "songResultRelation")
    List<Song> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param song 实例对象
     * @return 对象列表
     */
    @Select("select * from song")
    @ResultMap(value = "songResultRelation")
    List<Song> queryAll(Song song);

    /**
     * 随机查询
     *
     * @param typeId id
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select({
            "<script>",
            "select * from song",
            "<where>",
            "<if test='typeId != null'>type_id = #{typeId}</if>",
            "</where>",
            "ORDER BY RAND()",
            "limit #{limit}",
            "</script>"
    })
    @Results(id = "parent", value = {
            @Result(property = "album", column = "album_id", one = @One(select = "com.mu.mapper.AlbumMapper.queryByUrl", fetchType = FetchType.EAGER))
    })
    List<Song> queryRand(Integer typeId, @Param("limit") int limit);

    /**
     * 某个种类部分数据
     *
     * @param typeId - 种类id
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    @Select({
            "<script>",
            "select * from song",
            "<where>",
            "<if test='typeId != null'>type_id = #{typeId}</if>",
            "</where>",
            "limit #{offset},#{limit}",
            "</script>"
    })
    @ResultMap("parent")
    List<Song> queryByFkLimit(Integer typeId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获取某个种类歌曲的总数量
     *
     * @param typeId - songType主键
     * @return
     */
    @Select({
            "<script>",
            "select count(1) as count from song",
            "<where>",
            "<if test='typeId != null'>type_id = #{typeId}</if>",
            "</where>",
            "</script>"
    })
    Integer queryByFkNumber(Integer typeId);

    /**
     * 获取某个歌手歌曲的总数
     *
     * @param singerId - 歌手id
     * @return
     */
    @Select("select count(1) from song WHERE album_id in (SELECT album_id from album WHERE singer_id = #{singerId})")
    Integer countBySinger(Integer singerId);

    /**
     * 获取某个专辑歌曲的总数
     *
     * @param albumId - 歌手id
     * @return
     */
    @Select("select count(1) from song WHERE album_id = #{albumId}")
    Integer countByAlbum(Integer albumId);

    /**
     * 获取用户关注的歌曲的总数
     *
     * @param userId - 用户id
     * @return
     */
    @Select("select count(1) from song WHERE song_id in (SELECT song_id from attention_song WHERE user_id = #{userId})")
    Integer countByUser(Integer userId);

    /**
     * 获取歌曲名为name的总数，模糊查询
     *
     * @param name - 歌曲名称
     * @return
     */
    @Select("select count(1) from song WHERE song_title like #{name}")
    Integer countByName(String name);

    /**
     * 新增数据
     *
     * @param song 实例对象
     * @return 影响行数
     */
    @Insert("insert into song(song_title,song_url,album_id,lyric,spectrum) values(#{songTitle},#{songUrl},#{album.albumId},#{lyric},#{spectrum}) ")
    @Options(useGeneratedKeys = true, keyColumn = "song_id", keyProperty = "songId")
    int insert(Song song);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param song List<Song> 实例对象列表
     * @return 影响行数
     */
    @Insert({
            "<script>",
            "insert into song(song_title,song_url,album_id,lyric,spectrum)",
            "values",
            "<foreach item='so' collection='song' separator=','>",
            "(#{so.songTitle},#{so.songUrl},#{so.album.albumId},#{so.lyric},#{so.spectrum})",
            "</foreach>",
            "</script>"
    })
    @Options(useGeneratedKeys = true, keyColumn = "song_id", keyProperty = "songId")
    int insertBatch(@Param("song") List<Song> song);

    /**
     * 批量新增数据（MyBatis原生foreach方法）,不包括路径
     *
     * @param song List<Song> 实例对象列表
     * @return 影响行数
     */
    @Insert({
            "<script>",
            "insert into song(song_title,album_id,spectrum)",
            "values",
            "<foreach item='so' collection='song' separator=','>",
            "(#{so.songTitle},#{so.album.albumId},#{so.spectrum})",
            "</foreach>",
            "</script>"
    })
    @Options(useGeneratedKeys = true, keyColumn = "song_id", keyProperty = "songId")
    int insertBatchNoUrl(@Param("song") List<Song> song);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param songs List<Song> 实例对象列表
     * @return 影响行数
     */
    @Insert({
            "<script>",
            "insert into song(song_id,song_title,song_url,album_id,lyric,spectrum)",
            "values",
            "<foreach collection='songs' item='song' separator=','>",
            "(#{song.songId},#{song.songTitle},#{song.songUrl}, #{song.album.albumId},#{song.lyric},#{song.spectrum})",
            "</foreach>",
            "on duplicate key update",
            "song_title = values(song_title),song_url = values(song_url),album_id = values(album_id),lyric = values(lyric),spectrum = values(spectrum)",
            "</script>"
    })
    //@Options(useGeneratedKeys = true,keyColumn = "song_id",keyProperty = "songId")
    int insertOrUpdateBatch(@Param("songs") List<Song> songs);

    /**
     * 修改数据
     *
     * @param song 实例对象
     * @return 影响行数
     */
    @Update({"<script>",
            "update song ",
            "<set>",
            "<if test='songTitle != null'>song_title = #{songTitle},</if>",
            "<if test='songUrl != null'>song_url = #{songUrl},</if>",
            "<if test='album!=null and album.albumId != null'>album_id = #{album.albumId},</if>",
            "<if test='lyric != null'>lyric = #{lyric},</if>",
            "<if test='spectrum != null'>spectrum = #{spectrum}</if>",
            "</set>",
            "where song_id = #{songId}",
            "</script>"})
    int update(Song song);

    /**
     * 修改数据
     *
     * @param songs 实例对象
     * @return 影响行数
     */
    @Update({"<script>",
            "<foreach item='so' collection='songs' separator=';'>",
            "update song ",
            "<set>",
            "<if test='so.songTitle != null'>song_title = #{so.songTitle},</if>",
            "<if test='so.songUrl != null'>song_url = #{so.songUrl},</if>",
            "<if test='so.album!=null and so.album.albumId != null'>album_id = #{so.album.albumId},</if>",
            "<if test='so.lyric != null'>lyric = #{so.lyric},</if>",
            "<if test='so.spectrum != null'>spectrum = #{so.spectrum},</if>",
            "</set>",
            "where song_id = #{so.songId}",
            "</foreach>",
            "</script>"})
    boolean updateBatch(List<Song> songs);

    /**
     * 通过主键删除数据
     *
     * @param songId 主键
     * @return 影响行数
     */
    @Delete("delete from song where song_id = #{songId}")
    int deleteById(Integer songId);

}

