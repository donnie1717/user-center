package com.dqzhou.userservice.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
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
@Slf4j
@SpringBootTest
public class  RedisTemplateTests {

    @Autowired
    private RedissonClient redissonClient;

    @Test
    void testGet() {
        redissonClient.getBucket("kobe").set("bryant");

        String value = String.valueOf(redissonClient.getBucket("kobe").get());

        assertEquals("bryant", value);

        RLock lock = redissonClient.getLock("myLock");
        lock.lock();
    }

}
