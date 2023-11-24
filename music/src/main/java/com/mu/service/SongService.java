package com.mu.service;

import com.mu.entities.Song;

import java.util.List;

/**
 * (Song)表服务接口
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:22
 */
public interface SongService {

    /**
     * 通过ID查询单条数据
     *
     * @param songId 主键
     * @return 实例对象
     */
    Song queryById(Integer songId);

    /**
     * 通过ID查询单条数据
     *
     * @param songId 主键
     * @return 实例对象
     */
    Song queryByIdRelation(Integer songId);

    /**
     * 通过ID查询单条数据及mv数据
     *
     * @param songId 主键
     * @return 实例对象
     */
    Song queryByIdAndMv(Integer songId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Song> queryAllByLimit(int offset, int limit);

    /**
     * 随机查询
     *
     * @param typeId id
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Song> queryRand(Integer typeId, Integer limit);

    /**
     * 某个种类数量
     *
     * @param typeId - 某个种类
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    List<Song> queryByFkLimit(Integer typeId, Integer offset, Integer limit);

    /**
     * 获取某个种类歌曲的总数量
     *
     * @param typeId - songType主键
     * @return
     */
    Integer queryByFkNumber(Integer typeId);


    /**
     * 计算歌手歌曲数目
     *
     * @param singerId - 歌手id
     * @return
     */
    Integer countBySinger(Integer singerId);

    /**
     * 计算专辑歌曲数目
     *
     * @param albumId - 歌手id
     * @return
     */
    Integer countByAlbum(Integer albumId);

    /**
     * 计算专辑歌曲数目
     *
     * @param userId - 用户id
     * @return
     */
    Integer countByUser(Integer userId);

    /**
     * 通过模糊查询计算歌曲数目
     *
     * @param name - 歌曲名称
     * @return
     */
    Integer countByName(String name);

    /**
     * 查询歌手的歌曲，分页
     *
     * @param singerId - 歌手id
     * @param offset   - 起始
     * @param limit    - 条数
     * @return
     */
    List<Song> queryByFkSinger(Integer singerId, Integer offset, Integer limit);

    /**
     * 查询专辑的歌曲，分页
     *
     * @param albumId - 歌手id
     * @param offset  - 起始
     * @param limit   - 条数
     * @return
     */
    List<Song> queryByFkAlbum(Integer albumId, Integer offset, Integer limit);

    /**
     * 查询用户关注的歌曲，分页
     *
     * @param userId - 用户id
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    List<Song> queryByFkUser(Integer userId, Integer offset, Integer limit);

    /**
     * 模糊查询歌曲数据，分页
     *
     * @param name - 歌曲名
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    List<Song> queryByFkName(String name, Integer offset, Integer limit);

    /**
     * 新增数据
     *
     * @param song 实例对象
     * @return 实例对象
     */
    Song insert(Song song);

    /**
     * 批量新增
     *
     * @param songs -实例对象
     * @return
     */
    List<Song> insertBatch(List<Song> songs);

    /**
     * 批量新增
     *
     * @param songs -实例对象
     * @return
     */
    List<Song> insertBatchNoUrl(List<Song> songs);

    /**
     * 批量新增或修改
     *
     * @param songs - 实例对象
     * @return
     */
    List<Song> insertOrUpdateBatch(List<Song> songs);

    /**
     * 修改数据
     *
     * @param song 实例对象
     * @return 实例对象
     */
    Song update(Song song);

    /**
     * 批量数据
     *
     * @param songs 实例对象
     * @return 实例对象
     */
    boolean updateBatch(List<Song> songs);

    /**
     * 通过主键删除数据
     *
     * @param songId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer songId);

}
