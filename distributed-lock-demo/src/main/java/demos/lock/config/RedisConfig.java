package demos.lock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

/**
 * @author Nereus Yi
 */
@Configuration
public class RedisConfig {

    @Bean(destroyMethod = "destroy")
    public RedisLockRegistry redisLockRegistry(RedisConnectionFactory redisConnectionFactory) {
        // 需要注意，REDIS_LOCK是可配置的该锁的命名空间，需要所有地方都统一用同一个
        // 最后一个参数配置锁的默认过期时间，单位是MS
        return new RedisLockRegistry(redisConnectionFactory, "REDIS_LOCK",10000);
    }

}
