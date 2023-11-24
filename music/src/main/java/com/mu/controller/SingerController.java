package com.mu.controller;

import com.mu.entities.Singer;
import com.mu.service.SingerService;
import com.mu.util.PageUtil;
import com.mu.util.ResultPage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Singer)表控制层
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:22
 */
@RestController
@RequestMapping("singer")
public class SingerController {
    /**
     * 服务对象
     */
    @Resource
    private SingerService singerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Singer selectOne(Integer id) {
        return this.singerService.queryById(id);
    }

    /**
     * 查询用户关注的歌手
     *
     * @param userId 外键
     * @param page   页码。
     * @return 单条数据
     */
    @GetMapping(value = "selectAllLimitByUser")
    public List<Singer> selectAllLimitByUser(@RequestParam("userId") Integer userId, @RequestParam("page") Integer page, @RequestParam("eachNumber") Integer eachNumber) {
        ResultPage calculate = PageUtil.calculate(eachNumber, page);
        return this.singerService.queryByFkUser(userId, calculate.getOffset(), calculate.getLimit());
    }

    /**
     * 模糊查询歌手，分页
     *
     * @param name 歌手名
     * @param page 页码。
     * @return 单条数据
     */
    @GetMapping(value = "selectAllLimitByName")
    public List<Singer> selectAllLimitByName(@RequestParam("value") String name, @RequestParam("page") Integer page, @RequestParam("eachNumber") Integer eachNumber) {
        ResultPage calculate = PageUtil.calculate(eachNumber, page);
        return this.singerService.queryByFkName(name, calculate.getOffset(), calculate.getLimit());
    }

    /**
     * 获取某个种类部分数据
     *
     * @param typeId 歌手种类
     * @param page   当前页数
     * @return 单条数据
     */
    @GetMapping("selectTypeLimit")
    public List<Singer> selectTypeLimit(Integer typeId, Integer page) {
        ResultPage calculate = PageUtil.calculate(page);
        return this.singerService.queryByFkLimit(typeId, calculate.getOffset(), calculate.getLimit());
    }

    /**
     * 通过歌手来计算总页数
     *
     * @param userId     主键
     * @param eachNumber - 每页个数
     * @return 页码总数
     */
    @GetMapping("countByUser")
    public Integer countByUser(@RequestParam("userId") Integer userId, @RequestParam("eachNumber") Integer eachNumber) {
        Integer total = this.singerService.countByUser(userId);
        return PageUtil.calculateNumber(eachNumber, total);
    }

    /**
     * 通过名字来查询歌手数据
     *
     * @param name       歌手名称
     * @param eachNumber - 每页个数
     * @return 页码总数
     */
    @GetMapping("countByName")
    public Integer countByName(@RequestParam("value") String name, @RequestParam("eachNumber") Integer eachNumber) {
        Integer total = this.singerService.countByName(name);
        return PageUtil.calculateNumber(eachNumber, total);
    }


    /**
     * 通过种类查询歌手数据,不包括子类的查询
     *
     * @return 单条数据
     */
    @GetMapping(value = "queryRand")//{singer:{singerId:1,singerType:{typeId:1}},offset:0,limit:1},json格式
    public List<Singer> queryRand(@RequestParam(required = false) Integer typeId, @RequestParam(required = false) Integer limit) {
        return this.singerService.queryRand(typeId, limit);
    }

    /**
     * 通过种类查询歌手数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectFkLimit")
    public List<Singer> selectFkLimit(Integer id, @RequestParam("page") Integer page) {
        ResultPage calculate = PageUtil.calculate(page);
        return this.singerService.queryByFkLimit(id, calculate.getOffset(), calculate.getLimit());
    }


    /**
     * 通过种类查询歌手总数并计算出页码总数
     *
     * @param id 主键
     * @return 页码总数
     */
    @GetMapping("selectFkNumber")
    public Integer selectFkNumber(Integer id) {
        Integer total = this.singerService.queryByFkNumber(id);
        return PageUtil.calculateNumber(total);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOneRelation")
    public Singer selectOneRelation(Integer id) {
        return this.singerService.queryByIdRelation(id);
    }


    /**
     * 通过主键查询单条数据
     *
     * @param offset 起始位置
     * @param limit  个数
     * @return 单条数据
     */
    @GetMapping("selectAllLimit")
    public List<Singer> selectAllLimit(Integer offset, Integer limit) {
        return this.singerService.queryAllByLimit(offset, limit);
    }
}
