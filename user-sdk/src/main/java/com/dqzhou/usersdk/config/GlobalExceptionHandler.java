package com.dqzhou.usersdk.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZhouDongqi
 * @Create 2021/10/13 上午10:21
 **/
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String, Object> exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
        Map<String, Object> result = new HashMap<>(8);
        result.put("error_code", -1);
        result.put("error_msg", "未知系统错误");

        log.info("unknown exception, error message is {}", exception.getMessage());

        // 回写状态码
        // response.addHeader("error_code", "-1");
        return result;
    }

}
