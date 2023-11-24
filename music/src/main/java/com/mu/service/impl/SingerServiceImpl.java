package com.mu.service.impl;

import com.mu.entities.Singer;
import com.mu.mapper.SingerMapper;
import com.mu.service.SingerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Singer)表服务实现类
 *
 * @author qcy_java
 * @since 2021-04-27 19:48:22
 */
@Service("singerService")
public class SingerServiceImpl implements SingerService {
    @Resource
    private SingerMapper singerMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param singerId 主键
     * @return 实例对象
     */
    @Override
    public Singer queryById(Integer singerId) {
        return this.singerMapper.queryById(singerId);
    }


    /**
     * 用户关注的歌手
     *
     * @param userId - 歌手id
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    @Override
    public List<Singer> queryByFkUser(Integer userId, Integer offset, Integer limit) {
        return this.singerMapper.queryByFkUser(userId, offset, limit);
    }

    /**
     * 通过名字模糊查询歌手，分页
     *
     * @param name   - 歌手名
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    @Override
    public List<Singer> queryByFkName(String name, Integer offset, Integer limit) {
        return this.singerMapper.queryByFkName("%" + name + "%", offset, limit);
    }

    /**
     * 查询部分数据
     *
     * @param typeId - 种类编号
     * @param offset - 起始
     * @param limit  - 条数
     * @return
     */
    @Override
    public List<Singer> queryById(Integer typeId, Integer offset, Integer limit) {
        return this.singerMapper.queryByFkType(typeId, offset, limit);
    }


    /**
     * 关联查询
     *
     * @param singerId 主键
     * @return
     */
    @Override
    public Singer queryByIdRelation(Integer singerId) {
        return this.singerMapper.queryByIdRelation(singerId);
    }

    @Override
    public List<Singer> queryAllCurrent(Singer singer, Integer offset, Integer limit) {
        return this.singerMapper.queryAllCurrent(singer, offset, limit);
    }

    /**
     * 用户关注歌手的总数
     *
     * @param userId - 歌手id
     * @return
     */
    @Override
    public Integer countByUser(Integer userId) {
        return this.singerMapper.countByUser(userId);
    }

    /**
     * 通过歌手名，统计数量
     *
     * @param name - 歌手名
     * @return
     */
    @Override
    public Integer countByName(String name) {
        return this.singerMapper.countByName("%" + name + "%");
    }

    /**
     * 随机查询
     *
     * @param typeId 主键
     * @return
     */
    @Override
    public List<Singer> queryRand(Integer typeId, Integer limit) {
        return singerMapper.queryRand(typeId, limit == null ? 9 : limit);
    }

    /**
     * 根据种类id查询部分歌手
     *
     * @param typeId
     * @return
     */
    @Override
    public List<Singer> queryByFkLimit(Integer typeId, Integer offset, Integer limit) {
        return this.singerMapper.queryByFkLimit(typeId, offset, limit);
    }

    /**
     * 根据种类id总数
     *
     * @param typeId
     * @return
     */
    @Override
    public Integer queryByFkNumber(Integer typeId) {
        return this.singerMapper.queryByFkNumber(typeId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Singer> queryAllByLimit(Integer offset, Integer limit) {
        return this.singerMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param singer 实例对象
     * @return 实例对象
     */
    @Override
    public Singer insert(Singer singer) {
        this.singerMapper.insert(singer);
        return singer;
    }

    /**
     * 批量新增
     *
     * @param singers -实例对象
     * @return
     */
    @Override
    public List<Singer> insertBatch(List<Singer> singers) {
        this.singerMapper.insertBatch(singers);
        return singers;
    }

    /**
     * 不插入路径
     *
     * @param singers -实例对象
     * @return
     */
    @Override
    public List<Singer> insertBatchNoUrl(List<Singer> singers) {
        this.singerMapper.insertBatchNoUrl(singers);
        return singers;
    }

    /**
     * 批量新增或修改
     *
     * @param singers - 实例对象
     * @return
     */
    @Override
    public List<Singer> insertOrUpdateBatch(List<Singer> singers) {
        this.singerMapper.insertOrUpdateBatch(singers);
        return singers;
    }

    /**
     * 修改数据
     *
     * @param singer 实例对象
     * @return 实例对象
     */
    @Override
    public Singer update(Singer singer) {
        this.singerMapper.update(singer);
        return this.queryById(singer.getSingerId());
    }

    @Override
    public boolean updateBatch(List<Singer> singers) {
        return this.singerMapper.updateBatch(singers);
    }

    /**
     * 通过主键删除数据
     *
     * @param singerId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer singerId) {
        return this.singerMapper.deleteById(singerId) > 0;
    }
}
