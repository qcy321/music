package com.mu.service.impl;

import com.mu.entities.Album;
import com.mu.mapper.AlbumMapper;
import com.mu.service.AlbumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Album)表服务实现类
 *
 * @author qcy_java
 * @since 2021-04-27 19:36:14
 */
@Service("albumService")
public class AlbumServiceImpl implements AlbumService {
    @Resource
    private AlbumMapper albumMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param albumId 主键
     * @return 实例对象
     */
    @Override
    public Album queryById(Integer albumId) {
        return this.albumMapper.queryById(albumId);
    }


    /**
     * 关联查询
     *
     * @param albumId 主键
     * @return
     */
    @Override
    public Album queryByIdRelation(Integer albumId) {
        return this.albumMapper.queryByIdRelation(albumId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Album> queryAllByLimit(int offset, int limit) {
        return this.albumMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 随机查询
     *
     * @param typeId id
     * @param limit  查询条数
     * @return
     */
    @Override
    public List<Album> queryRand(Integer typeId, Integer limit) {
        return this.albumMapper.queryRand(typeId, limit == null ? 9 : limit);
    }

    /**
     * 查询歌手专辑数量
     *
     * @param singerId - 歌手id
     * @return
     */
    @Override
    public Integer countBySinger(Integer singerId) {
        return this.albumMapper.countBySinger(singerId);
    }

    /**
     * 计算用户关注的专辑数
     *
     * @param userId - 歌手id
     * @return
     */
    @Override
    public Integer countByUser(Integer userId) {
        return this.albumMapper.countByUser(userId);
    }

    /**
     * 统计该名字下专辑数量
     *
     * @param name - 歌手id
     * @return
     */
    @Override
    public Integer countByName(String name) {
        return this.albumMapper.countByName("%" + name + "%");
    }

    /**
     * 某个种类的部分数量
     *
     * @param typeId - 某个种类
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    @Override
    public List<Album> queryByFkLimit(Integer typeId, Integer offset, Integer limit) {
        return this.albumMapper.queryByFkLimit(typeId, offset, limit);
    }

    /**
     * 歌手的专辑
     *
     * @param singerId - 歌手id
     * @param offset   - 起始
     * @param limit    - 条数
     * @return
     */
    @Override
    public List<Album> queryByFkSinger(Integer singerId, Integer offset, Integer limit) {
        return this.albumMapper.queryByFkSinger(singerId, offset, limit);
    }

    /**
     * 查询用户关注的专辑
     *
     * @param userId - 歌手id
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    @Override
    public List<Album> queryByFkUser(Integer userId, Integer offset, Integer limit) {
        return this.albumMapper.queryByFkUser(userId, offset, limit);
    }

    /**
     * 获取该专辑下数据，模糊，分页
     *
     * @param name   - 专辑名称
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    @Override
    public List<Album> queryByFkName(String name, Integer offset, Integer limit) {
        return this.albumMapper.queryByFkName("%" + name + "%", offset, limit);
    }


    /**
     * 新增数据
     *
     * @param album 实例对象
     * @return 实例对象
     */
    @Override
    public Album insert(Album album) {
        this.albumMapper.insert(album);
        return album;
    }

    /**
     * 批量新增
     *
     * @param albums -实例对象
     * @return
     */
    @Override
    public List<Album> insertBatch(List<Album> albums) {
        this.albumMapper.insertBatch(albums);
        return albums;
    }

    @Override
    public List<Album> insertBatchNoUrl(List<Album> albums) {
        this.albumMapper.insertBatchNoUrl(albums);
        return albums;
    }

    /**
     * 批量新增或更新
     *
     * @param albums - 实例对象
     * @return
     */
    @Override
    public List<Album> insertOrUpdateBatch(List<Album> albums) {
        albumMapper.insertOrUpdateBatch(albums);
        return albums;
    }

    /**
     * 修改数据
     *
     * @param album 实例对象
     * @return 实例对象
     */
    @Override
    public Album update(Album album) {
        this.albumMapper.update(album);
        return this.queryById(album.getAlbumId());
    }

    @Override
    public boolean updateBatch(List<Album> albums) {
        return this.albumMapper.updateBatch(albums);
    }

    /**
     * 通过主键删除数据
     *
     * @param albumId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer albumId) {
        return this.albumMapper.deleteById(albumId) > 0;
    }
}
