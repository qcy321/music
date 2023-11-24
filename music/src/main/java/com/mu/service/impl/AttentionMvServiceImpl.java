package com.mu.service.impl;

import com.mu.entities.AttentionMv;
import com.mu.mapper.AttentionMvMapper;
import com.mu.service.AttentionMvService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AttentionMv)表服务实现类
 *
 * @author qcy_java
 * @since 2021-05-27 15:02:34
 */
@Service("attentionMvService")
public class AttentionMvServiceImpl implements AttentionMvService {
    @Resource
    private AttentionMvMapper attentionMvMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param attentionId 主键
     * @return 实例对象
     */
    @Override
    public AttentionMv queryById(Integer attentionId) {
        return this.attentionMvMapper.queryById(attentionId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<AttentionMv> queryAllByLimit(int offset, int limit) {
        return this.attentionMvMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param attentionMv 实例对象
     * @return 实例对象
     */
    @Override
    public AttentionMv insert(AttentionMv attentionMv) {
        this.attentionMvMapper.insert(attentionMv);
        return attentionMv;
    }

    /**
     * 修改数据
     *
     * @param attentionMv 实例对象
     * @return 实例对象
     */
    @Override
    public AttentionMv update(AttentionMv attentionMv) {
        this.attentionMvMapper.update(attentionMv);
        return this.queryById(attentionMv.getAttentionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param attentionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer attentionId) {
        return this.attentionMvMapper.deleteById(attentionId) > 0;
    }
}
