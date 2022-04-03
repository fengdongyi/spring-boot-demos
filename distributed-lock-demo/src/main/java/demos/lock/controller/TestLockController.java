package demos.lock.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author Nereus Yi
 */
@Slf4j
@RestController
public class TestLockController {

    @Autowired
    RedisLockRegistry redisLockRegistry;

    @GetMapping("redisLock")
    public String testLock() throws InterruptedException {
        String uuid = UUID.randomUUID().toString();

        // 获取对应的锁，锁的KEY是redisTestLock，存在redis中会是
        // REDIS_LOCK:redisTestLock
        // 前缀REDIS_LOCK就是在前面配置类中配置的
        Lock redisTestLock = redisLockRegistry.obtain("redisTestLock");

        // 尝试锁定对应的KEY，最多等待5秒
        boolean locked = redisTestLock.tryLock(5, TimeUnit.SECONDS);
        if (locked) {
            try {
                log.info("get lock success...id={}", uuid);
                Thread.sleep(20000);
                log.info("execute success..id={}", uuid);
            } finally {
                redisTestLock.unlock();
            }
        }else{
            log.info("get lock failed...id={}", uuid);
        }
        return uuid;
    }

}
