package com.userservice.facade.api;

/**
 * @Author: ZhouDongqi
 * @Create 2021/3/24 下午8:01
 **/
public interface IMessageSendApi {

    /**
     * 消息发送
     *
     * @param message 准备发送的消息
     */
    void sendMessage(String message);

}
