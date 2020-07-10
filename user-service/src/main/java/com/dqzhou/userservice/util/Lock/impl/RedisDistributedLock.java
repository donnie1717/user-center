package com.dqzhou.userservice.util.Lock.impl;

import com.dqzhou.userservice.util.Lock.DistributedLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisCluster;

import java.util.Collections;

/**
 * @Description:
 * @Author: DonnieZhou
 * @Mail: dqzhou5180@foxmail.com
 * @Create 2020-05-30 22:28
 **/
@Component
public class RedisDistributedLock implements DistributedLock {

    @Autowired
    private JedisCluster jedisCluster;

    private static final String LOCK_SUCCESS = "ok";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final Long RELEASE_SUCCESS = 1L;

    @Override
    public boolean acquire (String lockName, String requestId, long expireTime) {
        String result = jedisCluster.set(lockName, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean releaseLock(String lockName, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedisCluster.eval(script, Collections.singletonList(lockName), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
}
