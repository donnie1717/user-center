package com.dqzhou.userservice.util.Lock;

/**
 * @Description:
 * @Author: DonnieZhou
 * @Mail: dqzhou5180@foxmail.com
 * @Create 2020-05-30 11:16
 **/
public interface DistributedLock {

    boolean acquire(String lockeName, String requestId, long expireTime);

    boolean releaseLock(String lockName, String requestId);

}
