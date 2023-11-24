package com.mu.controller;

import com.mu.entities.Song;
import com.mu.service.SongService;
import com.mu.util.PageUtil;
import com.mu.util.ResultPage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Song)表控制层
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:22
 */
@RestController
@RequestMapping("song")
public class SongController {
    /**
     * 服务对象
     */
    @Resource
    private SongService songService;

    /**
     * 通过主键查询单条数据
     *
     * @param songId 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Song selectOne(Integer songId) {
        return this.songService.queryById(songId);
    }

    /**
     * 查询某个歌手的部分数据，分页
     *
     * @param singerId 主键
     * @param page     页码。
     * @return 单条数据
     */
    @GetMapping(value = "selectAllLimitBySinger")
    public List<Song> selectAllLimitBySinger(@RequestParam("singerId") Integer singerId, @RequestParam("page") Integer page, @RequestParam("eachNumber") Integer eachNumber) {
        ResultPage calculate = PageUtil.calculate(eachNumber, page);
        return this.songService.queryByFkSinger(singerId, calculate.getOffset(), calculate.getLimit());
    }

    /**
     * 查询某个专辑的部分数据，分页
     *
     * @param albumId 主键
     * @param page    页码。
     * @return 单条数据
     */
    @GetMapping(value = "selectAllLimitByAlbum")
    public List<Song> selectAllLimitByAlbum(@RequestParam("albumId") Integer albumId, @RequestParam("page") Integer page, @RequestParam("eachNumber") Integer eachNumber) {
        ResultPage calculate = PageUtil.calculate(eachNumber, page);
        return this.songService.queryByFkAlbum(albumId, calculate.getOffset(), calculate.getLimit());
    }

    /**
     * 查询某个用户关注的部分数据，分页
     *
     * @param userId 主键
     * @param page   页码。
     * @return 单条数据
     */
    @GetMapping(value = "selectAllLimitByUser")
    public List<Song> selectAllLimitByUser(@RequestParam("userId") Integer userId, @RequestParam("page") Integer page, @RequestParam("eachNumber") Integer eachNumber) {
        ResultPage calculate = PageUtil.calculate(eachNumber, page);
        return this.songService.queryByFkUser(userId, calculate.getOffset(), calculate.getLimit());
    }

    /**
     * 模糊查询歌曲，分页
     *
     * @param name 主键
     * @param page 页码。
     * @return 单条数据
     */
    @GetMapping(value = "selectAllLimitByName")
    public List<Song> selectAllLimitByName(@RequestParam("value") String name, @RequestParam("page") Integer page, @RequestParam("eachNumber") Integer eachNumber) {
        ResultPage calculate = PageUtil.calculate(eachNumber, page);
        return this.songService.queryByFkName(name, calculate.getOffset(), calculate.getLimit());
    }

    /**
     * 通过主键查询单条数据,及其与关联的数据
     *
     * @param songId 主键
     * @return 单条数据
     */
    @GetMapping("selectOneRelation")
    public Song selectOneRelation(Integer songId) {
        return this.songService.queryByIdRelation(songId);
    }

    /**
     * 通过主键查询单条数据,及其与关联的数据
     *
     * @param offset 起始位置
     * @param limit  每页个数
     * @return 单条数据
     */
    @GetMapping("selectAllLimit")
    public List<Song> selectAllLimit(Integer offset, Integer limit) {
        return this.songService.queryAllByLimit(offset, limit);
    }

    /**
     * 获取某个种类部分数据
     *
     * @param typeId 跟我去种类
     * @param page   当前页数
     * @return 单条数据
     */
    @GetMapping("selectTypeLimit")
    public List<Song> selectTypeLimit(Integer typeId, Integer page) {
        ResultPage calculate = PageUtil.calculate(page);
        return this.songService.queryByFkLimit(typeId, calculate.getOffset(), calculate.getLimit());
    }

    /**
     * 通过种类查询歌手总数并计算出页码总数
     *
     * @param id 主键
     * @return 页码总数
     */
    @GetMapping("selectFkNumber")
    public Integer selectFkNumber(Integer id) {
        Integer total = this.songService.queryByFkNumber(id);
        return PageUtil.calculateNumber(total);
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
        Integer total = this.songService.countBySinger(singerId);
        return PageUtil.calculateNumber(eachNumber, total);
    }

    /**
     * 通过专辑来计算总页数
     *
     * @param albumId    主键
     * @param eachNumber - 每页个数
     * @return 页码总数
     */
    @GetMapping("countByAlbum")
    public Integer countByAlbum(@RequestParam("albumId") Integer albumId, @RequestParam("eachNumber") Integer eachNumber) {
        Integer total = this.songService.countByAlbum(albumId);
        return PageUtil.calculateNumber(eachNumber, total);
    }

    /**
     * 通过用户来计算总页数
     *
     * @param userId     主键
     * @param eachNumber - 每页个数
     * @return 页码总数
     */
    @GetMapping("countByUser")
    public Integer countByUser(@RequestParam("userId") Integer userId, @RequestParam("eachNumber") Integer eachNumber) {
        Integer total = this.songService.countByUser(userId);
        return PageUtil.calculateNumber(eachNumber, total);
    }

    /**
     * 通过名字来模糊查询内容，分页查询
     *
     * @param value      - 内容
     * @param eachNumber - 每页个数
     * @return 页码总数
     */
    @GetMapping("countByName")
    public Integer countByName(@RequestParam("value") String value, @RequestParam("eachNumber") Integer eachNumber) {
        Integer total = this.songService.countByName(value);
        return PageUtil.calculateNumber(eachNumber, total);
    }

    /**
     * 通过种类查询歌手数据,不包括子类的查询
     *
     * @return 单条数据
     */
    @GetMapping(value = "queryRand")//{singer:{singerId:1,singerType:{typeId:1}},offset:0,limit:1},json格式
    public List<Song> queryRand(@RequestParam(required = false) Integer typeId, @RequestParam(required = false) Integer limit) {
        return this.songService.queryRand(typeId, limit);
    }


    @GetMapping("selectAll")
    public List<Song> selectAll() {
        return songService.queryAllByLimit(0, 2);
    }

    @GetMapping("insertBatch")
    public List<Song> insertBatch(List<Song> songs) {
        return songService.insertBatch(songs);
    }

    @GetMapping("insert")
    public Song insert(Song song) {
        return songService.insert(song);
    }

    @GetMapping("update")
    public Song update(Song song) {
        return songService.update(song);
    }

    @GetMapping("delete")
    public boolean delete(Integer id) {
        return songService.deleteById(id);
    }
}
