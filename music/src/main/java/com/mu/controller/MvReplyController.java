package com.mu.controller;

import com.mu.entities.MvReply;
import com.mu.service.MvReplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MvReply)表控制层
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:21
 */
@RestController
@RequestMapping("mvReply")
public class MvReplyController {
    /**
     * 服务对象
     */
    @Resource
    private MvReplyService mvReplyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MvReply selectOne(Integer id) {
        return this.mvReplyService.queryById(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOneRelation")
    public MvReply selectOneRelation(Integer id) {
        return this.mvReplyService.queryByIdRelation(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param offset 起始位置
     * @param limit 每页个数
     * @return 单条数据
     */
    @GetMapping("selectAllLimit")
    public List<MvReply> selectAllLimit(Integer offset, Integer limit) {
        return this.mvReplyService.queryAllByLimit(offset,limit);
    }

}
