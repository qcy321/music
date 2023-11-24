package com.mu.service;

import com.mu.entities.SingerType;

import java.util.List;

/**
 * (Singertype)表服务接口
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:22
 */
public interface SingerTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    SingerType queryById(Integer typeId);

    /**
     * 查询所有及其子类
     * @return
     */
    List<SingerType> queryAll();

    /**
     * 查询所有当前
     * @return
     */
    List<SingerType> queryAllType();

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    SingerType queryByIdRelation(Integer typeId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SingerType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param singerType 实例对象
     * @return 实例对象
     */
    SingerType insert(SingerType singerType);

    /**
     * 批量新增
     * @param singerTypes -实例对象
     * @return
     */
    List<SingerType> insertBatch(List<SingerType> singerTypes);

    /**
     * 批量新增或修改
     * @param singerTypes - 实例对象
     * @return
     */
    List<SingerType> insertOrUpdateBatch(List<SingerType> singerTypes);


    /**
     * 修改数据
     *
     * @param singerType 实例对象
     * @return 实例对象
     */
    SingerType update(SingerType singerType);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer typeId);

}
