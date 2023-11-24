package com.mu.controller;

import com.mu.entities.Comment;
import com.mu.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Comment)表控制层
 *
 * @author qcy_java
 * @since 2021-04-27 19:47:35
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    /**
     * 服务对象
     */
    @Resource
    private CommentService commentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Comment selectOne(Integer id) {
        return this.commentService.queryById(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOneRelation")
    public Comment selectOneRelation(Integer id) {
        return this.commentService.queryByIdRelation(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param offset 起始位置
     * @param limit  个数
     * @return 单条数据
     */
    @GetMapping("selectAllLimit")
    public List<Comment> selectAllLimit(Integer offset, Integer limit) {
        return this.commentService.queryAllByLimit(offset, limit);
    }

    /**
     * 发表评论，对某首歌曲评论
     *
     * @param comment - 评论对象
     * @return
     */
    @GetMapping("insert")
    public Comment insert(Comment comment) {
        comment.setContentTime(new Date());
        comment.setNumber(0);
        System.out.println(comment);
        //return this.commentService.insert(comment);
        return comment;
    }

}
