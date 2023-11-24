package com.mu.service.impl;

import com.mu.entities.MvComment;
import com.mu.mapper.MvCommentMapper;
import com.mu.service.MvCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MvComment)表服务实现类
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:20
 */
@Service("mvCommentService")
public class MvCommentServiceImpl implements MvCommentService {
    @Resource
    private MvCommentMapper mvCommentMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    @Override
    public MvComment queryById(Integer commentId) {
        return this.mvCommentMapper.queryById(commentId);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    @Override
    public MvComment queryByIdRelation(Integer commentId) {
        return this.mvCommentMapper.queryById(commentId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<MvComment> queryAllByLimit(int offset, int limit) {
        return this.mvCommentMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mvComment 实例对象
     * @return 实例对象
     */
    @Override
    public MvComment insert(MvComment mvComment) {
        this.mvCommentMapper.insert(mvComment);
        return mvComment;
    }
/*
    *//**
     * 修改数据
     *
     * @param mvComment 实例对象
     * @return 实例对象
     *//*
    @Override
    public MvComment update(MvComment mvComment) {
        this.mvCommentMapper.update(mvComment);
        return this.queryById(mvComment.getCommentId());
    }*/

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer commentId) {
        return this.mvCommentMapper.deleteById(commentId) > 0;
    }
}
