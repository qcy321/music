package com.mu.controller;

import com.mu.entities.MvType;
import com.mu.service.MvTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MvType)表控制层
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:21
 */
@RestController
@RequestMapping("mvType")
public class MvTypeController {
    /**
     * 服务对象
     */
    @Resource
    private MvTypeService mvTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MvType selectOne(Integer typeId) {
        return this.mvTypeService.queryById(typeId);
    }

    /**
     * 查询所有数据及其子类
     *
     * @return 单条数据
     */
    @GetMapping("selectAll")
    public List<MvType> selectAll() {
        return this.mvTypeService.queryAll();
    }

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("selectAllType")
    public List<MvType> selectAllType() {
        return this.mvTypeService.queryAllType();
    }

}
