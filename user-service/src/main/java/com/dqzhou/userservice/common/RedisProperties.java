package com.dqzhou.userservice.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static com.dqzhou.userservice.common.RedisProperties.PREFIX;

/**
 * @Description:
 * @Author: DonnieZhou
 * @Mail: dqzhou5180@foxmail.com
 * @Create 2020-06-01 23:08
 **/
@Data
@Component
@ConfigurationProperties(prefix = PREFIX)
public class RedisProperties {

    public static final String PREFIX = "uc.redis";

    private String host;
}
