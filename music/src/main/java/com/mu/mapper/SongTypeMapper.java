package com.mu.mapper;

import com.mu.entities.SongType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (SongType)表数据库访问层
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:22
 */
public interface SongTypeMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    SongType queryById(Integer typeId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SongType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    @Select("select * from song_type")
    List<SongType> queryAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    @Select("select * from song_type")
    List<SongType> queryAllType();

    /**
     * 新增数据
     *
     * @param songType 实例对象
     * @return 影响行数
     */
    int insert(SongType songType);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param songType List<SongType> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("songType") List<SongType> songType);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param songType List<SongType> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("songType") List<SongType> songType);

    /**
     * 修改数据
     *
     * @param songType 实例对象
     * @return 影响行数
     */
    int update(SongType songType);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 影响行数
     */
    int deleteById(Integer typeId);

}

