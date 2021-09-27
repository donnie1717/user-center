package com.dqzhou.common.util;

import java.util.UUID;

/**
 * UUID工具类
 * @Author: ZhouDongqi
 * @Create 2020/11/23 23:35
 **/
public class UUIDUtils {

    public static String newUUID() {
        return UUID.randomUUID().toString();
    }

}
