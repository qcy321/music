package com.mu.service.impl;

import com.mu.pojo.Favorite;
import com.mu.mapper.FavoriteMapper;
import com.mu.service.FavoriteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Favorite)表服务实现类
 *
 * @author qcy_java
 * @since 2021-04-27 19:55:24
 */
@Service("favoriteService")
public class FavoriteServiceImpl implements FavoriteService {
    @Resource
    private FavoriteMapper favoriteMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param collId 主键
     * @return 实例对象
     */
    @Override
    public Favorite queryById(Integer collId) {
        return this.favoriteMapper.queryById(collId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Favorite> queryAllByLimit(int offset, int limit) {
        return this.favoriteMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param favorite 实例对象
     * @return 实例对象
     */
    @Override
    public Favorite insert(Favorite favorite) {
        this.favoriteMapper.insert(favorite);
        return favorite;
    }

    /**
     * 修改数据
     *
     * @param favorite 实例对象
     * @return 实例对象
     */
    @Override
    public Favorite update(Favorite favorite) {
        this.favoriteMapper.update(favorite);
        return this.queryById(favorite.getCollId());
    }

    /**
     * 通过主键删除数据
     *
     * @param collId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer collId) {
        return this.favoriteMapper.deleteById(collId) > 0;
    }
}
