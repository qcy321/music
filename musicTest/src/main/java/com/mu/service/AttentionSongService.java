package com.mu.service;

import com.mu.pojo.AttentionSong;

import java.util.List;

/**
 * (AttentionSong)表服务接口
 *
 * @author qcy_java
 * @since 2021-05-27 15:02:35
 */
public interface AttentionSongService {

    /**
     * 通过ID查询单条数据
     *
     * @param attentionId 主键
     * @return 实例对象
     */
    AttentionSong queryById(Integer attentionId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AttentionSong> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param attentionSong 实例对象
     * @return 实例对象
     */
    AttentionSong insert(AttentionSong attentionSong);

    /**
     * 修改数据
     *
     * @param attentionSong 实例对象
     * @return 实例对象
     */
    AttentionSong update(AttentionSong attentionSong);

    /**
     * 通过主键删除数据
     *
     * @param attentionId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer attentionId);

}
