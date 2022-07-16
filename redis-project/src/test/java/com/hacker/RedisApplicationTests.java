package com.hacker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RedisApplicationTests {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 测试Redis Pipleine 批量执行Redis命令
     */
    @Test
    void testPipelineTest1() {
        //执行一系列的命令,list是每一个命令的返回结果,封装成一个List
        List<Object> list = stringRedisTemplate.executePipelined((RedisCallback<Object>) connection -> {
            for (int i = 0; i < 3; i++) {
                connection.set(String.format("Name %d", i).getBytes(StandardCharsets.UTF_8), "帅气".getBytes(StandardCharsets.UTF_8));
            }
            for (int i = 0; i < 3; i++) {
                connection.get(String.format("Name %d", i).getBytes(StandardCharsets.UTF_8));
            }
            return null;
        });
        System.out.println(list);
    }

    @Test
    void sessionTest() {
        String res = stringRedisTemplate.execute(new SessionCallback<String>() {
            public String execute(RedisOperations operations) throws DataAccessException {
                for (int i = 0; i < 100; i++) {
                    operations.opsForValue().set(String.format("yunai:%d", i), "shuai02");
                }
                return (String) operations.opsForValue().get(String.format("yunai:%d", 0));
            }
        });
    }


}
