package com.mu.controller;

import com.mu.entities.User;
import com.mu.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * (User)表控制层
 *
 * @author qcy_java
 * @since 2021-04-27 19:36:19
 */
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

    /**
     * 登录
     *
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("login")
    public boolean login(User user, HttpSession session) {
       // System.out.println(user);
        User login = userService.Login(user);
        if (login != null) {
            session.setAttribute(session.getId(), login);//保存session数据
            System.out.println(session.getId());
            session.setMaxInactiveInterval(60 * 60 * 24 * 7);//设置七天过期时间
            return true;
        }
        return false;
    }

    /**
     * 返回登录后的数据
     *
     * @return
     */
    @GetMapping("isLogin")
    public User isLogin(HttpSession session) {
        //System.out.println(session.getId());
        User user = (User) session.getAttribute(session.getId());
        return user;
    }

    /**
     * 注销登录
     *
     * @return
     */
    @GetMapping("cancel")
    public boolean cancel(HttpSession session) {
        if (session.getAttribute(session.getId()) != null) {
            session.removeAttribute(session.getId());//移除登录状态
            return true;
        }
        return false;
    }

    /**
     * 注销登录
     *
     * @return
     */
    @GetMapping(value = "register")
    public User register(User user) {
        return userService.insert(user);
    }
}
