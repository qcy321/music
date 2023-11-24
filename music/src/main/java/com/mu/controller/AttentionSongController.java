package com.mu.controller;

import com.mu.entities.AttentionSong;
import com.mu.service.AttentionSongService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AttentionSong)表控制层
 *
 * @author qcy_java
 * @since 2021-05-27 15:03:14
 */
@RestController
@RequestMapping("attentionSong")
public class AttentionSongController {
    /**
     * 服务对象
     */
    @Resource
    private AttentionSongService attentionSongService;

    /**
     * 通过主键查询单条数据
     *
     * @param attentionSong 实例
     * @return 单条数据
     */
    @GetMapping("isAttention")
    public boolean isAttention(AttentionSong attentionSong) {
        if (attentionSong.getUserId() == null || attentionSong.getSongId() == null) {
            return false;
        } else {
            return this.attentionSongService.isAttention(attentionSong);
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
        return this.attentionSongService.countByUserId(userId);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AttentionSong selectOne(Integer id) {
        return this.attentionSongService.queryById(id);
    }

    /**
     * 关注歌曲
     *
     * @param attentionSong 对象
     * @return 单条数据
     */
    @GetMapping("insert")
    public AttentionSong insert(AttentionSong attentionSong) {
        return this.attentionSongService.insert(attentionSong);
    }

    /**
     * 取消关注
     *
     * @param attentionSong 对象
     * @return 结果
     */
    @GetMapping("deleteByUserAndSong")
    public boolean deleteByUserAndAlbum(AttentionSong attentionSong) {
        if (attentionSong.getUserId() == null || attentionSong.getSongId() == null) {
            return false;
        } else {
            return this.attentionSongService.deleteByUserAndSong(attentionSong);
        }
    }

}
