package com.mu.mapper;

import com.mu.entities.SingerType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * (Singertype)表数据库访问层
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:22
 */
public interface SingerTypeMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    @Select("select * from singer_type where type_id = #{typeId}")
    @Results(id = "singerTypeResult", value = {
            @Result(property = "typeId", column = "type_id", id = true),
            @Result(property = "name", column = "name"),
    })
    SingerType queryById(Integer typeId);


    /**
     * 通过ID查询单条数据,关联查询
     *
     * @param typeId 主键
     * @return 实例对象
     */
    @Select("select * from singer_type where type_id = #{typeId}")
    @Results(id = "singerTypeRelationResult", value = {
            //@Result(property = "typeId", column = "type_id", id = true),
            //@Result(property = "name", column = "name"),
            @Result(property = "singers", column = "type_id",many = @Many(select = "com.mu.mapper.SingerMapper.queryByFk",fetchType = FetchType.EAGER)),
    })
    SingerType queryByIdRelation(Integer typeId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Select("select * from singer_type limit #{offset},#{limit}")
    @ResultMap("singerTypeRelationResult")
    List<SingerType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    @Select("select * from singer_type")
    @ResultMap("singerTypeRelationResult")
    List<SingerType> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    @Select("select * from singer_type")
    @ResultMap("singerTypeResult")
    List<SingerType> queryAllType();

    /**
     * 新增数据
     *
     * @param singerType 实例对象
     * @return 影响行数
     */
    @Insert({"insert into singer(`name`)",
            "values(#{name})"})
    @Options(useGeneratedKeys = true,keyColumn = "type_id",keyProperty = "typeId")
    int insert(SingerType singerType);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param singerTypes List<Singertype> 实例对象列表
     * @return 影响行数
     */
    @Insert({"insert into singer(`name`)",
            "values",
            "<foreach item='singerType' collection='singerTypes' separator=','>",
            "(#{singerType.name})",
            "</foreach>",
            "</script>"})
    @Options(useGeneratedKeys = true,keyColumn = "type_id",keyProperty = "typeId")
    int insertBatch(@Param("singerTypes") List<SingerType> singerTypes);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param singertype List<Singertype> 实例对象列表
     * @return 影响行数
     */
    @Insert({"insert into singer(`name`)",
            "values",
            "<foreach item='singerType' collection='singerTypes' separator=','>",
            "(#{singerType.name})",
            "</foreach>",
            "on duplicate key update",
            "`name` = values(`name`)",
            "</script>"
    })
    int insertOrUpdateBatch(@Param("singertype") List<SingerType> singertype);

    /**
     * 修改数据
     *
     * @param singerType 实例对象
     * @return 影响行数
     */
    @Update("update singer_type set `name` = #{name} where type_id = #{typeId}")
    int update(SingerType singerType);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 影响行数
     */
    @Delete("delete singer_type where type_id = #{typeId}")
    int deleteById(Integer typeId);

}

