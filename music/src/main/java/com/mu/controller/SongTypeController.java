package com.mu.controller;

import com.mu.entities.SongType;
import com.mu.service.SongTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SongType)表控制层
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:22
 */
@RestController
@RequestMapping("songType")
public class SongTypeController {
    /**
     * 服务对象
     */
    @Resource
    private SongTypeService songTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SongType selectOne(Integer id) {
        return this.songTypeService.queryById(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("selectAll")
    public List<SongType> selectAll() {
        return this.songTypeService.queryAll();
    }

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("selectAllType")
    public List<SongType> selectAllType() {
        return this.songTypeService.queryAllType();
    }

}
