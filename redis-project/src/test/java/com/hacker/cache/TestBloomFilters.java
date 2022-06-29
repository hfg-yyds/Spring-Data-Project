package com.hacker.cache;

import org.junit.jupiter.api.Test;

/**
 * @Author: Zero
 * @Date: 2022/6/29 13:30
 * @Description:
 */
public class TestBloomFilters {

    @Test
    public void test1() {
        BloomFilters bloomFilters = new BloomFilters(10);

        bloomFilters.add("2300");
        bloomFilters.add("3200");
        bloomFilters.add("4300");

        System.out.println(bloomFilters.check("4300") ? "存在" : "不存在");
        System.out.println(bloomFilters.check("4200") ? "存在" : "不存在");

    }
}
