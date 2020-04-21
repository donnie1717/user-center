package com.dqzhou.common.rpc;

import com.dqzhou.common.response.UserInfo;

public interface UserService {

    void checkPassword(String username, String password);

    UserInfo getUserById(int uid);
}
