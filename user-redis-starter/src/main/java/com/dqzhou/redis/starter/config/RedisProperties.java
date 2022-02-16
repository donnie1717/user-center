package com.dqzhou.redis.starter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static com.dqzhou.redis.starter.config.RedisProperties.PREFIX;

/**
 * @Author: ZhouDongqi
 * @Create 2022/2/11 下午4:27
 **/
@Data
@ConfigurationProperties(prefix = PREFIX)
public class RedisProperties {

    public static final String PREFIX = "uc.redis";

    private String host;
}
