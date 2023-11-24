package com.mu.service.impl;

import com.mu.entities.AttentionSinger;
import com.mu.mapper.AttentionSingerMapper;
import com.mu.service.AttentionSingerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AttentionSinger)表服务实现类
 *
 * @author qcy_java
 * @since 2021-05-27 15:03:03
 */
@Service("attentionSingerService")
public class AttentionSingerServiceImpl implements AttentionSingerService {
    @Resource
    private AttentionSingerMapper attentionSingerMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param attentionId 主键
     * @return 实例对象
     */
    @Override
    public AttentionSinger queryById(Integer attentionId) {
        return this.attentionSingerMapper.queryById(attentionId);
    }

    /**
     * 是否关注
     * @param attentionSinger - 对象
     * @return
     */
    @Override
    public boolean isAttention(AttentionSinger attentionSinger) {
        return this.attentionSingerMapper.queryByUserAndSinger(attentionSinger) > 0;
    }

    /**
     * 数量
     * @param userId 外键
     * @return
     */
    @Override
    public Integer countByUserId(Integer userId) {
        return attentionSingerMapper.countByUserId(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<AttentionSinger> queryAllByLimit(int offset, int limit) {
        return this.attentionSingerMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param attentionSinger 实例对象
     * @return 实例对象
     */
    @Override
    public AttentionSinger insert(AttentionSinger attentionSinger) {
        try {
            this.attentionSingerMapper.insert(attentionSinger);
        } catch (Exception e) {
            return null;
        }
        return attentionSinger;
    }

    /**
     * 修改数据
     *
     * @param attentionSinger 实例对象
     * @return 实例对象
     */
    @Override
    public AttentionSinger update(AttentionSinger attentionSinger) {
        this.attentionSingerMapper.update(attentionSinger);
        return this.queryById(attentionSinger.getAttentionId());
    }

    @Override
    public boolean deleteByUserAndSinger(AttentionSinger attentionSinger) {
        return this.attentionSingerMapper.deleteByUserAndSinger(attentionSinger) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param attentionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer attentionId) {
        return this.attentionSingerMapper.deleteById(attentionId) > 0;
    }
}
