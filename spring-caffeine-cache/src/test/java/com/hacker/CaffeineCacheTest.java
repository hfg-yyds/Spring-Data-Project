package com.hacker;

import com.github.benmanes.caffeine.cache.Cache;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Copyright @2017-2022
 *
 * @moduleName: spring-caffeine-cache
 * @className: com.hacker.CaffeineCacheTest
 * @author: 韩福贵
 * @date: 2022-07-16
 * @version: 1.0
 */
@SpringBootTest
@ExtendWith(Extension.class)
public class CaffeineCacheTest {
    @Autowired
    Cache<String,String> caffeineCache;
    @Test
    public void test1() {

    }
}
