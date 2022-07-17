package com.hacker.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.benmanes.caffeine.cache.Cache;
import com.hacker.mapper.ReturnmessageMapper;
import com.hacker.po.Returnmessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Copyright @2017-2022
 *
 * @moduleName: spring-caffeine-cache
 * @className: com.hacker.utils.CaffeineUtils
 * @author: 韩福贵
 * @date: 2022-07-17
 * @version: 1.0
 */
@Component
public class CaffeineUtils {

    @Resource
    private Cache<String,String> caffeineCache;

    @Resource
    private ReturnmessageMapper returnmessageMapper;

    /**
     * 查询缓存,若缓存不存在就把本地缓存放入到Caffeine中
     * @param code code
     * @return desc
     */
    public String getReturnDesc(String code) {
        return caffeineCache.get(code,k->{
                    QueryWrapper<Returnmessage> wrapper = new QueryWrapper<>();
                    wrapper.eq(Returnmessage.CODE,k);
                    Returnmessage returnmessage = returnmessageMapper.selectOne(wrapper);
                    if (returnmessage==null) {
                        throw new RuntimeException("没有该错误码");
                    }
                    return returnmessage.getMessageDesc();
        });

//        String cacheIfPresent = caffeineCache.getIfPresent(code);
//        if (StringUtils.isNotBlank(cacheIfPresent)) {
//            return cacheIfPresent;
//        }
//        QueryWrapper<Returnmessage> wrapper = new QueryWrapper<>();
//        wrapper.eq(Returnmessage.CODE,code);
//        Returnmessage returnmessage = returnmessageMapper.selectOne(wrapper);
//        if (returnmessage==null) {
//            throw new RuntimeException("没有这个错误吗");
//        }
//        //Push缓存
//        caffeineCache.put(returnmessage.getMessageCode(),returnmessage.getMessageDesc());
//        return returnmessage.getMessageDesc();
    }


    /**
     * 添加或更新缓存
     *
     * @param key
     * @param value
     */
    public void putAndUpdateCache(String key, String value) {
        caffeineCache.put(key, value);
    }


    /**
     * 获取对象缓存
     *
     * @param key
     * @return
     */
    public <T> T getObjCacheByKey(String key, Class<T> t) {
        caffeineCache.getIfPresent(key);
        return (T) caffeineCache.asMap().get(key);
    }

    /**
     * 根据key删除缓存
     *
     * @param key
     */
    public void removeCacheByKey(String key) {
        // 从缓存中删除
        caffeineCache.asMap().remove(key);
    }
    
}