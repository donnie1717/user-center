package com.dqzhou.usersdk.controller;

import com.dqzhou.common.constants.UserCenterConstants;
import com.dqzhou.usersdk.form.LoginForm;
import com.userservice.facade.api.IUserInfoApi;
import com.userservice.facade.dto.UserInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Donnie
 * @Create 2020-04-11 19:33
 **/
@Controller
@Api(tags = "登录接口")
public class UserLoginController {

    private final Logger logger = LoggerFactory.getLogger(UserLoginController.class);

    @Reference(version = UserCenterConstants.DUBBO_DEFAULT_VERSION)
    private IUserInfoApi userInfoApi;

    @ApiOperation("手机密码登录")
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody LoginForm form) {
        UserInfoDTO userInfo = userInfoApi.getByPhone(form.getPhone());
        logger.info("user {} login", userInfo);
        return "success";
    }

}
