package com.hacker.service;

/**
 * @Author: Zero
 * @Date: 2022/6/13 00:15
 * @Description:
 */
public interface RedisStringService extends RedisService {

    /**
     * 保存属性
     */
    void set(String key, Object value, long time);

    /**
     * 保存属性
     */
    void set(String key, Object value);

    /**
     * 获取属性
     */
    Object get(String key);
}
