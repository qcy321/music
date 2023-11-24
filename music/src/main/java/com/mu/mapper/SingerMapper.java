package com.mu.mapper;

import com.mu.entities.Singer;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Singer)表数据库访问层
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:22
 */
@Repository
public interface SingerMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param singerId 主键
     * @return 实例对象
     */
    @Select("select * from singer where singer_id = #{singerId}")
    @Results(id = "singerResult", value = {
            @Result(property = "singerId", column = "singer_id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "foreignName", column = "foreign_name"),
            @Result(property = "alias", column = "alias"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "nationality", column = "nationality"),
            @Result(property = "birthplace", column = "birthplace"),
            @Result(property = "dateOfBirth", column = "date_of_birth"),
            @Result(property = "occupation", column = "occupation"),
            @Result(property = "representative", column = "representative"),
            @Result(property = "achievement", column = "achievement"),
            @Result(property = "synopsis", column = "synopsis"),
            @Result(property = "headPortrait", column = "head_portrait"),
            @Result(property = "singerType", column = "type_id", one = @One(select = "com.mu.mapper.SingerTypeMapper.queryById", fetchType = FetchType.EAGER)),
            @Result(property = "attention", column = "attention"),
    })
    Singer queryById(Integer singerId);

    /**
     * 计算歌手的关注数
     *
     * @param singerId - 歌手id
     * @return
     */
    @Select("select count(1) from attention_singer where singer_id = #{singerId}")
    Integer attentionCount(Integer singerId);

    /**
     * 查询用户关注的歌手，分页
     *
     * @param userId - 歌手id
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    @Select("select singer_id,`name`,head_portrait from singer WHERE singer_id in (select singer_id from attention_singer where user_id = #{userId}) limit #{offset},#{limit}")
    @Results({
            @Result(property = "singerId", column = "singer_id"),
            @Result(property = "attention", column = "singer_id", one = @One(select = "com.mu.mapper.SingerMapper.attentionCount", fetchType = FetchType.EAGER))
    })
    List<Singer> queryByFkUser(Integer userId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 模糊查询歌手数量
     *
     * @param name   - 歌手名
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    @Select("select singer_id,`name`,head_portrait from singer WHERE `name` like #{name} limit #{offset},#{limit}")
    @Results({
            @Result(property = "singerId", column = "singer_id"),
            @Result(property = "attention", column = "singer_id", one = @One(select = "com.mu.mapper.SingerMapper.attentionCount", fetchType = FetchType.EAGER))
    })
    List<Singer> queryByFkName(String name, @Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 通过ID查询单条数据
     *
     * @param singerId 主键
     * @return 实例对象
     */
    @Select("select * from singer where singer_id = #{singerId}")
    @Results(id = "singerResultRelation", value = {
            @Result(property = "singerId", column = "singer_id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "foreignName", column = "foreign_name"),
            @Result(property = "alias", column = "alias"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "nationality", column = "nationality"),
            @Result(property = "birthplace", column = "birthplace"),
            @Result(property = "dateOfBirth", column = "date_of_birth"),
            @Result(property = "occupation", column = "occupation"),
            @Result(property = "representative", column = "representative"),
            @Result(property = "achievement", column = "achievement"),
            @Result(property = "synopsis", column = "synopsis"),
            @Result(property = "headPortrait", column = "head_portrait"),
            @Result(property = "attention", column = "attention"),
            @Result(property = "albums", column = "singer_id", many = @Many(select = "com.mu.mapper.AlbumMapper.queryByFk", fetchType = FetchType.EAGER)),
    })
    Singer queryByIdRelation(Integer singerId);

    /**
     * 外键查询
     *
     * @param typeId - singerType主键
     * @return
     */
    @Select("select * from singer where type_id = #{typeId}")
    @ResultMap("singerResultRelation")
    Singer queryByFk(Integer typeId);

    /**
     * 获取某个种类部分数据
     *
     * @param typeId - 种类id
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    @Select("select * from singer where type_id = #{typeId} limit #{offset},#{limit}")
    List<Singer> queryByFkType(Integer typeId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 查询当前-依据条件查询
     *
     * @param singer - 携带的条件，可以根据singerId,name,typeId查询
     * @param offset
     * @param limit
     * @return
     */
    @Select({
            "<script>",
            "select * from singer",
            "<where>",
            "<if test='singer !=null and singer.singerId != null'>singer_id = #{singer.singerId}</if>",
            "<if test='singer !=null and singer.name != null'>and `name` = #{singer.name}</if>",
            "<if test='singer !=null and singer.singerType != null and singer.singerType.typeId'>and type_id = #{singer.singerType.typeId}</if>",
            "</where>",
            "<if test='offset != null and limit != null'>limit #{offset},#{limit}</if>",
            "</script>"
    })
    List<Singer> queryAllCurrent(Singer singer, @Param("offset") Integer offset, @Param("limit") Integer limit);


    /**
     * 获取某个歌手的总数
     *
     * @param userId - 歌手id
     * @return
     */
    @Select("select count(1) from singer WHERE singer_id in (select singer_id from attention_singer where user_id = #{userId})")
    Integer countByUser(Integer userId);

    /**
     * 获取该名字下歌手的总数
     *
     * @param name - 歌手名
     * @return
     */
    @Select("select count(1) from singer WHERE `name` like #{name}")
    Integer countByName(String name);


    /**
     * 随机查村多条数据
     *
     * @param typeId - 携带的条件，可以根据singerId,name,typeId查询
     * @param limit
     * @return
     */
    @Select({
            "<script>",
            "select * from singer",
            "<where>",
            "<if test='typeId != null'>type_id = #{typeId}</if>",
            "</where>",
            "ORDER BY RAND()",
            "limit #{limit}",
            "</script>"
    })
    List<Singer> queryRand(Integer typeId, @Param("limit") Integer limit);

    /**
     * 查询名字
     *
     * @param singerId - singerType主键
     * @return
     */
    @Select("select singer_id,`name` from singer where singer_id = #{singerId}")
    Singer queryByName(Integer singerId);

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
            "select * from singer",
            "<where>",
            "<if test='typeId != null'>type_id = #{typeId}</if>",
            "</where>",
            "limit #{offset},#{limit}",
            "</script>"
    })
    //@Select("select * from singer where type_id = #{typeId} limit #{offset},#{limit}")
    List<Singer> queryByFkLimit(Integer typeId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获取某个种类歌手的总数量
     *
     * @param typeId - singerType主键
     * @return
     */
    @Select({
            "<script>",
            "select count(*) as count from singer",
            "<where>",
            "<if test='typeId != null'>type_id = #{typeId}</if>",
            "</where>",
            "</script>"
    })
    Integer queryByFkNumber(Integer typeId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select("select * from singer limit #{offset},#{limit}")
    @ResultMap(value = "singerResultRelation")
    List<Singer> queryAllByLimit(@Param("offset") Integer offset, @Param("limit") Integer limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param singer 实例对象
     * @return 对象列表
     */
    @Select("select * from singer")
    @ResultMap("singerResultRelation")
    List<Singer> queryAll(Singer singer);

    /**
     * 新增数据
     *
     * @param singer 实例对象
     * @return 影响行数
     */
    @Insert({"insert into singer(`name`,foreign_name,alias,sex,nationality,birthplace,date_of_birth,occupation,representative,achievement,`synopsis`,head_portrait,type_id,attention)",
            "values(#{name},#{foreignName},#{alias},#{sex},#{nationality},#{birthplace},#{dateOfBirth},#{occupation},#{representative},#{achievement},#{synopsis},#{headPortrait},#{singerType.typeId},#{attention})"})
    @Options(useGeneratedKeys = true, keyColumn = "singer_id", keyProperty = "singerId")
    int insert(Singer singer);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param singers List<Singer> 实例对象列表
     * @return 影响行数
     */
    @Insert({
            "<script>",
            "insert into singer(`name`,foreign_name,alias,sex,nationality,birthplace,date_of_birth,occupation,representative,achievement,`synopsis`,head_portrait,type_id,attention)",
            "values",
            "<foreach item='singer' collection='singers' separator=','>",
            "(#{singer.name},#{singer.foreignName},#{singer.alias},#{singer.sex},#{singer.nationality},#{singer.birthplace},#{singer.dateOfBirth},#{singer.occupation},#{singer.representative},#{singer.achievement},#{singer.synopsis},#{singer.headPortrait},#{singer.singerType.typeId},#{singer.attention})",
            "</foreach>",
            "</script>"
    })
    @Options(useGeneratedKeys = true, keyColumn = "singer_id", keyProperty = "singerId")
    int insertBatch(@Param("singers") List<Singer> singers);

    /**
     * 批量新增数据（MyBatis原生foreach方法），不包括路径
     *
     * @param singers List<Singer> 实例对象列表
     * @return 影响行数
     */
    @Insert({
            "<script>",
            "insert into singer(`name`,foreign_name,alias,sex,nationality,birthplace,date_of_birth,occupation,representative,achievement,`synopsis`,type_id,attention)",
            "values",
            "<foreach item='singer' collection='singers' separator=','>",
            "(#{singer.name},#{singer.foreignName},#{singer.alias},#{singer.sex},#{singer.nationality},#{singer.birthplace},#{singer.dateOfBirth},#{singer.occupation},#{singer.representative},#{singer.achievement},#{singer.synopsis},#{singer.singerType.typeId},#{singer.attention})",
            "</foreach>",
            "</script>"
    })
    @Options(useGeneratedKeys = true, keyColumn = "singer_id", keyProperty = "singerId")
    int insertBatchNoUrl(@Param("singers") List<Singer> singers);


    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param singers List<Singer> 实例对象列表
     * @return 影响行数
     */
    @Insert({
            "<script>",
            "insert into singer(singer_id,`name`,foreign_name,alias,sex,nationality,birthplace,date_of_birth,occupation,representative,achievement,`synopsis`,head_portrait,type_id,attention)",
            "values",
            "<foreach item='singer' collection='singers' separator=','>",
            "(#{singer.singerId},#{singer.name},#{singer.foreignName},#{singer.alias},#{singer.sex},#{singer.nationality},#{singer.birthplace},#{singer.dateOfBirth},#{singer.occupation},#{singer.representative},#{singer.achievement},#{singer.synopsis},#{singer.headPortrait},#{singer.singerType.typeId},#{singer.attention})",
            "</foreach>",
            "on duplicate key update",
            "singer_id = values(singer_id),`name` = values(`name`),foreign_name = values(foreign_name),alias = values(alias),sex = values(sex),nationality = values(nationality)," + "birthplace = values(birthplace),date_of_birth = values(date_of_birth),",
            "occupation = values(occupation),nationality = values(nationality),representative = values(representative),nationality = values(nationality),achievement = values(achievement),`synopsis` = values(`synopsis`),head_portrait = values(head_portrait),type_id = values(type_id),attention = values(attention)",
            "</script>"
    })
    int insertOrUpdateBatch(@Param("singers") List<Singer> singers);

    /**
     * 修改数据
     *
     * @param singer 实例对象
     * @return 影响行数
     */
    @Update({"<script>",
            "update singer",
            "<set>",
            "<if test='name != null'>`name` = #{name},</if>",
            "<if test='foreignName != null'>foreign_name = #{foreignName},</if>",
            "<if test='alias != null'>alias = #{alias},</if>",
            "<if test='sex != null'>sex = #{sex},</if>",
            "<if test='nationality != null'>nationality = #{nationality},</if>",
            "<if test='birthplace != null'>birthplace = #{birthplace},</if>",
            "<if test='dateOfBirth != null'>date_of_birth = #{dateOfBirth},</if>",
            "<if test='occupation != null'>occupation = #{occupation},</if>",
            "<if test='representative != null'>representative = #{representative},</if>",
            "<if test='achievement != null'>achievement = #{achievement},</if>",
            "<if test='synopsis != null'>`synopsis` = #{synopsis},</if>",
            "<if test='headPortrait != null'>head_portrait = #{headPortrait},</if>",
            "<if test='singerType != null and singerType.typeId !=null'>type_id = #{singerType.typeId},</if>",
            "<if test='attention != null'>attention = #{attention},</if>",
            "</set>",
            "where singer_id = #{singerId}",
            "</script>"})
    int update(Singer singer);

    /**
     * 批量修改数据
     *
     * @param singers 实例对象
     * @return 影响行数
     */
    @Update({"<script>",
            "<foreach item='singer' collection='singers' separator=';'>",
            "update singer",
            "<set>",
            "<if test='singer.name != null'>`name` = #{singer.name},</if>",
            "<if test='singer.foreignName != null'>foreign_name = #{singer.foreignName},</if>",
            "<if test='singer.alias != null'>alias = #{singer.alias},</if>",
            "<if test='singer.sex != null'>sex = #{singer.sex},</if>",
            "<if test='singer.nationality != null'>nationality = #{singer.nationality},</if>",
            "<if test='singer.birthplace != null'>birthplace = #{singer.birthplace},</if>",
            "<if test='singer.dateOfBirth != null'>date_of_birth = #{singer.dateOfBirth},</if>",
            "<if test='singer.occupation != null'>occupation = #{singer.occupation},</if>",
            "<if test='singer.representative != null'>representative = #{singer.representative},</if>",
            "<if test='singer.achievement != null'>achievement = #{singer.achievement},</if>",
            "<if test='singer.synopsis != null'>`synopsis` = #{singer.synopsis},</if>",
            "<if test='singer.headPortrait != null'>head_portrait = #{singer.headPortrait},</if>",
            "<if test='singer.singerType != null and singer.singerType.typeId !=null'>type_id = #{singer.singerType.typeId},</if>",
            "<if test='singer.attention != null'>attention = #{singer.attention},</if>",
            "</set>",
            "where singer_id = #{singer.singerId}",
            "</foreach>",
            "</script>"})
    boolean updateBatch(List<Singer> singers);

    /**
     * 通过主键删除数据
     *
     * @param singerId 主键
     * @return 影响行数
     */
    @Delete("delete from singer where singer_id = #{singerId}")
    int deleteById(Integer singerId);

}

