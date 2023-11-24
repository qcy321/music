package com.mu.service.impl;

import com.mu.entities.Comment;
import com.mu.mapper.CommentMapper;
import com.mu.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Comment)表服务实现类
 *
 * @author qcy_java
 * @since 2021-04-27 19:47:35
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    @Override
    public Comment queryById(Integer commentId) {
        return this.commentMapper.queryById(commentId);
    }

    @Override
    public Comment queryByIdRelation(Integer commentId) {
        return this.commentMapper.queryByIdRelation(commentId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Comment> queryAllByLimit(int offset, int limit) {
        return this.commentMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment insert(Comment comment) {
        this.commentMapper.insert(comment);
        return comment;
    }
/*
    *//**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     *//*
    @Override
    public Comment update(Comment comment) {
        this.commentMapper.update(comment);
        return this.queryById(comment.getCommentId());
    }*/

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer commentId) {
        return this.commentMapper.deleteById(commentId) > 0;
    }
}
