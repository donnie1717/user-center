package com.dqzhou.usersdk.controller;

import com.dqzhou.api.UserService;
import com.dqzhou.response.UserInfo;
import com.dqzhou.usersdk.form.LoginForm;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: DonnieZhou
 * @Mail: dqzhou5180@foxmail.com
 * @Create 2020-04-11 19:33
 **/
@Controller
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Reference
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(LoginForm form) {
        UserInfo userInfo = userService.getUserById(1000000);
        logger.info("user {} login", userInfo);
        return "success";
    }

}
