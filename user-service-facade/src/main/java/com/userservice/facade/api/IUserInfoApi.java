package com.userservice.facade.api;

import com.userservice.facade.dto.UserInfoDTO;

/**
 * @Author: ZhouDongqi
 * @Create 2020/7/5 10:04
 **/
public interface IUserInfoApi {

    void checkPassword(String username, String password);

    UserInfoDTO getUserById(int uid);
}
