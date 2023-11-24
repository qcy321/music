package com.mu.controller;

import com.mu.entities.AttentionSinger;
import com.mu.service.AttentionSingerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AttentionSinger)表控制层
 *
 * @author qcy_java
 * @since 2021-05-27 15:03:03
 */
@RestController
@RequestMapping("attentionSinger")
public class AttentionSingerController {
    /**
     * 服务对象
     */
    @Resource
    private AttentionSingerService attentionSingerService;

    /**
     * 通过主键查询单条数据
     *
     * @param attentionSinger 实例
     * @return 单条数据
     */
    @GetMapping("isAttention")
    public boolean isAttention(AttentionSinger attentionSinger) {
        if (attentionSinger.getUserId() == null || attentionSinger.getSingerId() == null) {
            return false;
        } else {
            return this.attentionSingerService.isAttention(attentionSinger);
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
        return this.attentionSingerService.countByUserId(userId);
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AttentionSinger selectOne(Integer id) {
        return this.attentionSingerService.queryById(id);
    }


    /**
     * 关注歌手
     *
     * @param attentionSinger 对象
     * @return 单条数据
     */
    @GetMapping("insert")
    public AttentionSinger insert(AttentionSinger attentionSinger) {
        return this.attentionSingerService.insert(attentionSinger);
    }

    /**
     * 取消关注
     *
     * @param attentionSinger 对象
     * @return 结果
     */
    @GetMapping("deleteByUserAndSinger")
    public boolean deleteByUserAndSinger(AttentionSinger attentionSinger) {
        if (attentionSinger.getUserId() == null || attentionSinger.getSingerId() == null) {
            return false;
        } else {
            return this.attentionSingerService.deleteByUserAndSinger(attentionSinger);
        }
    }

}
