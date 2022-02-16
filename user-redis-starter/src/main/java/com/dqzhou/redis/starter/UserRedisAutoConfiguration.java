package com.dqzhou.redis.starter;

import com.dqzhou.redis.starter.config.RedisProperties;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ZhouDongqi
 * @Create 2022/2/11 下午4:30
 **/
@EnableConfigurationProperties(value = RedisProperties.class)
@Configuration
public class UserRedisAutoConfiguration {

    private RedisProperties redisProperties;

    public UserRedisAutoConfiguration(RedisProperties redisProperties) {
        this.redisProperties = redisProperties;
    }

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress(redisProperties.getHost());
        return Redisson.create();
    }

}
