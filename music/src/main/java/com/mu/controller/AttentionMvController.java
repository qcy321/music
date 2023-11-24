package com.mu.controller;

import com.mu.entities.AttentionMv;
import com.mu.service.AttentionMvService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AttentionMv)表控制层
 *
 * @author qcy_java
 * @since 2021-05-27 15:02:34
 */
@RestController
@RequestMapping("attentionMv")
public class AttentionMvController {
    /**
     * 服务对象
     */
    @Resource
    private AttentionMvService attentionMvService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AttentionMv selectOne(Integer id) {
        return this.attentionMvService.queryById(id);
    }

}
