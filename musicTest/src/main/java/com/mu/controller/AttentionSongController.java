package com.mu.controller;

import com.mu.pojo.AttentionSong;
import com.mu.service.AttentionSongService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AttentionSong)表控制层
 *
 * @author qcy_java
 * @since 2021-05-27 15:02:35
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
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AttentionSong selectOne(Integer id) {
        return this.attentionSongService.queryById(id);
    }

}
