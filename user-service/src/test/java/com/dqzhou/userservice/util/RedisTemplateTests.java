package com.dqzhou.userservice.util;

import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

/**
 * @Description:
 * @Author: DonnieZhou
 * @Mail: dqzhou5180@foxmail.com
 * @Create 2020-05-30 11:27
 **/
@SpringBootTest
public class RedisTemplateTests {

    Logger logger = LoggerFactory.getLogger(RedisTemplateTests.class);

    @Autowired
    private RedissonClient redissonClient;

    @Test
    void testGet() {
        redissonClient.getBucket("kobe").set("bryant");

        String value = String.valueOf(redissonClient.getBucket("kobe").get());

        assertEquals("bryant", value);
    }

}
