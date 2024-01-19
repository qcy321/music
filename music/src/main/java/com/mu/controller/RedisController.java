package com.mu.controller;

import com.mu.Lock.RedisLock;
import com.mu.Lock.RedisLockEntity;
import com.mu.annotation.ResponseResult;
import com.mu.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@ResponseResult
public class RedisController {

    //@Autowired
    private RedisTemplate<String, Object> redisTemplate;

    //@Autowired
    private RedisLock lock;

    public static int f = 100;

    @RequestMapping("/de")
    public int de() {
        System.out.println(--f);
        return f;
    }

    @RequestMapping("/us")
    public User er() {
        User user = new User();
        user.setId(1001);
        user.setHeadPortrait("1155");
        return user;
    }

    @RequestMapping("/buy")
    public String buy(HttpServletRequest request) {
        RedisLockEntity buy1 = new RedisLockEntity("buy", request.getLocalAddr());
        boolean buy = lock.lock(buy1);
        if (buy) {
            redisTemplate.opsForValue().decrement("num");
            lock.unlock(buy1);
            return "购买成功";
        }
        return "当前人数较多，请稍后再试";
    }
}

