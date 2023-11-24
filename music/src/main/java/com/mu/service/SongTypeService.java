package com.mu.service;

import com.mu.entities.SongType;

import java.util.List;

/**
 * (SongType)表服务接口
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:22
 */
public interface SongTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    SongType queryById(Integer typeId);

    /**
     * 查询所有及其子类
     *
     * @return 实例对象
     */
    List<SongType> queryAll();

    /**
     * 查询所有当前类
     *
     * @return 实例对象
     */
    List<SongType> queryAllType();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SongType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param songType 实例对象
     * @return 实例对象
     */
    SongType insert(SongType songType);

    /**
     * 修改数据
     *
     * @param songType 实例对象
     * @return 实例对象
     */
    SongType update(SongType songType);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer typeId);

}
