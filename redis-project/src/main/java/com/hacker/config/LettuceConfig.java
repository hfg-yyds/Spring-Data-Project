package com.hacker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import javax.annotation.Resource;

/**
 * @Author: Zero
 * @Date: 2022/6/12 23:52
 * @Description:
 */
@Configuration
public class LettuceConfig {

    @Resource
    private RedisConfig redisConfig;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(
                new RedisStandaloneConfiguration(redisConfig.getHost(), redisConfig.getPort()));
    }

}
