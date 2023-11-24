package com.mu.service;

import com.mu.entities.Mv;

import java.util.List;

/**
 * (Mv)表服务接口
 *
 * @author qcy_java
 * @since 2021-04-27 19:47:58
 */
public interface MvService {

    /**
     * 通过ID查询单条数据
     *
     * @param mvId 主键
     * @return 实例对象
     */
    Mv queryById(Integer mvId);

    /**
     * 通过ID查询单条数据
     *
     * @param mvId 主键
     * @return 实例对象
     */
    Mv queryByIdRelation(Integer mvId);

    /**
     * 查询所有及其子类
     *
     * @return 实例对象
     */
    List<Mv> queryAll();


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Mv> queryAllByLimit(int offset, int limit);

    /**
     * 随机查询
     *
     * @param typeId 种类id
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Mv> queryRand(Integer typeId,Integer limit);


    /**
     * 新增数据
     *
     * @param mv 实例对象
     * @return 实例对象
     */
    Mv insert(Mv mv);

    /**
     * 批量新增
     * @param mvs -实例对象
     * @return
     */
    List<Mv> insertBatch(List<Mv> mvs);

    /**
     * 批量新增或修改
     * @param mvs - 实例对象
     * @return
     */
    List<Mv> insertOrUpdateBatch(List<Mv> mvs);

    /**
     * 修改数据
     *
     * @param mv 实例对象
     * @return 实例对象
     */
    Mv update(Mv mv);

    /**
     * 通过主键删除数据
     *
     * @param mvId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer mvId);

}
