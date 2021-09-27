package com.dqzhou.user.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ZhouDongqi
 * @Create 2021/3/30 下午7:34
 **/
@Configuration
public class RabbitConfig {

    /**
     * 队列
     */
    @Bean
    public Queue userDirectQueue() {
        return new Queue("userDirectQueue", true);
    }

    /**
     * 直连交换器
     */
    @Bean
    public DirectExchange userDirectExchange() {
        return new DirectExchange("userDirectExchange", true, false);
    }

    /**
     * 绑定
     */
    @Bean
    public Binding userDirectBinding(Queue userDirectQueue, DirectExchange userDirectExchange) {
        return BindingBuilder.bind(userDirectQueue).to(userDirectExchange).with("userDirectRoutingKey");
    }
}
