package com.mu.controller;

import com.mu.entities.MvComment;
import com.mu.service.MvCommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MvComment)表控制层
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:20
 */
@RestController
@RequestMapping("mvComment")
public class MvCommentController {
    /**
     * 服务对象
     */
    @Resource
    private MvCommentService mvCommentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MvComment selectOne(Integer id) {
        return this.mvCommentService.queryById(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOneRelation")
    public MvComment selectOneRelation(Integer id) {
        return this.mvCommentService.queryById(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param offset 起始位置
     * @param limit 每页个数
     * @return 单条数据
     */
    @GetMapping("selectAllLimit")
    public List<MvComment> selectAllLimit(Integer offset,Integer limit) {
        return this.mvCommentService.queryAllByLimit(offset,limit);
    }

}
