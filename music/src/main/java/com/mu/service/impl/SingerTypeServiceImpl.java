package com.mu.service.impl;

import com.mu.entities.SingerType;
import com.mu.mapper.SingerTypeMapper;
import com.mu.service.SingerTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Singertype)表服务实现类
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:22
 */
@Service("singerTypeService")
public class SingerTypeServiceImpl implements SingerTypeService {
    @Resource
    private SingerTypeMapper singertypeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    @Override
    public SingerType queryById(Integer typeId) {
        return this.singertypeMapper.queryById(typeId);
    }

    /**
     * 获取分类名称
     *
     * @return 实例对象
     */
    @Override
    public List<SingerType> queryAll() {
        return this.singertypeMapper.queryAll();
    }

    /**
     * 获取分类名称
     *
     * @return 实例对象
     */
    @Override
    public List<SingerType> queryAllType() {
        return this.singertypeMapper.queryAllType();
    }

    /**
     * 关联查询
     * @param typeId 主键
     * @return
     */
    @Override
    public SingerType queryByIdRelation(Integer typeId) {
        return this.singertypeMapper.queryByIdRelation(typeId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SingerType> queryAllByLimit(int offset, int limit) {
        return this.singertypeMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param singertype 实例对象
     * @return 实例对象
     */
    @Override
    public SingerType insert(SingerType singertype) {
        this.singertypeMapper.insert(singertype);
        return singertype;
    }

    /**
     * 批量新增
     * @param singerTypes -实例对象
     * @return
     */
    @Override
    public List<SingerType> insertBatch(List<SingerType> singerTypes) {
        this.singertypeMapper.insertBatch(singerTypes);
        return singerTypes;
    }

    /**
     * 批量新增与更新
     * @param singerTypes - 实例对象
     * @return
     */
    @Override
    public List<SingerType> insertOrUpdateBatch(List<SingerType> singerTypes) {
        this.singertypeMapper.insertOrUpdateBatch(singerTypes);
        return singerTypes;
    }

    /**
     * 修改数据
     *
     * @param singertype 实例对象
     * @return 实例对象
     */
    @Override
    public SingerType update(SingerType singertype) {
        this.singertypeMapper.update(singertype);
        return this.queryById(singertype.getTypeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer typeId) {
        return this.singertypeMapper.deleteById(typeId) > 0;
    }
}
