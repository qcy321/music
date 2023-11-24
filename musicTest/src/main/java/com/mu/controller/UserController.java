package com.mu.controller;

import com.mu.annotation.ResponseResult;
import com.mu.pojo.User;
import com.mu.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author qcy_java
 * @since 2021-04-27 19:17:24
 */
@ResponseResult
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    @GetMapping("test")
    public String test() {
        return "test";
    }

}
