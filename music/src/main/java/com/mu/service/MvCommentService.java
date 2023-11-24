package com.mu.service;

import com.mu.entities.MvComment;

import java.util.List;

/**
 * (MvComment)表服务接口
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:20
 */
public interface MvCommentService {

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    MvComment queryById(Integer commentId);

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    MvComment queryByIdRelation(Integer commentId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<MvComment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mvComment 实例对象
     * @return 实例对象
     */
    MvComment insert(MvComment mvComment);

    /**
     * 修改数据
     *
     * @param mvComment 实例对象
     * @return 实例对象
     */
   // MvComment update(MvComment mvComment);

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer commentId);

}
