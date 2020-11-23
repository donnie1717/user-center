package com.dqzhou.userservice.mapper;

import com.dqzhou.common.util.UUIDUtils;
import com.dqzhou.userservice.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @Author: ZhouDongqi
 * @Create 2020/10/28 23:33
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setId(UUIDUtils.newUUID());
        user.setPassword(UUIDUtils.newUUID());
        user.setPhone(UUIDUtils.newUUID());
        user.setNickname(UUIDUtils.newUUID());
        userMapper.insert(user);
    }

}
