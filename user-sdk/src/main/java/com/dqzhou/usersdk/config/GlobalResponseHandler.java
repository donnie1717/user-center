package com.dqzhou.usersdk.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Map;

/**
 * @Author: ZhouDongqi
 * @Create 2021/10/13 上午10:44
 **/
@ControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof Map) {
            Map<String, Object> result = (Map<String, Object>) o;
            if (result.containsKey("error_code")) {
                serverHttpResponse.getHeaders().add("error_code", String.valueOf(result.get("error_code")));
            }
        }
        return o;
    }
}
