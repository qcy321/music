package com.mu.service;

import com.mu.entities.MvReply;

import java.util.List;

/**
 * (MvReply)表服务接口
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:21
 */
public interface MvReplyService {

    /**
     * 通过ID查询单条数据
     *
     * @param replyId 主键
     * @return 实例对象
     */
    MvReply queryById(Integer replyId);

    /**
     * 通过ID查询单条数据
     *
     * @param replyId 主键
     * @return 实例对象
     */
    MvReply queryByIdRelation(Integer replyId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<MvReply> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mvReply 实例对象
     * @return 实例对象
     */
    MvReply insert(MvReply mvReply);

    /**
     * 修改数据
     *
     * @param mvReply 实例对象
     * @return 实例对象
     */
    //MvReply update(MvReply mvReply);

    /**
     * 通过主键删除数据
     *
     * @param replyId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer replyId);

}
