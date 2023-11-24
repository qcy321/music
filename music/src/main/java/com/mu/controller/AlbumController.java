package com.mu.controller;

import com.mu.entities.Album;
import com.mu.service.AlbumService;
import com.mu.util.PageUtil;
import com.mu.util.ResultPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Album)表控制层
 *
 * @author qcy_java
 * @since 2021-04-27 19:36:14
 */
@Api(tags = "专辑模块")
@RestController
@RequestMapping("album")
public class AlbumController {
    /**
     * 服务对象
     */
    @Resource
    private AlbumService albumService;

    /**
     * 通过主键查询单条数据
     *
     * @param albumId 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据", httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "其他是失败")
    })
    @GetMapping("selectOne")
    public Album selectOne(Integer albumId) {
        return this.albumService.queryById(albumId);
    }

    /**
     * 查询某个歌手的部分专辑数据，分页
     *
     * @param singerId 外键
     * @param page     页码。
     * @return 单条数据
     */
    @GetMapping(value = "selectAllLimitBySinger")
    public List<Album> selectAllLimitBySinger(@RequestParam("singerId") Integer singerId, @RequestParam("page") Integer page, @RequestParam("eachNumber") Integer eachNumber) {
        ResultPage calculate = PageUtil.calculate(eachNumber, page);
        return this.albumService.queryByFkSinger(singerId, calculate.getOffset(), calculate.getLimit());
    }

    /**
     * 查询某个歌手的部分专辑数据，分页
     *
     * @param userId 外键
     * @param page   页码。
     * @return 单条数据
     */
    @GetMapping(value = "selectAllLimitByUser")
    public List<Album> selectAllLimitByUser(@RequestParam("userId") Integer userId, @RequestParam("page") Integer page, @RequestParam("eachNumber") Integer eachNumber) {
        ResultPage calculate = PageUtil.calculate(eachNumber, page);
        return this.albumService.queryByFkUser(userId, calculate.getOffset(), calculate.getLimit());
    }

    /**
     * 通过名字查询专辑数据，分页，模糊查询
     *
     * @param name 专辑名称
     * @param page 页码。
     * @return 单条数据
     */
    @GetMapping(value = "selectAllLimitByName")
    public List<Album> selectAllLimitByName(@RequestParam("value") String name, @RequestParam("page") Integer page, @RequestParam("eachNumber") Integer eachNumber) {
        ResultPage calculate = PageUtil.calculate(eachNumber, page);
        return this.albumService.queryByFkName(name, calculate.getOffset(), calculate.getLimit());
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOneRelation")
    public Album selectOneRelation(Integer id) {
        return this.albumService.queryByIdRelation(id);
    }


    /**
     * 通过主键查询单条数据
     *
     * @param offset 起始
     * @param limit  个数
     * @return 单条数据
     */
    @GetMapping("selectAllLimit")
    public List<Album> selectAllLimit(Integer offset, Integer limit) {
        return this.albumService.queryAllByLimit(offset, limit);
    }

    /**
     * 获取某个专辑种类部分数据
     *
     * @param typeId 跟我去种类
     * @param page   当前页数
     * @return 单条数据
     */
    @GetMapping("selectTypeLimit")
    public List<Album> selectTypeLimit(Integer typeId, Integer page) {
        ResultPage calculate = PageUtil.calculate(page);
        return this.albumService.queryByFkLimit(typeId, calculate.getOffset(), calculate.getLimit());
    }

    /**
     * 通过歌手来计算总页数
     *
     * @param singerId   主键
     * @param eachNumber - 每页个数
     * @return 页码总数
     */
    @GetMapping("countBySinger")
    public Integer countBySinger(@RequestParam("singerId") Integer singerId, @RequestParam("eachNumber") Integer eachNumber) {
        Integer total = this.albumService.countBySinger(singerId);
        return PageUtil.calculateNumber(eachNumber, total);
    }

    /**
     * 求用户关注专辑页码总数
     *
     * @param userId     主键
     * @param eachNumber - 每页个数
     * @return 页码总数
     */
    @GetMapping("countByUser")
    public Integer countByUser(@RequestParam("userId") Integer userId, @RequestParam("eachNumber") Integer eachNumber) {
        Integer total = this.albumService.countByUser(userId);
        return PageUtil.calculateNumber(eachNumber, total);
    }

    /**
     * 求用户关注专辑页码总数
     *
     * @param name       专辑名称
     * @param eachNumber - 每页个数
     * @return 页码总数
     */
    @GetMapping("countByName")
    public Integer countByUser(@RequestParam("value") String name, @RequestParam("eachNumber") Integer eachNumber) {
        Integer total = this.albumService.countByName(name);
        return PageUtil.calculateNumber(eachNumber, total);
    }

    /**
     * 通过种类查询歌手数据,不包括子类的查询
     *
     * @return 单条数据
     */
    @GetMapping(value = "queryRand")//{singer:{singerId:1,singerType:{typeId:1}},offset:0,limit:1},json格式
    public List<Album> queryRand(@RequestParam(required = false) Integer typeId, @RequestParam(required = false) Integer limit) {
        return this.albumService.queryRand(typeId, limit);
    }

}
