package com.mu.service;

import com.mu.pojo.AttentionSinger;

import java.util.List;

/**
 * (AttentionSinger)表服务接口
 *
 * @author qcy_java
 * @since 2021-05-27 15:02:34
 */
public interface AttentionSingerService {

    /**
     * 通过ID查询单条数据
     *
     * @param attentionId 主键
     * @return 实例对象
     */
    AttentionSinger queryById(Integer attentionId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AttentionSinger> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param attentionSinger 实例对象
     * @return 实例对象
     */
    AttentionSinger insert(AttentionSinger attentionSinger);

    /**
     * 修改数据
     *
     * @param attentionSinger 实例对象
     * @return 实例对象
     */
    AttentionSinger update(AttentionSinger attentionSinger);

    /**
     * 通过主键删除数据
     *
     * @param attentionId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer attentionId);

}
