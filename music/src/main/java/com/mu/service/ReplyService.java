package com.mu.service;

import com.mu.entities.Reply;

import java.util.List;

/**
 * (Reply)表服务接口
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:21
 */
public interface ReplyService {

    /**
     * 通过ID查询单条数据
     *
     * @param replyId 主键
     * @return 实例对象
     */
    Reply queryById(Integer replyId);
/*
    *//**
     * 通过ID查询单条数据,及其相关联的数据
     *
     * @param replyId 主键
     * @return 实例对象
     *//*
    Reply queryByIdRelation(Integer replyId);*/

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Reply> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param reply 实例对象
     * @return 实例对象
     */
    Reply insert(Reply reply);

   /* *//**
     * 修改数据
     *
     * @param reply 实例对象
     * @return 实例对象
     *//*
    Reply update(Reply reply);*/

    /**
     * 通过主键删除数据
     *
     * @param replyId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer replyId);

}
