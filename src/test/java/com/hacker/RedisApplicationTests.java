package com.hacker;

import com.hacker.redis.service.impl.RedisStringService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RedisApplicationTests {


    @Resource
    private RedisStringService redisStringService;

    @Test
    void testStringService() {
        System.out.println(redisStringService.hasKey("name"));
    }
}
