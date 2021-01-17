package com.dqzhou.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dqzhou.userservice.entity.User;
import com.dqzhou.userservice.mapper.UserMapper;
import com.dqzhou.userservice.service.UserService;
import com.userservice.facade.dto.UserInfoDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: ZhouDongqi
 * @Create 2020-04-08 22:05
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void checkPassword(String username, String password) {

    }

    @Override
    public UserInfoDTO getByPhone(String phone) {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.eq("phone", phone);
        User user = userMapper.selectOne(queryWrapper);
        return UserInfoDTO.builder()
                .avatar(user.getAvatar())
                .nickname(user.getNickname())
                .phone(user.getPhone())
                .build();
    }
}
