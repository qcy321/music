package com.mu.service;


import com.mu.entities.AttentionMv;

import java.util.List;

/**
 * (AttentionMv)表服务接口
 *
 * @author qcy_java
 * @since 2021-05-27 15:02:34
 */
public interface AttentionMvService {

    /**
     * 通过ID查询单条数据
     *
     * @param attentionId 主键
     * @return 实例对象
     */
    AttentionMv queryById(Integer attentionId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AttentionMv> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param attentionMv 实例对象
     * @return 实例对象
     */
    AttentionMv insert(AttentionMv attentionMv);

    /**
     * 修改数据
     *
     * @param attentionMv 实例对象
     * @return 实例对象
     */
    AttentionMv update(AttentionMv attentionMv);

    /**
     * 通过主键删除数据
     *
     * @param attentionId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer attentionId);

}
