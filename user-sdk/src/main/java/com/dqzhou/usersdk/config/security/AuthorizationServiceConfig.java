package com.dqzhou.usersdk.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 授权服务配置
 * @Author: ZhouDongqi
 * @Create 2020/12/1 19:20
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServiceConfig extends AuthorizationServerConfigurerAdapter {

    // 基于内存存储令牌
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client") // clientId
                .secret("secret") // clientSecurity
                .authorizedGrantTypes("authorization_code") //授权码模式
                .scopes("app");
    }


}
