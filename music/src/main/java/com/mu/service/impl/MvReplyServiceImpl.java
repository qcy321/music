package com.mu.service.impl;

import com.mu.entities.MvReply;
import com.mu.mapper.MvReplyMapper;
import com.mu.service.MvReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MvReply)表服务实现类
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:21
 */
@Service("mvReplyService")
public class MvReplyServiceImpl implements MvReplyService {
    @Resource
    private MvReplyMapper mvReplyMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param replyId 主键
     * @return 实例对象
     */
    @Override
    public MvReply queryById(Integer replyId) {
        return this.mvReplyMapper.queryById(replyId);
    }

    @Override
    public MvReply queryByIdRelation(Integer replyId) {
        return this.mvReplyMapper.queryByIdRelation(replyId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<MvReply> queryAllByLimit(int offset, int limit) {
        return this.mvReplyMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mvReply 实例对象
     * @return 实例对象
     */
    @Override
    public MvReply insert(MvReply mvReply) {
        this.mvReplyMapper.insert(mvReply);
        return mvReply;
    }

    /**
     * 修改数据
     *
     * @param mvReply 实例对象
     * @return 实例对象
     */
    /*@Override
    public MvReply update(MvReply mvReply) {
        this.mvReplyMapper.update(mvReply);
        return this.queryById(mvReply.getReplyId());
    }*/

    /**
     * 通过主键删除数据
     *
     * @param replyId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer replyId) {
        return this.mvReplyMapper.deleteById(replyId) > 0;
    }
}
