package com.mu.Lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RedisLock {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 加锁，自旋重试三次
     *
     * @param redisLockEntity 锁实体
     * @return
     */
    public boolean lock(RedisLockEntity redisLockEntity) {
        boolean locked = false;
        int tryCount = 3;
        while (!locked && tryCount > 0) {
            locked = redisTemplate.opsForValue().setIfAbsent(redisLockEntity.getLockKey(), redisLockEntity.getRequestId(), 20, TimeUnit.SECONDS);
            tryCount--;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                log.error("线程被中断" + Thread.currentThread().getId(), e);
            }
        }
        return locked;
    }

    /**
     * 非原子解锁，可能解别人锁，不安全
     *
     * @param redisLockEntity
     * @return
     */
    public boolean unlock(RedisLockEntity redisLockEntity) {
        if (redisLockEntity == null || redisLockEntity.getLockKey() == null || redisLockEntity.getRequestId() == null)
            return false;
        boolean releaseLock = false;
        String requestId = (String) redisTemplate.opsForValue().get(redisLockEntity.getLockKey());
        try {
            if (redisLockEntity.getRequestId().equals(requestId)) {
                releaseLock = redisTemplate.delete(redisLockEntity.getLockKey());
            }
        } catch (Exception e) {
            return false;//发生异常直接返回
        }
        return releaseLock;
    }

    /**
     * 使用lua脚本解锁，不会解除别人锁
     *
     * @param redisLockEntity
     * @return
     */
    public boolean unlockLua(RedisLockEntity redisLockEntity) {
        if (redisLockEntity == null || redisLockEntity.getLockKey() == null || redisLockEntity.getRequestId() == null)
            return false;
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript();
        //用于解锁的lua脚本位置
        redisScript.setLocation(new ClassPathResource("unlock.lua"));
        redisScript.setResultType(Long.class);
        //没有指定序列化方式，默认使用上面配置的
        Object result = redisTemplate.execute(redisScript, Arrays.asList(redisLockEntity.getLockKey()), redisLockEntity.getRequestId());
        return result.equals(Long.valueOf(1));
    }
}

