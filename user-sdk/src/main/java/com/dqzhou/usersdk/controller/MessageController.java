package com.dqzhou.usersdk.controller;

import com.dqzhou.common.constants.UserCenterConstants;
import com.dqzhou.usersdk.form.SendMessageForm;
import com.userservice.facade.api.IMessageSendApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ZhouDongqi
 * @Create 2021/3/24 下午7:57
 **/
@RestController
@RequestMapping(value = "/message")
@Api(tags = "消息推送接口")
public class MessageController {

    @DubboReference(version = UserCenterConstants.DUBBO_DEFAULT_VERSION)
    private IMessageSendApi messageSendApi;

    @ApiOperation("消息发送")
    @PostMapping("/send")
    @ResponseBody
    public String send(@RequestBody SendMessageForm form) {
        messageSendApi.sendMessage(form.getMessage());
        return "success";
    }

}
