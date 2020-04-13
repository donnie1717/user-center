package com.dqzhou.userservice.service;

import com.dqzhou.api.UserService;
import com.dqzhou.response.UserInfo;
import com.dqzhou.userservice.component.MemberComponent;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private MemberComponent memberComponent;

    @Override
    public void checkPassword(String username, String password) {
        memberComponent.checkPassword(username, password);
    }

    @Override
    public UserInfo getUserById(int uid) {
        return memberComponent.getMemberByUid(uid);
    }
}
