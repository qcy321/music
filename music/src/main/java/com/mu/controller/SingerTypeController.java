package com.mu.controller;

import com.mu.entities.SingerType;
import com.mu.service.SingerTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Singertype)表控制层
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:22
 */
@RestController
@RequestMapping("singerType")
public class SingerTypeController {
    /**
     * 服务对象
     */
    @Resource
    private SingerTypeService singertypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SingerType selectOne(Integer id) {
        return this.singertypeService.queryById(id);
    }


    /**
     * 查询所有种类，包括子类
     *
     * @return 单条数据
     */
    @GetMapping("selectAll")
    public List<SingerType> selectAll() {
        return this.singertypeService.queryAll();
    }

    /**
     * 查询所有种类,当前
     *
     * @return 单条数据
     */
    @GetMapping("selectAllType")
    public List<SingerType> selectAllType() {
        return this.singertypeService.queryAllType();
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOneRelation")
    public SingerType selectOneRelation(Integer id) {
        return this.singertypeService.queryByIdRelation(id);
    }


    /**
     * 通过主键查询单条数据
     *
     * @param offset 起始位置
     * @param limit  个数
     * @return 单条数据
     */
    @GetMapping("selectAllLimit")
    public List<SingerType> selectAllLimit(Integer offset, Integer limit) {
        return this.singertypeService.queryAllByLimit(offset,limit);
    }

}
