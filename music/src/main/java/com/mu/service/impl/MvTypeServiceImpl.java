package com.mu.service.impl;

import com.mu.entities.MvType;
import com.mu.mapper.MvTypeMapper;
import com.mu.service.MvTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MvType)表服务实现类
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:21
 */
@Service("mvTypeService")
public class MvTypeServiceImpl implements MvTypeService {
    @Resource
    private MvTypeMapper mvTypeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    @Override
    public MvType queryById(Integer typeId) {
        return this.mvTypeMapper.queryById(typeId);
    }

    /**
     * 查询所有数据及其子类
     *
     * @return 实例对象
     */
    @Override
    public List<MvType> queryAll() {
        return this.mvTypeMapper.queryAll();
    }

    /**
     * 查询所有数据
     *
     * @return 实例对象
     */
    @Override
    public List<MvType> queryAllType() {
        return this.mvTypeMapper.queryAllType();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<MvType> queryAllByLimit(int offset, int limit) {
        return this.mvTypeMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mvType 实例对象
     * @return 实例对象
     */
    @Override
    public MvType insert(MvType mvType) {
        this.mvTypeMapper.insert(mvType);
        return mvType;
    }

    /**
     * 修改数据
     *
     * @param mvType 实例对象
     * @return 实例对象
     */
    @Override
    public MvType update(MvType mvType) {
        this.mvTypeMapper.update(mvType);
        return this.queryById(mvType.getTypeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer typeId) {
        return this.mvTypeMapper.deleteById(typeId) > 0;
    }
}
