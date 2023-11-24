package com.mu.mapper;

import com.mu.entities.AlbumType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * (AlbumType)表数据库访问层
 *
 * @author qcy_java
 * @since 2021-05-30 20:32:20
 */
@Repository
public interface AlbumTypeMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    @Select("select * from album_type where type_id = #{typeId}")
    AlbumType queryById(Integer typeId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AlbumType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param albumType 实例对象
     * @return 对象列表
     */
    List<AlbumType> queryAll(AlbumType albumType);

    /**
     * 新增数据
     *
     * @param albumType 实例对象
     * @return 影响行数
     */
    int insert(AlbumType albumType);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param albumType List<AlbumType> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("albumType") List<AlbumType> albumType);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param albumType List<AlbumType> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("albumType") List<AlbumType> albumType);

    /**
     * 修改数据
     *
     * @param albumType 实例对象
     * @return 影响行数
     */
    int update(AlbumType albumType);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 影响行数
     */
    int deleteById(Integer typeId);

}

