package com.mu.mapper;

import com.mu.entities.MvType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (MvType)表数据库访问层
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:21
 */
public interface MvTypeMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    @Select("select * from mv_type where type_id = #{typeId}")
    MvType queryById(Integer typeId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<MvType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     * @return 对象列表
     */
    @Select("select * from mv_type")
    List<MvType> queryAll();

    /**
     * 通过实体作为筛选条件查询
     * @return 对象列表
     */
    @Select("select * from mv_type")
    List<MvType> queryAllType();

    /**
     * 新增数据
     *
     * @param mvType 实例对象
     * @return 影响行数
     */
    int insert(MvType mvType);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param mvType List<MvType> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("mvType") List<MvType> mvType);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param mvType List<MvType> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("mvType") List<MvType> mvType);

    /**
     * 修改数据
     *
     * @param mvType 实例对象
     * @return 影响行数
     */
    int update(MvType mvType);

    /**
     * 通过主键删除数据
     *
     * @param typeTd 主键
     * @return 影响行数
     */
    int deleteById(Integer typeTd);

}

