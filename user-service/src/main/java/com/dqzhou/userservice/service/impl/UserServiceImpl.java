package com.dqzhou.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dqzhou.userservice.entity.User;
import com.dqzhou.userservice.mapper.UserMapper;
import com.dqzhou.userservice.service.UserService;
import com.userservice.facade.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: DonnieZhou
 * @Mail: dqzhou5180@foxmail.com
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
    public UserInfoDTO getByUserId(int uid) {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.eq("uid", uid);
        User user = userMapper.selectOne(queryWrapper);
        UserInfoDTO userInfo = UserInfoDTO.builder()
                .uid(user.getUid())
                .avatar(user.getAvatar())
                .nickname(user.getNickname())
                .username(user.getUsername()).build();
        return userInfo;
    }
}
