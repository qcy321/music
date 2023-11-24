package com.mu.service;

import com.mu.entities.MvType;

import java.util.List;

/**
 * (MvType)表服务接口
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:21
 */
public interface MvTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    MvType queryById(Integer typeId);

    /**
     * 查询所有，及其子类
     *
     * @return 实例对象
     */
    List<MvType> queryAll();


    /**
     * 查询所有
     *
     * @return 实例对象
     */
    List<MvType> queryAllType();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<MvType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mvType 实例对象
     * @return 实例对象
     */
    MvType insert(MvType mvType);

    /**
     * 修改数据
     *
     * @param mvType 实例对象
     * @return 实例对象
     */
    MvType update(MvType mvType);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer typeId);

}
