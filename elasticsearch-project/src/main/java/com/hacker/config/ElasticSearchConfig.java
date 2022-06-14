package com.hacker.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Zero
 * @Date: 2022/6/13 19:23
 * @Description:
 */
@ConfigurationProperties(prefix = "spring.elasticsearch")
@Component
@Data
public class ElasticSearchConfig {

    private String address;

    private String port;
}
