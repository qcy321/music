package com.mu.service;


import com.mu.entities.Album;

import java.util.List;

/**
 * (Album)表服务接口
 *
 * @author qcy_java
 * @since 2021-04-27 19:36:12
 */
public interface AlbumService {

    /**
     * 通过ID查询单条数据
     *
     * @param albumId 主键
     * @return 实例对象
     */
    Album queryById(Integer albumId);

    /**
     * 通过ID查询单条数据
     *
     * @param albumId 主键
     * @return 实例对象
     */
    Album queryByIdRelation(Integer albumId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Album> queryAllByLimit(int offset, int limit);

    /**
     * 随机查询专辑
     *
     * @param typeId id
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Album> queryRand(Integer typeId, Integer limit);

    /**
     * 计算歌手歌曲数目
     * @param singerId - 歌手id
     * @return
     */
    Integer countBySinger(Integer singerId);

    /**
     * 计算用户关注的专辑数
     * @param userId - 歌手id
     * @return
     */
    Integer countByUser(Integer userId);

    /**
     * 统计该名字下专辑数量
     * @param name - 歌手id
     * @return
     */
    Integer countByName(String name);

    /**
     * 某个种类数量
     *
     * @param typeId - 某个种类
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    List<Album> queryByFkLimit(Integer typeId, Integer offset, Integer limit);

    /**
     * 查询歌手的歌曲，分页
     * @param singerId - 歌手id
     * @param offset - 起始
     * @param limit - 条数
     * @return
     */
    List<Album> queryByFkSinger(Integer singerId, Integer offset, Integer limit);

    /**
     * 查询用户关注的专辑，分页
     * @param userId - 歌手id
     * @param offset - 起始
     * @param limit - 条数
     * @return
     */
    List<Album> queryByFkUser(Integer userId, Integer offset, Integer limit);

    /**
     * 模糊查询专辑，分页
     * @param name - 专辑名称
     * @param offset - 起始
     * @param limit - 条数
     * @return
     */
    List<Album> queryByFkName(String name, Integer offset, Integer limit);


    /**
     * 新增数据
     *
     * @param album 实例对象
     * @return 实例对象
     */
    Album insert(Album album);

    /**
     * 批量新增
     * @param albums -实例对象
     * @return
     */
    List<Album> insertBatch(List<Album> albums);

    /**
     * 批量新增
     * @param albums -实例对象
     * @return
     */
    List<Album> insertBatchNoUrl(List<Album> albums);

    /**
     * 批量新增或修改
     * @param albums - 实例对象
     * @return
     */
    List<Album> insertOrUpdateBatch(List<Album> albums);

    /**
     * 修改数据
     *
     * @param album 实例对象
     * @return 实例对象
     */
    Album update(Album album);

    /**
     * 批量数据
     *
     * @param albums 实例对象
     * @return 实例对象
     */
    boolean updateBatch(List<Album> albums);

    /**
     * 通过主键删除数据
     *
     * @param albumId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer albumId);

}
