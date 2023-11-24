package com.mu.service.impl;

import com.mu.entities.SongType;
import com.mu.mapper.SongTypeMapper;
import com.mu.service.SongTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SongType)表服务实现类
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:22
 */
@Service("songTypeService")
public class SongTypeServiceImpl implements SongTypeService {
    @Resource
    private SongTypeMapper songTypeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    @Override
    public SongType queryById(Integer typeId) {
        return this.songTypeMapper.queryById(typeId);
    }

    /**
     * 查询多条数据，及其子类
     *
     * @return 对象列表
     */
    @Override
    public List<SongType> queryAll() {
        return this.songTypeMapper.queryAll();
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<SongType> queryAllType() {
        return this.songTypeMapper.queryAllType();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SongType> queryAllByLimit(int offset, int limit) {
        return this.songTypeMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param songType 实例对象
     * @return 实例对象
     */
    @Override
    public SongType insert(SongType songType) {
        this.songTypeMapper.insert(songType);
        return songType;
    }

    /**
     * 修改数据
     *
     * @param songType 实例对象
     * @return 实例对象
     */
    @Override
    public SongType update(SongType songType) {
        this.songTypeMapper.update(songType);
        return this.queryById(songType.getTypeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer typeId) {
        return this.songTypeMapper.deleteById(typeId) > 0;
    }
}
