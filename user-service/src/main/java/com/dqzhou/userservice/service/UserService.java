package com.dqzhou.userservice.service;

import com.dqzhou.userservice.entity.User;
import com.userservice.facade.dto.UserInfoDTO;

/**
 * 用户服务
 * @Author: ZhouDongqi
 * @Create 2020/9/26 16:43
 **/
public interface UserService {

    void addUser(User user);

    void checkPassword(String username, String password);

    UserInfoDTO getByUserId(int uid);

}
