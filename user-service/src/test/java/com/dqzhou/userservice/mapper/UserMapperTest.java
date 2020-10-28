package com.dqzhou.userservice.mapper;

import com.dqzhou.userservice.UserServiceApplication;
import com.dqzhou.userservice.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * @Author: ZhouDongqi
 * @Create 2020/10/28 23:33
 **/
@SpringBootTest(classes = UserServiceApplication.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername(UUID.randomUUID().toString());
        user.setPassword(UUID.randomUUID().toString());
        userMapper.insert(user);
    }

}
