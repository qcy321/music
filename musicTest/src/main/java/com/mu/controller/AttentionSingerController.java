package com.mu.controller;

import com.mu.pojo.AttentionSinger;
import com.mu.service.AttentionSingerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AttentionSinger)表控制层
 *
 * @author qcy_java
 * @since 2021-05-27 15:02:34
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
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AttentionSinger selectOne(Integer id) {
        return this.attentionSingerService.queryById(id);
    }

}
