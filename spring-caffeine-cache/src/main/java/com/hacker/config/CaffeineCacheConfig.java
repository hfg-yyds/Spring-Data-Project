package com.hacker.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Copyright @2017-2022
 *
 * @moduleName: spring-caffeine-cache
 * @className: com.hacker.config.CaffeineCacheConfig
 * @author: 韩福贵
 * @date: 2022-07-16
 * @version: 1.0
 */
@Configuration
public class CaffeineCacheConfig {

    @Bean
    public Cache<String, String> caffeineCache() {
        return Caffeine.newBuilder()
                // 设置最后一次写入或访问后经过固定时间过期
                .expireAfterWrite(6000, TimeUnit.SECONDS)
                // 初始的缓存空间大小
                .initialCapacity(100)
                // 缓存的最大条数
                .maximumSize(1000)
                .build();
    }

}
