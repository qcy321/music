package com.mu.mapper;

import com.mu.entities.Album;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * (Album)表数据库访问层
 *
 * @author qcy_java
 * @since 2021-04-27 19:36:14
 */
@Repository
public interface AlbumMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param albumId 主键
     * @return 实例对象
     */
    @Select("select * from album where album_id = #{albumId}")
    @Results(id = "albumResult", value = {
            @Result(property = "albumId", column = "album_id", id = true),
            @Result(property = "singer", column = "singer_id", one = @One(select = "com.mu.mapper.SingerMapper.queryByName", fetchType = FetchType.EAGER)),
            //@Result(property = "singer.singerId", column = "singer_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "timeOfIssue", column = "time_of_issue"),
            @Result(property = "company", column = "company"),
            @Result(property = "introduce", column = "introduce"),
            @Result(property = "img", column = "img"),
            @Result(property = "albumType", column = "type_id", one = @One(select = "com.mu.mapper.AlbumTypeMapper.queryById", fetchType = FetchType.EAGER))
    })
    Album queryById(Integer albumId);

    /**
     * 只获取封面
     *
     * @param albumId - 专辑id
     * @return
     */
    @Select("select * from album where album_id = #{albumId}")
    @Results(id = "parentName", value = {
            @Result(property = "singer", column = "singer_id", one = @One(select = "com.mu.mapper.SingerMapper.queryByName", fetchType = FetchType.EAGER)),
    })
    Album queryByUrl(Integer albumId);

    /**
     * 统计专辑歌曲数量
     *
     * @param albumId - 专辑id
     * @return
     */
    @Select("select count(1) from song where album_id = #{albumId}")
    Integer countSongByAlbum(Integer albumId);

    /**
     * 查询歌手的专辑，分页
     *
     * @param singerId - 歌手id
     * @param offset   - 起始
     * @param limit    - 条数
     * @return
     */
    @Select("select album_id,`name`,img,time_of_issue from album WHERE singer_id = #{singerId} limit #{offset},#{limit}")
    @Results(id = "album", value = {
            @Result(property = "albumId", column = "album_id"),
            @Result(property = "number", column = "album_id", one = @One(select = "com.mu.mapper.AlbumMapper.countSongByAlbum", fetchType = FetchType.EAGER))
    })
    List<Album> queryByFkSinger(Integer singerId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 查询用户关注的专辑，分页
     *
     * @param userId - 歌手id
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    @Select("select album_id,singer_id,`name`,img,time_of_issue from album WHERE album_id in (select album_id from attention_album where user_id = #{userId}) limit #{offset},#{limit}")
    @Results(id = "fk", value = {
            @Result(property = "albumId", column = "album_id"),
            @Result(property = "singer", column = "singer_id", one = @One(select = "com.mu.mapper.SingerMapper.queryByName", fetchType = FetchType.EAGER)),
            @Result(property = "number", column = "album_id", one = @One(select = "com.mu.mapper.AlbumMapper.countSongByAlbum", fetchType = FetchType.EAGER))
    })
    List<Album> queryByFkUser(Integer userId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 通过专辑名称模糊查询数据，分页
     *
     * @param name   - 专辑名称
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    @Select("select album_id,singer_id,`name`,img,time_of_issue from album WHERE `name` like #{name} limit #{offset},#{limit}")
    @ResultMap("fk")
    List<Album> queryByFkName(String name, @Param("offset") Integer offset, @Param("limit") Integer limit);

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
            "select * from album",
            "<where>",
            "<if test='typeId != null'>type_id = #{typeId}</if>",
            "</where>",
            "limit #{offset},#{limit}",
            "</script>"
    })
    List<Album> queryByFkLimit(Integer typeId, @Param("offset") Integer offset, @Param("limit") Integer limit);


    /**
     * 随机查询专辑
     *
     * @param typeId id
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select({
            "<script>",
            "select `name`,img,singer_id from album",
            "<where>",
            "<if test='typeId != null'>type_id = #{typeId}</if>",
            "</where>",
            "ORDER BY RAND()",
            "limit #{limit}",
            "</script>"
    })
    @ResultMap("parentName")
    List<Album> queryRand(Integer typeId, @Param("limit") int limit);


    /**
     * 通过ID查询单条数据,关联查询
     *
     * @param albumId 主键
     * @return 实例对象
     */
    @Select("select * from album where album_id = #{albumId}")
    @Results(id = "albumResultRelation", value = {
            @Result(property = "albumId", column = "album_id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "timeOfIssue", column = "time_of_issue"),
            @Result(property = "company", column = "company"),
            @Result(property = "introduce", column = "introduce"),
            @Result(property = "img", column = "img"),
            @Result(property = "songs", column = "album_id", many = @Many(select = "com.mu.mapper.SongMapper.queryByFk", fetchType = FetchType.EAGER)),
    })
    Album queryByIdRelation(Integer albumId);

    /**
     * 通过ID查询单条数据
     *
     * @param singerId 主键
     * @return 实例对象
     */
    @Select("select * from album where singer_id = #{singerId}")
    @ResultMap("albumResultRelation")
    Album queryByFk(Integer singerId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select("select * from album limit #{offset},#{limit}")
    @ResultMap("albumResultRelation")
    List<Album> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param album 实例对象
     * @return 对象列表
     */
    @Select("select * from album")
    @ResultMap("albumResultRelation")
    List<Album> queryAll(Album album);

    /**
     * 获取某个歌手专辑的总数
     *
     * @param singerId - 歌手id
     * @return
     */
    @Select("select count(1) from album WHERE singer_id = #{singerId}")
    Integer countBySinger(Integer singerId);

    /**
     * 获取某个歌手专辑的总数
     *
     * @param userId - 歌手id
     * @return
     */
    @Select("select count(1) from album WHERE album_id in (select album_id from attention_album where user_id = #{userId})")
    Integer countByUser(Integer userId);

    /**
     * 统计该名字下专辑数量
     *
     * @param name - 歌手id
     * @return
     */
    @Select("select count(1) from album WHERE `name` like #{name} ")
    Integer countByName(String name);

    /**
     * 新增数据
     *
     * @param album 实例对象
     * @return 影响行数
     */
    @Insert({"insert into album(singer_id,`name`,time_of_issue,company,introduce,img)",
            "values(#{singer.singerId},#{name},#{timeOfIssue},#{company},#{introduce},#{img})"})
    @Options(useGeneratedKeys = true, keyColumn = "album_id", keyProperty = "albumId")
    int insert(Album album);

    /**
     * 批量新增数据（MyBatis原生foreach方法）,不插入路径
     *
     * @param albums List<Album> 实例对象列表
     * @return 影响行数
     */
    @Insert({
            "<script>",
            "insert into album(singer_id,`name`,time_of_issue,company,introduce)",
            "values",
            "<foreach item='album' collection='albums' separator=','>",
            "(#{album.singer.singerId},#{album.name},#{album.timeOfIssue},#{album.company},#{album.introduce})",
            "</foreach>",
            "</script>"
    })
    @Options(useGeneratedKeys = true, keyColumn = "album_id", keyProperty = "albumId")
    int insertBatchNoUrl(@Param("albums") List<Album> albums);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param albums List<Album> 实例对象列表
     * @return 影响行数
     */
    @Insert({
            "<script>",
            "insert into album(singer_id,`name`,time_of_issue,company,introduce,img)",
            "values",
            "<foreach item='album' collection='albums' separator=','>",
            "(#{album.singer.singerId},#{album.name},#{album.timeOfIssue},#{album.company},#{album.introduce},#{album.img})",
            "</foreach>",
            "</script>"
    })
    @Options(useGeneratedKeys = true, keyColumn = "album_id", keyProperty = "albumId")
    int insertBatch(@Param("albums") List<Album> albums);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param albums List<Album> 实例对象列表
     * @return 影响行数
     */
    @Insert({
            "<script>",
            "insert into album(singer_id,`name`,time_of_issue,company,introduce,img)",
            "values",
            "<foreach item='album' collection='albums' separator=','>",
            "(#{album.singer.singerId},#{album.name},#{album.timeOfIssue},#{album.company},#{album.introduce},#{album.img})",
            "</foreach>",
            "on duplicate key update",
            "singer_id = values(singer_id),`name` = values(`name`),time_of_issue = values(time_of_issue),company = values(company),introduce = values(introduce),img = #{img}",
            "</script>"
    })
    int insertOrUpdateBatch(@Param("albums") List<Album> albums);

    /**
     * 修改数据
     *
     * @param album 实例对象
     * @return 影响行数
     */
    @Update({"<script>",
            "update album",
            "<set>",
            "<if test='singer != null and singer.singerId != null'>singer_id = #{singer.singerId},</if>",
            "<if test='name != null'>`name` = #{name},</if>",
            "<if test='timeOfIssue != null'>time_of_issue = #{timeOfIssue},</if>",
            "<if test='company != null'>company = #{company},</if>",
            "<if test='introduce != null'>introduce = #{introduce},</if>",
            "<if test='img != null'>img = #{img},</if>",
            "</set>",
            "where album_id = #{albumId}",
            "</script>"})
    int update(Album album);

    /**
     * 修改数据
     *
     * @param albums 实例对象
     * @return 影响行数
     */
    @Update({"<script>",
            "<foreach item='album' collection='albums' separator=';'>",
            "update album",
            "<set>",
            "<if test='album.singer != null and album.singer.singerId != null'>singer_id = #{album.singer.singerId},</if>",
            "<if test='album.name != null'>`name` = #{album.name},</if>",
            "<if test='album.timeOfIssue != null'>time_of_issue = #{album.timeOfIssue},</if>",
            "<if test='album.company != null'>company = #{album.company},</if>",
            "<if test='album.introduce != null'>introduce = #{album.introduce},</if>",
            "<if test='album.img != null'>img = #{album.img},</if>",
            "</set>",
            "where album_id = #{album.albumId}",
            "</foreach>",
            "</script>"})
    boolean updateBatch(List<Album> albums);

    /**
     * 通过主键删除数据
     *
     * @param albumId 主键
     * @return 影响行数
     */
    @Delete("delete from album where album_id = #{albumId}")
    int deleteById(Integer albumId);

}

