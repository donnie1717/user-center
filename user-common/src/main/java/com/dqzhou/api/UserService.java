package com.dqzhou.api;

import com.dqzhou.response.UserInfo;

public interface UserService {

    void checkPassword(String username, String password);

    UserInfo getUserById(int uid);
}
