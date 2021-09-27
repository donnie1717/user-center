package com.dqzhou.userservice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dqzhou.userservice.entity.User;
import com.dqzhou.userservice.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootTest
@Slf4j
class UserServiceApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testSelect() {
        QueryWrapper<User> memberQueryWrapper = Wrappers.query();
        memberQueryWrapper.eq("uid", 1000000);
        User member = userMapper.selectOne(memberQueryWrapper);
        log.info("userinfo is [{}]", member.toString());
        Assertions.assertEquals("donnie", member.getNickname());
    }

    @Test
    void testSaveMember() {
        User member = User.builder()
                .nickname("donnie")
                .password("123456")
                .build();
        int rows = userMapper.insert(member);
        Assertions.assertEquals(1, rows);
    }

    @Test
    void testRedisConnect() {
        redisTemplate.opsForValue().set("Kobe","Bryant");
        System.out.println(redisTemplate.opsForValue().get("Kobe"));
    }

}
