package com.dqzhou.userservice.impl;

import com.dqzhou.common.constants.UserCenterConstants;
import com.dqzhou.userservice.service.UserService;
import com.userservice.facade.dto.UserInfoDTO;
import com.userservice.facade.api.IUserInfoApi;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: ZhouDongqi
 * @Create 2020-04-11 21:54
 **/
@Component
@Service(version = UserCenterConstants.DUBBO_DEFAULT_VERSION)
public class UserInfoApi implements IUserInfoApi {

    @Autowired
    private UserService userService;

    @Override
    public void checkPassword(String username, String password) {
        userService.checkPassword(username, password);
    }

    @Override
    public UserInfoDTO getByPhone(String phone) {
        return userService.getByPhone(phone);
    }
}
