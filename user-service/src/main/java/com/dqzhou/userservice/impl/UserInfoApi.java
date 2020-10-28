package com.dqzhou.userservice.impl;

import com.dqzhou.userservice.service.UserService;
import com.userservice.facade.dto.UserInfoDTO;
import com.userservice.facade.api.IUserInfoApi;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: DonnieZhou
 * @Mail: dqzhou5180@foxmail.com
 * @Create 2020-04-11 21:54
 **/
@Component
@Service
public class UserInfoApi implements IUserInfoApi {

    @Autowired
    private UserService userService;

    public void checkPassword(String username, String password) {
        userService.checkPassword(username, password);
    }

    public UserInfoDTO getUserById(int uid) {
        return userService.getByUserId(uid);
    }
}
