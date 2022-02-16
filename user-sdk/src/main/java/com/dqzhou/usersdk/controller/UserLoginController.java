package com.dqzhou.usersdk.controller;

import com.dqzhou.common.constants.UserCenterConstants;
import com.dqzhou.usersdk.form.LoginForm;
import com.userservice.facade.api.IUserInfoApi;
import com.userservice.facade.dto.UserInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Donnie
 * @Create 2020-04-11 19:33
 **/
@Controller
@Api(tags = "登录接口")
public class UserLoginController {

    private final Logger logger = LoggerFactory.getLogger(UserLoginController.class);

    @DubboReference(version = UserCenterConstants.DUBBO_DEFAULT_VERSION)
    private IUserInfoApi userInfoApi;

    @ApiOperation("手机密码登录")
    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody LoginForm form) {
        if (form.getPhone().startsWith("100")) {
            throw new RuntimeException("手机号码非法");
        }

        UserInfoDTO userInfo = userInfoApi.getByPhone(form.getPhone());
        logger.info("user {} login", userInfo);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "success");

        return result;
    }

}
