package com.mu.service.impl;

import com.mu.config.StoragePathProperties;
import com.mu.entities.User;
import com.mu.mapper.UserMapper;
import com.mu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author qcy_java
 * @since 2021-04-27 19:36:19
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Autowired
    private StoragePathProperties properties;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 验证账号的登录
     *
     * @param user 主键
     * @return - 登录成功返回true
     */
    @Override
    public User Login(User user) {
        String psw = userMapper.queryByPsw(user);
        if (psw == null)
            return null;
        if (psw.equals(user.getPsw())) {
            User user1 = userMapper.queryById(user.getId());
            return user1;
        } else {
            return null;
        }
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        if (user.getHeadPortrait() == null) {
            user.setHeadPortrait(properties.commonHeadPath());
        }
        this.userMapper.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userMapper.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userMapper.deleteById(id) > 0;
    }
}
