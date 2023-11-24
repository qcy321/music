package com.mu.controller;

import com.mu.entities.AttentionAlbum;
import com.mu.service.AttentionAlbumService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AttentionAlbum)表控制层
 *
 * @author qcy_java
 * @since 2021-05-27 14:59:53
 */
@RestController
@RequestMapping("attentionAlbum")
public class AttentionAlbumController {
    /**
     * 服务对象
     */
    @Resource
    private AttentionAlbumService attentionAlbumService;

    /**
     * 通过主键查询单条数据
     *
     * @param attentionAlbum 实例
     * @return 单条数据
     */
    @GetMapping("isAttention")
    public boolean isAttention(AttentionAlbum attentionAlbum) {
        if (attentionAlbum.getUserId() == null || attentionAlbum.getAlbumId() == null) {
            return false;
        } else {
            return this.attentionAlbumService.isAttention(attentionAlbum);
        }
    }

    /**
     * 统计数量
     *
     * @param userId 用户id
     * @return 单条数据
     */
    @GetMapping("countByUserId")
    public Integer countByUserId(@RequestParam Integer userId) {
        return this.attentionAlbumService.countByUserId(userId);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AttentionAlbum selectOne(Integer id) {
        return this.attentionAlbumService.queryById(id);
    }

    /**
     * 关注专辑
     *
     * @param attentionAlbum 对象
     * @return 单条数据
     */
    @GetMapping("insert")
    public AttentionAlbum insert(AttentionAlbum attentionAlbum) {
        return this.attentionAlbumService.insert(attentionAlbum);
    }

    /**
     * 取消关注
     *
     * @param attentionAlbum 对象
     * @return 结果
     */
    @GetMapping("deleteByUserAndAlbum")
    public boolean deleteByUserAndAlbum(AttentionAlbum attentionAlbum) {
        if (attentionAlbum.getUserId() == null || attentionAlbum.getAlbumId() == null) {
            return false;
        } else {
            return this.attentionAlbumService.deleteByUserAndAlbum(attentionAlbum);
        }
    }

}
