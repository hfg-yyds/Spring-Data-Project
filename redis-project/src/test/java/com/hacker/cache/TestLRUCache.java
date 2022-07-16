package com.hacker.cache;

import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @Author: Zero
 * @Date: 2022/6/29 11:06
 * @Description:
 */
public class TestLRUCache {

    @Test
    public void test1() {
        LRUCache<String, String> lruCache = new LRUCache<String, String>(2);
        lruCache.put("a", "aa");
        lruCache.put("b", "bb");
        for (Map.Entry<String, String> entry : lruCache.entrySet()) {
            System.out.println(entry);
        }
        System.out.println("----");
        lruCache.put("c", "cc");
        for (Map.Entry<String, String> entry : lruCache.entrySet()) {
            System.out.println(entry);
        }

        System.out.println(lruCache.get("b"));

        System.out.println("----");
        lruCache.put("d", "dd");
        for (Map.Entry<String, String> entry : lruCache.entrySet()) {
            System.out.println(entry);
        }

    }
}
