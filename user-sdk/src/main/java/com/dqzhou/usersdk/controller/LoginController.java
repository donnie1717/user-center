package com.dqzhou.usersdk.controller;

import com.dqzhou.usersdk.form.LoginForm;
import com.userservice.facade.dto.UserInfoDTO;
import com.userservice.facade.api.IUserInfoApi;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Donnie
 * @Create 2020-04-11 19:33
 **/
@Controller
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Reference
    private IUserInfoApi userService;

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody LoginForm form) {
        UserInfoDTO userInfo = userService.getByPhone(form.getPhone());
        logger.info("user {} login", userInfo);
        return "success";
    }

}
