package com.hacker.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalListener;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Constants;

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
@Slf4j
public class CaffeineCacheConfig {

    @Bean(value = "caffeineCache")
    public @NonNull Cache caffeineCache() {
        return Caffeine.newBuilder()
                //设置最后一次写入或访问后经过固定时间过期
                .expireAfterWrite(6000, TimeUnit.SECONDS)
                // 初始的缓存空间大小 不建议使用
                .initialCapacity(100)
                .removalListener((RemovalListener) (key, value, cause) ->
                        log.info(String.format("Caffeine移除了[%s]:[%s]缓存信息",key,value)))
                // 缓存的最大条数
                .maximumSize(2)
                .build();
    }

}
