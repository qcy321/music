package com.mu.service;

import com.mu.entities.Singer;

import java.util.List;

/**
 * (Singer)表服务接口
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:21
 */
public interface SingerService {

    /**
     * 通过ID查询单条数据
     *
     * @param singerId 主键
     * @return 实例对象
     */
    Singer queryById(Integer singerId);

    /**
     * 查询用户关注的歌手，分页
     *
     * @param userId - 歌手id
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    List<Singer> queryByFkUser(Integer userId, Integer offset, Integer limit);

    /**
     * 模糊查询歌手数据
     *
     * @param name   - 歌手名
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    List<Singer> queryByFkName(String name, Integer offset, Integer limit);

    /**
     * 查询部分数据
     *
     * @param typeId - 种类编号
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    public List<Singer> queryById(Integer typeId, Integer offset, Integer limit);

    /**
     * 通过ID查询单条数据
     *
     * @param singerId 主键
     * @return 实例对象
     */
    Singer queryByIdRelation(Integer singerId);


    /**
     * 动态sql查询
     *
     * @param singer - 查询条件
     * @param offset
     * @param limit
     * @return
     */
    List<Singer> queryAllCurrent(Singer singer, Integer offset, Integer limit);

    /**
     * 计算用户关注的歌手数
     *
     * @param userId - 歌手id
     * @return
     */
    Integer countByUser(Integer userId);

    /**
     * 计算该歌手名下的数量
     *
     * @param name - 歌手名
     * @return
     */
    Integer countByName(String name);

    /**
     * 随机查询
     *
     * @param typeId - 查询条件
     * @param limit
     * @return
     */
    List<Singer> queryRand(Integer typeId, Integer limit);


    /**
     * 某个种类数量
     *
     * @param typeId - 某个种类
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    List<Singer> queryByFkLimit(Integer typeId, Integer offset, Integer limit);

    /**
     * 获取某个种类歌手总数
     *
     * @param typeId
     * @return
     */
    Integer queryByFkNumber(Integer typeId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Singer> queryAllByLimit(Integer offset, Integer limit);

    /**
     * 新增数据
     *
     * @param singer 实例对象
     * @return 实例对象
     */
    Singer insert(Singer singer);

    /**
     * 批量新增
     *
     * @param singers -实例对象
     * @return
     */
    List<Singer> insertBatch(List<Singer> singers);

    /**
     * 批量新增,不包括路径
     *
     * @param singers -实例对象
     * @return
     */
    List<Singer> insertBatchNoUrl(List<Singer> singers);

    /**
     * 批量新增或修改
     *
     * @param singers - 实例对象
     * @return
     */
    List<Singer> insertOrUpdateBatch(List<Singer> singers);

    /**
     * 修改数据
     *
     * @param singer 实例对象
     * @return 实例对象
     */
    Singer update(Singer singer);

    /**
     * 批量修改
     *
     * @param singers 实例对象
     * @return 实例对象
     */
    boolean updateBatch(List<Singer> singers);

    /**
     * 通过主键删除数据
     *
     * @param singerId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer singerId);

}
