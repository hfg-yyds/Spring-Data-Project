package com.hacker.redis.service;

import com.hacker.redis.RedisCommonService;

/**
 * @Author: Zero
 * @Date: 2022/6/13 12:21
 * @Description: Redis字符串类型(String)操作抽象类
 */
public abstract class AbstractRedisStringService extends RedisCommonService {
    /**
     * 保存属性
     */
    public abstract void set(String key, Object value, long time);

    /**
     * 保存属性
     */
    public abstract void set(String key, Object value);

    /**
     * 取值并赋值
     */
    public abstract Object getSet(String key,Object value);

    /**
     * 如果key不存在，设置key以保存字符串值
     * @param key
     * @param value
     */
    public abstract void setNx(String key,Object value);

}
