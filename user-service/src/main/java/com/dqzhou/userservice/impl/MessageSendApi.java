package com.dqzhou.userservice.impl;

import com.dqzhou.common.constants.UserCenterConstants;
import com.userservice.facade.api.IMessageSendApi;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: ZhouDongqi
 * @Create 2021/3/24 下午8:03
 **/
@Component
@DubboService(version = UserCenterConstants.DUBBO_DEFAULT_VERSION)
public class MessageSendApi implements IMessageSendApi {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String message) {
        amqpTemplate.convertAndSend("userDirectExchange", "userDirectRoutingKey", message);
    }
}
