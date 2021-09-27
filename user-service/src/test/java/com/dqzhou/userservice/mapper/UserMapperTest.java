package com.dqzhou.userservice.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dqzhou.common.util.UUIDUtils;
import com.dqzhou.userservice.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

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
        String phone = "13055653558";

        User user = new User();
        user.setId(UUIDUtils.newUUID());
        user.setPassword(UUIDUtils.newUUID());
        user.setPhone(phone);
        user.setNickname(UUIDUtils.newUUID());
        userMapper.insert(user);

        QueryWrapper<User> query = Wrappers.query();
        query.eq("phone", phone);
        User dbUser = userMapper.selectOne(query);

        assertEquals(user.getId(), dbUser.getId());
    }



}
