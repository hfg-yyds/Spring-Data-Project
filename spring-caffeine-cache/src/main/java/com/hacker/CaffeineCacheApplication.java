package com.hacker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Copyright @2017-2022
 *
 * @moduleName: spring-caffeine-cache
 * @className: com.hacker.CaffeineCacheApplication
 * @author: 韩福贵
 * @date: 2022-07-16
 * @version: 1.0
 */
@SpringBootApplication
@EnableCaching
public class CaffeineCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(CaffeineCacheApplication.class,args);
    }
}
