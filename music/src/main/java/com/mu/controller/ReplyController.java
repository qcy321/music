package com.mu.controller;

import com.mu.entities.Reply;
import com.mu.service.ReplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Reply)表控制层
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:21
 */
@RestController
@RequestMapping("reply")
public class ReplyController {
    /**
     * 服务对象
     */
    @Resource
    private ReplyService replyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Reply selectOne(Integer id) {
        return this.replyService.queryById(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOneRelation")
    public Reply selectOneRelation(Integer id) {
        return this.replyService.queryById(id);
    }


    /**
     * 通过主键查询单条数据
     *
     * @param offset 起始
     * @param limit  起始
     * @return 单条数据
     */
    @GetMapping("selectAllLimit")
    public List<Reply> selectAllLimit(Integer offset, Integer limit) {
        return this.replyService.queryAllByLimit(offset, limit);
    }

    /**
     * 回复歌手评论
     *
     * @param reply - 回复对象
     * @return
     */
    @GetMapping("insert")
    public Reply insert(Reply reply) {
        return this.replyService.insert(reply);
    }

}
