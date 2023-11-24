package com.mu.service.impl;

import com.mu.entities.Mv;
import com.mu.mapper.MvMapper;
import com.mu.service.MvService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Mv)表服务实现类
 *
 * @author qcy_java
 * @since 2021-04-27 19:47:58
 */
@Service("mvService")
public class MvServiceImpl implements MvService {
    @Resource
    private MvMapper mvMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param mvId 主键
     * @return 实例对象
     */
    @Override
    public Mv queryById(Integer mvId) {
        return this.mvMapper.queryById(mvId);
    }


    /**
     * 关联查询
     * @param mvId 主键
     * @return
     */
    @Override
    public Mv queryByIdRelation(Integer mvId) {
        return this.mvMapper.queryByIdRelation(mvId);
    }

    @Override
    public List<Mv> queryAll() {
        return this.mvMapper.queryAll();
    }


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Mv> queryAllByLimit(int offset, int limit) {
        return this.mvMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 随机查询
     * @param typeId 种类id
     * @param limit  查询条数
     * @return
     */
    @Override
    public List<Mv> queryRand(Integer typeId, Integer limit) {
        return this.mvMapper.queryRand(typeId,limit==null?9:limit);
    }

    /**
     * 新增数据
     *
     * @param mv 实例对象
     * @return 实例对象
     */
    @Override
    public Mv insert(Mv mv) {
        this.mvMapper.insert(mv);
        return mv;
    }

    @Override
    public List<Mv> insertBatch(List<Mv> mvs) {
        this.mvMapper.insertBatch(mvs);
        return mvs;
    }

    @Override
    public List<Mv> insertOrUpdateBatch(List<Mv> mvs) {
        this.mvMapper.insertOrUpdateBatch(mvs);
        return mvs;
    }

    /**
     * 修改数据
     *
     * @param mv 实例对象
     * @return 实例对象
     */
    @Override
    public Mv update(Mv mv) {
        this.mvMapper.update(mv);
        return this.queryById(mv.getMvId());
    }

    /**
     * 通过主键删除数据
     *
     * @param mvId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer mvId) {
        return this.mvMapper.deleteById(mvId) > 0;
    }
}
