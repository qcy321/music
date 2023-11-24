package com.mu.controller;

import com.mu.entities.Mv;
import com.mu.service.MvService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Mv)表控制层
 *
 * @author qcy_java
 * @since 2021-04-27 19:47:58
 */
@RestController
@RequestMapping("mv")
public class MvController {
    /**
     * 服务对象
     */
    @Resource
    private MvService mvService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Mv selectOne(Integer id) {
        return this.mvService.queryById(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("selectAll")
    public List<Mv> selectAll() {
        return this.mvService.queryAll();
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOneRelation")
    public Mv selectOneRelation(Integer id) {
        return this.mvService.queryByIdRelation(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param offset 起始位置
     * @param limit 每页个数
     * @return 单条数据
     */
    @GetMapping("selectAllLimit")
    public List<Mv> selectAllLimit(Integer offset, Integer limit) {
        return this.mvService.queryAllByLimit(offset,limit);
    }

    /**
     * 通过种类查询视频数据,不包括子类的查询
     *
     * @return 单条数据
     */
    @RequestMapping(value = "queryRand")//{singer:{singerId:1,singerType:{typeId:1}},offset:0,limit:1},json格式
    public List<Mv> queryRand(@RequestParam(required = false) Integer typeId, @RequestParam(required = false) Integer limit) {
        return this.mvService.queryRand(typeId, limit);
    }

}
