package com.mu.service.impl;

import com.mu.entities.Song;
import com.mu.mapper.SongMapper;
import com.mu.service.SongService;
import com.mu.util.ReadUrlUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Song)表服务实现类
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:22
 */
@Service("songService")
public class SongServiceImpl implements SongService {

    @Resource
    private SongMapper songMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param songId 主键
     * @return 实例对象
     */
    @Override
    public Song queryById(Integer songId) {
        Song song = this.songMapper.queryById(songId);
        if (song != null) {
            try {
                song.setLyric(ReadUrlUtil.read(song.getLyric()));
            } catch (Exception e) {
                System.out.println("服务器连接失败");
            }
        }
        return song;
    }

    @Override
    public Song queryByIdRelation(Integer songId) {
        return this.songMapper.queryByIdRelation(songId);
    }

    @Override
    public Song queryByIdAndMv(Integer songId) {
        return this.songMapper.queryByIdAndMv(songId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Song> queryAllByLimit(int offset, int limit) {
        return this.songMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 随机查询
     *
     * @param typeId id
     * @param limit  查询条数
     * @return
     */
    @Override
    public List<Song> queryRand(Integer typeId, Integer limit) {
        return this.songMapper.queryRand(typeId, limit == null ? 9 : limit);
    }


    /**
     * 某个种类部分数据
     *
     * @param typeId - 某个种类
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    @Override
    public List<Song> queryByFkLimit(Integer typeId, Integer offset, Integer limit) {
        return this.songMapper.queryByFkLimit(typeId, offset, limit);
    }

    /**
     * 某个种类总数
     *
     * @param typeId - songType主键
     * @return
     */
    @Override
    public Integer queryByFkNumber(Integer typeId) {
        return this.songMapper.queryByFkNumber(typeId);
    }

    /**
     * 计算歌手的歌曲数
     *
     * @param singerId - 歌手id
     * @return
     */
    @Override
    public Integer countBySinger(Integer singerId) {
        return songMapper.countBySinger(singerId);
    }

    /**
     * 计算专辑的歌曲数
     *
     * @param albumId - 歌手id
     * @return
     */
    @Override
    public Integer countByAlbum(Integer albumId) {
        return songMapper.countByAlbum(albumId);
    }

    /**
     * 统计用户关注的歌曲数量
     *
     * @param userId - 用户id
     * @return
     */
    @Override
    public Integer countByUser(Integer userId) {
        return songMapper.countByUser(userId);
    }

    /**
     * 统计该名字下歌曲的数目
     *
     * @param name - 歌曲名称
     * @return
     */
    @Override
    public Integer countByName(String name) {
        return songMapper.countByName("%" + name + "%");
    }

    /**
     * 查询歌手的部分歌曲
     *
     * @param singerId - 歌手id
     * @param offset   - 起始
     * @param limit    - 条数
     * @return
     */
    @Override
    public List<Song> queryByFkSinger(Integer singerId, Integer offset, Integer limit) {
        return this.songMapper.queryByFkSinger(singerId, offset, limit);
    }

    /**
     * 查询专辑的部分歌曲
     *
     * @param albumId - 歌手id
     * @param offset  - 起始
     * @param limit   - 条数
     * @return
     */
    @Override
    public List<Song> queryByFkAlbum(Integer albumId, Integer offset, Integer limit) {
        return this.songMapper.queryByFkAlbum(albumId, offset, limit);
    }

    /**
     * 获取用户关注的数据
     *
     * @param userId - 用户id
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    @Override
    public List<Song> queryByFkUser(Integer userId, Integer offset, Integer limit) {
        return this.songMapper.queryByFkUser(userId, offset, limit);
    }


    /**
     * 模糊查询数据
     *
     * @param name   - 歌曲名
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    @Override
    public List<Song> queryByFkName(String name, Integer offset, Integer limit) {
        return this.songMapper.queryByFkName("%" + name + "%", offset, limit);
    }

    /**
     * 新增数据
     *
     * @param song 实例对象
     * @return 实例对象
     */
    @Override
    public Song insert(Song song) {
        this.songMapper.insert(song);
        return song;
    }

    /**
     * 批量新增
     *
     * @param songs -实例对象
     * @return
     */
    @Override
    public List<Song> insertBatch(List<Song> songs) {
        songMapper.insertBatch(songs);
        return songs;
    }

    @Override
    public List<Song> insertBatchNoUrl(List<Song> songs) {
        songMapper.insertBatchNoUrl(songs);
        return songs;
    }

    /**
     * 批量新增或修改
     *
     * @param songs - 实例对象
     * @return
     */
    @Override
    public List<Song> insertOrUpdateBatch(List<Song> songs) {
        songMapper.insertOrUpdateBatch(songs);
        return songs;
    }

    /**
     * 修改数据
     *
     * @param song 实例对象
     * @return 实例对象
     */
    @Override
    public Song update(Song song) {
        this.songMapper.update(song);
        return this.queryById(song.getSongId());
    }

    @Override
    public boolean updateBatch(List<Song> songs) {
        return this.songMapper.updateBatch(songs);
    }

    /**
     * 通过主键删除数据
     *
     * @param songId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer songId) {
        return this.songMapper.deleteById(songId) > 0;
    }
}
