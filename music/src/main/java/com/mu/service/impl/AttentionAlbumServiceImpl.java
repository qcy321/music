package com.mu.service.impl;

import com.mu.entities.AttentionAlbum;
import com.mu.mapper.AttentionAlbumMapper;
import com.mu.service.AttentionAlbumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AttentionAlbum)表服务实现类
 *
 * @author qcy_java
 * @since 2021-05-27 14:59:53
 */
@Service("attentionAlbumService")
public class AttentionAlbumServiceImpl implements AttentionAlbumService {
    @Resource
    private AttentionAlbumMapper attentionAlbumMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param attentionId 主键
     * @return 实例对象
     */
    @Override
    public AttentionAlbum queryById(Integer attentionId) {
        return this.attentionAlbumMapper.queryById(attentionId);
    }

    /**
     * 判断是否收藏
     * @param attentionAlbum - 对象
     * @return
     */
    @Override
    public boolean isAttention(AttentionAlbum attentionAlbum) {
        return this.attentionAlbumMapper.queryByUserAndAlbum(attentionAlbum) > 0;
    }

    /**
     * 统计
     * @param userId 外键
     * @return
     */
    @Override
    public Integer countByUserId(Integer userId) {
        return this.attentionAlbumMapper.countByUserId(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<AttentionAlbum> queryAllByLimit(int offset, int limit) {
        return this.attentionAlbumMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param attentionAlbum 实例对象
     * @return 实例对象
     */
    @Override
    public AttentionAlbum insert(AttentionAlbum attentionAlbum) {
        try {
            this.attentionAlbumMapper.insert(attentionAlbum);
        } catch (Exception e) {
            return null;
        }
        return attentionAlbum;
    }

    /**
     * 修改数据
     *
     * @param attentionAlbum 实例对象
     * @return 实例对象
     */
    @Override
    public AttentionAlbum update(AttentionAlbum attentionAlbum) {
        this.attentionAlbumMapper.update(attentionAlbum);
        return this.queryById(attentionAlbum.getAttentionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param attentionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer attentionId) {
        return this.attentionAlbumMapper.deleteById(attentionId) > 0;
    }

    /**
     * 删除收藏
     * @param attentionAlbum 对象
     * @return
     */
    @Override
    public boolean deleteByUserAndAlbum(AttentionAlbum attentionAlbum) {
        return this.attentionAlbumMapper.deleteByUserAndAlbum(attentionAlbum) > 0;
    }
}
