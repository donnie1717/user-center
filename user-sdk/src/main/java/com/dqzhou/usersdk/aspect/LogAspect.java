package com.dqzhou.usersdk.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author: Donnie
 * @Create 2020-06-01 12:06
 **/
@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * 定义命名的切点
     */
    @Pointcut("execution(* com.dqzhou.usersdk.controller..*(..))")
    public void logRecord() {}

    @Around("logRecord()")
    public Object watchMessage(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            log.debug("request send at " + LocalDateTime.now());
            result = joinPoint.proceed();
            log.info("result is {}", result);
            log.debug("response send at " + LocalDateTime.now());
        } catch (Throwable throwable) {
            log.error("fail to send message at " + LocalDateTime.now());
        }
        return result;
    }
}
