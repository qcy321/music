package com.mu.service.impl;

import com.mu.entities.Reply;
import com.mu.mapper.ReplyMapper;
import com.mu.service.ReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Reply)表服务实现类
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:21
 */
@Service("replyService")
public class ReplyServiceImpl implements ReplyService {
    @Resource
    private ReplyMapper replyMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param replyId 主键
     * @return 实例对象
     */
    @Override
    public Reply queryById(Integer replyId) {
        return this.replyMapper.queryById(replyId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Reply> queryAllByLimit(int offset, int limit) {
        return this.replyMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param reply 实例对象
     * @return 实例对象
     */
    @Override
    public Reply insert(Reply reply) {
        reply.setContentTime(new Date());
        this.replyMapper.insert(reply);
        return reply;
    }


    /**
     * 通过主键删除数据
     *
     * @param replyId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer replyId) {
        return this.replyMapper.deleteById(replyId) > 0;
    }
}
