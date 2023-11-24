package com.mu.service.impl;

import com.mu.pojo.AttentionSong;
import com.mu.mapper.AttentionSongMapper;
import com.mu.service.AttentionSongService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AttentionSong)表服务实现类
 *
 * @author qcy_java
 * @since 2021-05-27 15:02:35
 */
@Service("attentionSongService")
public class AttentionSongServiceImpl implements AttentionSongService {
    @Resource
    private AttentionSongMapper attentionSongMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param attentionId 主键
     * @return 实例对象
     */
    @Override
    public AttentionSong queryById(Integer attentionId) {
        return this.attentionSongMapper.queryById(attentionId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<AttentionSong> queryAllByLimit(int offset, int limit) {
        return this.attentionSongMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param attentionSong 实例对象
     * @return 实例对象
     */
    @Override
    public AttentionSong insert(AttentionSong attentionSong) {
        this.attentionSongMapper.insert(attentionSong);
        return attentionSong;
    }

    /**
     * 修改数据
     *
     * @param attentionSong 实例对象
     * @return 实例对象
     */
    @Override
    public AttentionSong update(AttentionSong attentionSong) {
        this.attentionSongMapper.update(attentionSong);
        return this.queryById(attentionSong.getAttentionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param attentionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer attentionId) {
        return this.attentionSongMapper.deleteById(attentionId) > 0;
    }
}
