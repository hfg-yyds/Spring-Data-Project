package com.hacker;

import com.hacker.cache.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author: Zero
 * @Date: 2022/6/23 19:54
 * @Description:
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class HashMapperTests {

    private static final String PERSON_KEY = "PERSON:%s";

    public String buildKey(String key) {
        return String.format(PERSON_KEY, key);
    }

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testHash() {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        Person person = new Person("han3", "fugui3");
    }

    private final HashMapper<Object, byte[], byte[]> mapper = new ObjectHashMapper();

    @Test
    public void testWriteHashMapper() {
        //key =1
        Person person = new Person("han2", "fugui2");
        writeHash(buildKey("2"), person);
    }

    @Test
    public void testLoadHashMapper() {
        //key =1
        Person person = loadHash(buildKey("2"));
        System.out.println(person);
    }

    public void writeHash(String key, Person person) {
        HashOperations<String, byte[], byte[]> hash = getStringHashOperations();
        Map<byte[], byte[]> mappedHash = mapper.toHash(person);
        hash.putAll(key, mappedHash);
    }

    public Person loadHash(String key) {
        HashOperations<String, byte[], byte[]> hash = getStringHashOperations();
        Map<byte[], byte[]> loadedHash = hash.entries(key);
        return (Person) mapper.fromHash(loadedHash);
    }

    private HashOperations<String, byte[], byte[]> getStringHashOperations() {
        return redisTemplate.opsForHash();
    }

}
