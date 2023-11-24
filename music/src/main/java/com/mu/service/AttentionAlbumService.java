package com.mu.service;


import com.mu.entities.AttentionAlbum;

import java.util.List;

/**
 * (AttentionAlbum)表服务接口
 *
 * @author qcy_java
 * @since 2021-05-27 14:59:52
 */
public interface AttentionAlbumService {

    /**
     * 通过ID查询单条数据
     *
     * @param attentionId 主键
     * @return 实例对象
     */
    AttentionAlbum queryById(Integer attentionId);

    /**
     * 判断是否关注
     * @param attentionAlbum - 对象
     * @return
     */
    boolean isAttention(AttentionAlbum attentionAlbum);

    /**
     * 统计用户关注数量
     *
     * @param userId 外键
     * @return 实例对象
     */
    Integer countByUserId(Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AttentionAlbum> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param attentionAlbum 实例对象
     * @return 实例对象
     */
    AttentionAlbum insert(AttentionAlbum attentionAlbum);

    /**
     * 修改数据
     *
     * @param attentionAlbum 实例对象
     * @return 实例对象
     */
    AttentionAlbum update(AttentionAlbum attentionAlbum);

    /**
     * 通过主键删除数据
     *
     * @param attentionId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer attentionId);

    /**
     * 通过联合外键删除
     *
     * @param attentionAlbum 对象
     * @return 是否成功
     */
    boolean deleteByUserAndAlbum(AttentionAlbum attentionAlbum);


}
